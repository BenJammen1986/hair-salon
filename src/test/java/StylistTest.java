import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_objectInstantiatesCorrectly_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    assertEquals(true, newStylist instanceof Stylist);
  }

  @Test
  public void stylist_instantiatesWithNameCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    assertEquals("Georgio Ramirez", newStylist.getName());
  }

  @Test
  public void stylist_instantiatesWithPhoneNumberCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    assertEquals("503-871-2356", newStylist.getPhone());
  }

  @Test
  public void stylist_instantiatesWithEmailCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    assertEquals("georgio.ramirezstylist@gmail.com", newStylist.getEmail());
  }

  @Test
  public void stylist_instantiatesWithHireDateCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    assertEquals("02-17-2016", newStylist.getHireDate());
  }

  @Test
  public void stylist_instantiatesWithExperienceCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    assertEquals("12 years", newStylist.getExperience());
  }

  @Test
  public void equals_returnstrueIfPropertiesAreTheSame() {
    Stylist newStylist1 = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    Stylist newStylist2 = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    assertTrue(newStylist1.equals(newStylist2));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    assertTrue(Stylist.all().get(0).equals(newStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(newStylist.getId(), savedStylist.getId());
  }

  @Test
  public void stylist_savesToDatabaseWithId() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    assertTrue(newStylist.getId() > 0);
  }

  @Test
  public void returnsMultipleStylists_true() {
    Stylist newStylist1 = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist1.save();
    Stylist newStylist2 = new Stylist("Ned Flanders", "503-769-0243", "nedstyleshair@gmail.com", "10-12-2014", "6 years");
    newStylist2.save();
    assertEquals(true, Stylist.all().get(0).equals(newStylist1));
    assertEquals(true, Stylist.all().get(1).equals(newStylist2));

  }
  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist newStylist1 = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist1.save();
    Stylist newStylist2 = new Stylist("Ned Flanders", "503-769-0243", "nedstyleshair@gmail.com", "10-12-2014", "6 years");
    newStylist2.save();
    assertEquals(Stylist.find(newStylist2.getId()), newStylist2);
  }


  @Test
  public void updateName_updatesStylistName_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    newStylist.updateName("George Ramirez");
    assertEquals("George Ramirez", Stylist.find(newStylist.getId()).getName());
  }

  @Test
  public void updatePhone_updatesStylistPhone_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    newStylist.updatePhone("971-254-3033");
    assertEquals("971-254-3033", Stylist.find(newStylist.getId()).getPhone());
  }

  @Test
  public void updateEmail_updatesStylistEmail_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    newStylist.updateEmail("georgiostyleshair@gmail.com");
    assertEquals("georgiostyleshair@gmail.com", Stylist.find(newStylist.getId()).getEmail());
  }

  @Test
  public void updateHireDate_updatesStylistHireDate_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    newStylist.updateHireDate("02-27-2016");
    assertEquals("02-27-2016", Stylist.find(newStylist.getId()).getHireDate());
  }

  @Test
  public void updateExperience_updatesStylistExperience_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    newStylist.updateExperience("13 years");
    assertEquals("13 years", Stylist.find(newStylist.getId()).getExperience());
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    int newStylistId = newStylist.getId();
    newStylist.deleteStylist();
    assertEquals(null, Stylist.find(newStylistId));
  }

  @Test
  public void getClients_getsAllStylistsClients_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    Client firstClient = new Client("Bob Fredrickson", "971-275-8543", "bobfredrickson@gmail.com", newStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Joe Smith", "208-839-5757", "joe@email.com", newStylist.getId());
    secondClient.save();
    assertTrue(newStylist.getClients().get(0).equals(firstClient));
    assertTrue(newStylist.getClients().get(1).equals(secondClient));
  }
}
