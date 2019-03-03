package pl.zagrosz.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.zagrosz.dao.entity.Item;
import pl.zagrosz.dao.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

  private final ItemRepository mockedItemRepository = Mockito.mock(ItemRepository.class);
  private final ItemService itemService = new ItemService(mockedItemRepository);

  @Test
  public void testGetAll() {
    Item firstItem = new Item(1L, "firstItem");
    Item secondItem = new Item(1L, "secondItem");
    List<Item> itemList = Arrays.asList(firstItem, secondItem);
    Mockito.when(mockedItemRepository.findAll()).thenReturn(itemList);

    List<Item> allItemsList= itemService.getAll();

    assertThat(allItemsList).containsExactly(firstItem, secondItem);
  }
}
