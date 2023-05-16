package therapy.session.Model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import javax.xml.crypto.Data;
import java.util.Date;


@Entity
@Table(name = "patient2_table")

public class Patient2Model {
@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String email;
private String  firstname;
private String  lastname;
private String dateofbirth;
private String contactnumber;
private String   gender;
private String  insurance;
private String  doctors;

    public Patient2Model() {
    }

    public Patient2Model(Integer id, String email, String firstname, String lastname, String dateofbirth, String contactnumber, String gender, String insurance, String doctors) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.contactnumber = contactnumber;
        this.gender = gender;
        this.insurance = insurance;
        this.doctors = doctors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getDoctors() {
        return doctors;
    }

    public void setDoctors(String doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Patient2Model{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                ", gender='" + gender + '\'' +
                ", insurance='" + insurance + '\'' +
                ", doctors='" + doctors + '\'' +
                '}';
    }
}
