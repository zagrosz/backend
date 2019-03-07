package pl.zagrosz.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.zagrosz.dao.entity.User;
import pl.zagrosz.dao.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

  private final UserRepository mockedUserRepository = mock(UserRepository.class);
  private final UserService userService = new UserService(mockedUserRepository);

  @Test
  public void testRegister() {
    User userToRegister = new User(null, "testLogin", "testEmail", "testPassword");
    User userRegistered = new User(1L, "testLogin", "testEmail", "testPassword");
    when(mockedUserRepository.save(userToRegister)).thenReturn(userRegistered);

    Long savedUserId = userService.register(userToRegister);

    assertThat(savedUserId).isEqualTo(1L);
    verify(mockedUserRepository, times(1)).save(userToRegister);
  }
}
