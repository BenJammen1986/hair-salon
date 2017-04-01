import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private String phone;
  private String email;

  public Client(String name, String phone, String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
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
}
