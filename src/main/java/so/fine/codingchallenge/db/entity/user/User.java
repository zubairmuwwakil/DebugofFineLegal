package so.fine.codingchallenge.db.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import so.fine.codingchallenge.db.entity.deal.AbstractDeal;
import so.fine.codingchallenge.db.entity.lead.Lead;

import java.util.List;

@Entity
@Table(name = "`user`")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String zipCode;
    private String state;
    private String court;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Lead> leads; // Leads managed by this User

    @OneToMany(mappedBy = "user")
    private List<AbstractDeal> deals; // Deals managed by this User

}