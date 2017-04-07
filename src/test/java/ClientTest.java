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
  public void save_returnsTrueIfNameisTheSame() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    newClient.save();
    assertTrue(Client.all().get(0).equals(newClient));
  }

  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    Stylist savedStylist = Stylist.find(newStylist.getId());
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", newStylist.getId());
    newClient.save();
    Client savedClient = Client.find(newClient.getId());
    assertEquals(savedClient.getStylistId(), savedStylist.getId());
  }

  @Test
  public void getId_clientGetsDatabaseId_true() {
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

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    firstClient.save();
    Client secondClient = new Client("Joe Smith", "208-839-5757", "joe@email.com", 1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Client firstClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    Client secondClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    assertTrue(firstClient.equals(secondClient));
    }

  @Test
  public void updateName_updatesClientName_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    newClient.save();
    newClient.updateName("Bobby");
    assertEquals("Bobby", Client.find(newClient.getId()).getName());
  }

  @Test
  public void updatePhone_updatesClientPhone_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    newClient.save();
    newClient.updatePhone("208-312-3948");
    assertEquals("208-312-3948", Client.find(newClient.getId()).getPhone());
  }

  @Test
  public void updateEmail_updatesClientEmail_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    newClient.save();
    newClient.updateEmail("bobfredrickson@nike.com");
    assertEquals("bobfredrickson@nike.com", Client.find(newClient.getId()).getEmail());
  }

  @Test
  public void updateStylistId_updatesClientStylistId_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    newClient.save();
    newClient.updateStylistId(2);
    assertEquals(2, Client.find(newClient.getId()).getStylistId());
  }

  @Test
  public void delete_deletesClient_true() {
    Client newClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", 1);
    newClient.save();
    int newClientId = newClient.getId();
    newClient.delete();
    assertEquals(null, Client.find(newClientId));
  }

}
