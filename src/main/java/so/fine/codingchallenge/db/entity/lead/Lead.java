package so.fine.codingchallenge.db.entity.lead;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import so.fine.codingchallenge.db.entity.deal.AbstractDeal;
import so.fine.codingchallenge.db.entity.user.User;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lead{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String firstname;
        String lastname;
        String address;
        String city;
        String zipCode;
        String phoneNumber;
        String email;
        @ManyToOne User user;

    // Explicit getters/setters for static analyzers that don't process Lombok
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}