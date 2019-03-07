package pl.zagrosz.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.zagrosz.dao.entity.User;
import pl.zagrosz.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest {

  private final UserService mockedUserService = mock(UserService.class);
  private final UserResource userResource = new UserResource(mockedUserService);

  @Test
  public void testRegister() {
    User user = new User(null, "testLogin", "testEmail", "testPassword");
    when(mockedUserService.register(user)).thenReturn(1L);

    ResponseEntity response = userResource.register(user);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat((Long) response.getBody()).isEqualTo(1L);
    verify(mockedUserService, times(1)).register(user);
  }
}
