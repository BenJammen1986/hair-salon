import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private String phone;
  private String email;
  private String hireDate;

  public Stylist(String name, String phone, String email, String hireDate) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.hireDate = hireDate;

  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getHireDate() {
    return hireDate;
  }
}
