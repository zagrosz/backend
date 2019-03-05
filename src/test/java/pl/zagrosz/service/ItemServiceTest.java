package pl.zagrosz.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.zagrosz.dao.entity.Item;
import pl.zagrosz.dao.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

  private final ItemRepository mockedItemRepository = mock(ItemRepository.class);
  private final ItemService itemService = new ItemService(mockedItemRepository);

  @Test
  public void testGetAll() {
    Item firstItem = new Item(1L, "firstItem");
    Item secondItem = new Item(1L, "secondItem");
    List<Item> itemList = Arrays.asList(firstItem, secondItem);
    when(mockedItemRepository.findAll()).thenReturn(itemList);

    List<Item> allItemsList = itemService.getAll();

    assertThat(allItemsList).containsExactly(firstItem, secondItem);
    verify(mockedItemRepository, times(1)).findAll();
  }

  @Test
  public void testCreate() {
    Item itemToSave = new Item(null, "testItem");
    Item itemSaved = new Item(1L, "testItem");
    when(mockedItemRepository.save(itemToSave)).thenReturn(itemSaved);

    Long savedItemId = itemService.create(itemToSave);

    assertThat(savedItemId).isEqualTo(1L);
    verify(mockedItemRepository, times(1)).save(itemToSave);
  }
}
