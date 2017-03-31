import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private String phone;
  private String email;
  private String hire_date;
  private String experience;
  private int id;

  public Stylist(String name, String phone, String email, String hire_date, String experience) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.hire_date = hire_date;
    this.experience = experience;


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
    return hire_date;
  }

  public String getExperience() {
    return experience;
  }

  public Integer getId() {
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(name, phone, email, hire_date, experience) VALUES (:name, :phone, :email, :hire_date, :experience);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("phone", this.phone)
        .addParameter("email", this.email)
        .addParameter("hire_date", this.hire_date)
        .addParameter("experience", this.experience)
        .executeUpdate()
        .getKey();
    }
  }

  @Override
  public boolean equals(Object otherStylist) {
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return  this.getName().equals(newStylist.getName()) &&
              this.getPhone().equals(newStylist.getPhone()) &&
              this.getEmail().equals(newStylist.getEmail()) &&
              this.getHireDate().equals(newStylist.getHireDate()) &&
              this.getExperience().equals(newStylist.getExperience()) &&
              this.getId() == newStylist.getId();
    }
  }

  public static List<Stylist> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists;";
      return con.createQuery(sql).executeAndFetch(Stylist.class);

    }
  }
}
