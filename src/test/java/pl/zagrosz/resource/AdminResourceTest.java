package pl.zagrosz.resource;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AdminResourceTest {

  private AdminResource adminResource = new AdminResource();

  @Test
  public void testPing() {
    String response = adminResource.ping();

    assertThat(response).isEqualTo("pong");
  }
}
