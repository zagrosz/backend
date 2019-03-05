package pl.zagrosz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zagrosz.dao.entity.Item;
import pl.zagrosz.dao.repository.ItemRepository;

@Service
public class ItemService {

  private final ItemRepository itemRepository;

  @Autowired
  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<Item> getAll() {
    return itemRepository.findAll();
  }

  public Long create(Item item) {
    Item savedItem = itemRepository.save(item);

    return savedItem.getId();
  }
}
