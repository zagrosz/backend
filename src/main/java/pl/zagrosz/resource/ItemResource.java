package pl.zagrosz.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zagrosz.dao.entity.Item;
import pl.zagrosz.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemResource {

  private final ItemService itemService;

  @Autowired
  public ItemResource(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping
  public ResponseEntity getAll() {
    List<Item> itemList = itemService.getAll();

    return ResponseEntity.status(HttpStatus.OK).body(itemList);
  }

  @PostMapping
  public ResponseEntity create(@RequestBody Item item) {
    Long id = itemService.create(item);

    return ResponseEntity.status(HttpStatus.OK).body(id);
  }
}
