package pl.zagrosz.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zagrosz.dao.entity.User;
import pl.zagrosz.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

  private final UserService userService;

  @Autowired
  public UserResource(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @RequestMapping("/register")
  public ResponseEntity register(@RequestBody User user) {
    Long id = userService.register(user);

    return ResponseEntity.status(HttpStatus.OK).body(id);
  }
}
