import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_objectInstantiatesCorrectly_true() {
    Client newClient = new Client("Bob Fredrickson");
    assertEquals(true, newClient instanceof Client);
  }

  @Test
  public void client_instantiatesWithNameCorrectly() {
    Client newClient = new Client("Bob Fredrickson");
    assertEquals("Bob Fredrickson", newClient.getName());
  }
}
