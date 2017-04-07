import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_objectInstantiatesCorrectly_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    assertEquals(true, newClient instanceof Client);
  }

  @Test
  public void client_instantiatesWithNameCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    assertEquals("Bob Fredrickson", newClient.getName());
  }

  @Test
  public void client_instantiatesWithPhoneCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    assertEquals("971-275-8543", newClient.getPhone());
  }

  @Test
  public void client_instantiatesWithEmailCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    assertEquals("bobfredrickson@gmail.com", newClient.getEmail());
  }


  @Test
 public void save_SavesAClientIntoDatabase_true() {
   Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
   newClient.save();
   assertTrue(Client.all().get(0).equals(newClient));
 }

  // @Test
  // public void all_returnsAllInstancesOfClient_true() {
  //   Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
  //   assertEquals("bobfredrickson@gmail.com", newClient.getEmail());
  //   Client secondClient = new Client("Buy groceries", 1);
  //   secondClient.save();
  //   assertEquals(true, Client.all().get(0).equals(firstClient));
  //   assertEquals(true, Client.all().get(1).equals(secondClient));
  // }



  // @Test
  // public void client_instantiatesWithTimestampCorrectly() {
  //   Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
  //   assertEquals(DateFormat.getDateTimeInstance().format());
  // }
}
