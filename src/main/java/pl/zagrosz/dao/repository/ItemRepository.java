package pl.zagrosz.dao.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zagrosz.dao.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

  @Override
  List<Item> findAll();
}
