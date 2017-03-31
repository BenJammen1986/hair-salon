import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_objectInstantiatesCorrectly_true() {
    Stylist newStylist = new Stylist("Georgio Ramirez");
    assertEquals(true, newStylist instanceof Stylist);
  }

  @Test
  public void stylist_instantiatesWithNameCorrectly() {
    Stylist newStylist = new Stylist("Georgio Ramirez");
    assertEquals("Georgio Ramirez", newStylist.getName());
  }

  // @Test
  // public void stylist_instantiatesWithPhoneNumberCorrectly() {
  //   Stylist newStylist = new Stylist("Georgio Ramirez", 5038712356);
  //   assertEquals(5038712355, newStylist.getPhone());
  // }

}
