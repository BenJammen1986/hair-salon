import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private String phone;

  public Client(String name, String phone) {
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
