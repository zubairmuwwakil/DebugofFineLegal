package so.fine.codingchallenge.domain.lead;

import lombok.Data;
import so.fine.codingchallenge.db.entity.lead.Lead;

public class LeadResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private String email;

    public LeadResponse(Long id, String firstname, String lastname, String address, String city, String zipCode, String phoneNumber, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static LeadResponse toLeadResponse(Lead lead) {
        return new LeadResponse(
                lead.getId(),
                lead.getFirstname(),
                lead.getLastname(),
                lead.getAddress(),
                lead.getCity(),
                lead.getZipCode(),
                lead.getPhoneNumber(),
                lead.getEmail()
        );
    }
}
