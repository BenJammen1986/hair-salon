import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_objectInstantiatesCorrectly_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com");
    assertEquals(true, newClient instanceof Client);
  }

  @Test
  public void client_instantiatesWithNameCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com");
    assertEquals("Bob Fredrickson", newClient.getName());
  }

  @Test
  public void client_instantiatesWithPhoneCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com");
    assertEquals("971-275-8543", newClient.getPhone());
  }

  @Test
  public void client_instantiatesWithEmailCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com");
    assertEquals("bobfredrickson@gmail.com", newClient.getEmail());
  }

  @Test
  public void client_instantiatesWithTimestampCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com");
    assertEquals(LocalDateTime.now().getDayOfWeek(), newClient.getCreatedAt().getDayOfWeek());
  }
}
