package pl.zagrosz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zagrosz.dao.entity.User;
import pl.zagrosz.dao.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Long register(User user) {
    User savedUser = userRepository.save(user);

    return savedUser.getId();
  }
}
