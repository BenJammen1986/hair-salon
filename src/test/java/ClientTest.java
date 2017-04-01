import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_objectInstantiatesCorrectly_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543");
    assertEquals(true, newClient instanceof Client);
  }

  @Test
  public void client_instantiatesWithNameCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543");
    assertEquals("Bob Fredrickson", newClient.getName());
  }

  @Test
  public void client_instantiatesWithPhoneCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543");
    assertEquals("971-275-8543", newClient.getPhone());
  }
}
