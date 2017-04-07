import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

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

 @Test
 public void getId_clientInstantiateWithAnID_1() {
   Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
   newClient.save();
   assertTrue(newClient.getId() > 0);
 }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    firstClient.save();
    Client secondClient = new Client("Joe Smith", "208-839-5757", "joe@email.com", 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }



  @Test
  public void save_recordsDatabaseTimestampCorrectly() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    newClient.save();
    Timestamp savedCreatedAt = Client.find(newClient.getId()).getCreatedAt();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedCreatedAt));
  }
}
