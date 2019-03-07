package pl.zagrosz.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zagrosz.dao.entity.User;
import pl.zagrosz.dao.repository.UserRepository;
import pl.zagrosz.exception.UserWithEmailExists;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Long register(User user) {
    Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
    optionalUser.ifPresent(u -> {
      throw new UserWithEmailExists("User already exists");
    });
    User savedUser = userRepository.save(user);

    return savedUser.getId();
  }
}
