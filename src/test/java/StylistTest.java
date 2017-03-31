import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_objectInstantiatesCorrectly_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com");
    assertEquals(true, newStylist instanceof Stylist);
  }

  @Test
  public void stylist_instantiatesWithNameCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com");
    assertEquals("Georgio Ramirez", newStylist.getName());
  }

  @Test
  public void stylist_instantiatesWithPhoneNumberCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com");
    assertEquals("503-871-2356", newStylist.getPhone());
  }

  @Test
  public void stylist_instantiatesWithEmailCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez", "503-871-2356", "georgio.ramirezstylist@gmail.com");
    assertEquals("georgio.ramirezstylist@gmail.com", newStylist.getEmail());
  }

}
