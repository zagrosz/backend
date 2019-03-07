package pl.zagrosz.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zagrosz.dao.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
