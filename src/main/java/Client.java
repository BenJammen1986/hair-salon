import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private String phone;
  private String email;
  private Timestamp created_at;
  private int id;
  private int stylist_id;

  public Client(String name, String phone, String email, int stylist_id) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.stylist_id = stylist_id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Timestamp getCreatedAt() {
    return created_at;
  }

  public int getStylistId() {
    return stylist_id;
  }


  public String getPhone() {
    return phone;
  }

  public int getId() {
    return id;
  }


  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(name, email, created_at, phone, stylist_id) VALUES (:name, :email, now(), :phone, :stylist_id);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("email", this.email)
        .addParameter("stylist_id", this.stylist_id)
        .addParameter("phone", this.phone)
        .executeUpdate()
        .getKey();
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return  this.getName().equals(newClient.getName()) &&
              this.getEmail().equals(newClient.getEmail()) &&
              this.getStylistId() == newClient.getStylistId() &&
              this.getPhone().equals(newClient.getPhone()) &&
              this.getId() == newClient.getId();
    }
  }

  public static List<Client> all() {
    String sql = "SELECT * FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Client.class);
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return stylist;
    }
  }

  public void updateName(String name) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE clients SET name = :name WHERE id = :id";
    con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
