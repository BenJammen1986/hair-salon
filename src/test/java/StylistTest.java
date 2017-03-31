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
}
