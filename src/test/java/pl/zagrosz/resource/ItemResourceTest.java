package pl.zagrosz.resource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.zagrosz.dao.entity.Item;
import pl.zagrosz.service.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemResourceTest {

  private final ItemService mockedItemService = Mockito.mock(ItemService.class);
  private final ItemResource itemResource = new ItemResource(mockedItemService);

  @Test
  public void testGetAll() {
    Item firstItem = new Item(1L, "firstItem");
    Item secondItem = new Item(1L, "secondItem");
    List<Item> itemList = Arrays.asList(firstItem, secondItem);
    Mockito.when(mockedItemService.getAll()).thenReturn(itemList);

    ResponseEntity response = itemResource.getAll();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat((List<Item>) response.getBody()).containsExactly(firstItem, secondItem);
  }
}
