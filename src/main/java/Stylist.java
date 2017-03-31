import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private String phone;
  private String email;
  private String hireDate;
  private String experience;
  private int id;

  public Stylist(String name, String phone, String email, String hireDate, String experience) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.hireDate = hireDate;
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
    return hireDate;
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
        .addParameter("hire_date", this.hireDate)
        .addParameter("experience", this.experience)
        .executeUpdate()
        .getKey();
    }
  }
}
