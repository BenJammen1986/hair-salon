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
  public void stylist_savesToDatabaseWithIdReturnedCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    newStylist.save();
    assertTrue(newStylist.getId() > 0);
  }

  @Test
  public void returnsMultipleStylists_true() {
    Stylist newStylist1 = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
    Stylist newStylist2 = new Stylist("Ned Flanders", "503-769-0243", "nedstyleshair@gmail.com", "10-12-2014", "6 years");
    newStylist1.save();
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

  //
  // @Test
  // public void update_updatesStylistName_true() {
  //   Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com", "02-17-2016", "12 years");
  //   newStylist.save();
  //   myStylist.updateName("Georgio Ramses");
  //   assertEquals("Georgio Ramses", newStylist.getId()).getName();
  // }

}
