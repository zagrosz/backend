package pl.zagrosz.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.zagrosz.dao.entity.User;
import pl.zagrosz.dao.repository.UserRepository;
import pl.zagrosz.exception.UserWithEmailExists;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

  private final UserRepository mockedUserRepository = mock(UserRepository.class);
  private final UserService userService = new UserService(mockedUserRepository);

  @Test
  public void testRegister() {
    User userToRegister = new User(null, "testEmail", "testPassword");
    User userRegistered = new User(1L, "testEmail", "testPassword");
    when(mockedUserRepository.save(userToRegister)).thenReturn(userRegistered);
    when(mockedUserRepository.findByEmail(userToRegister.getEmail())).thenReturn(Optional.empty());

    Long savedUserId = userService.register(userToRegister);

    assertThat(savedUserId).isEqualTo(1L);
    verify(mockedUserRepository, times(1)).save(userToRegister);
    verify(mockedUserRepository, times(1)).findByEmail(userToRegister.getEmail());
  }

  @Test
  public void testRegisterWithExistingEmailThrowsException() {
    User userToRegister = new User(null, "testEmail", "testPassword");
    User existingUser = new User(1L, "testEmail", "testPassword");
    when(mockedUserRepository.findByEmail(userToRegister.getEmail()))
        .thenReturn(Optional.of(existingUser));

    assertThatExceptionOfType(UserWithEmailExists.class)
        .isThrownBy(() -> userService.register(userToRegister))
        .withMessage("User already exists")
        .withNoCause();

    verify(mockedUserRepository, times(1)).findByEmail(userToRegister.getEmail());
    verify(mockedUserRepository, times(0)).save(userToRegister);
  }
}
