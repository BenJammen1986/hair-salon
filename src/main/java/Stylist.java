import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private String phone;

  public Stylist(String name, String phone) {
    this.name = name;
    this.phone = phone;

  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }
}
