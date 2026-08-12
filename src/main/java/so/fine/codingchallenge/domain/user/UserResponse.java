package so.fine.codingchallenge.domain.user;

import lombok.Data;
import so.fine.codingchallenge.db.entity.user.User;

@Data
public class UserResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String zipCode;
    private String state;
    private String phoneNumber;
    private String email;

    public static UserResponse toUserResponse(User user) {
        UserResponse response = new UserResponse();
        response.id = user.getId();
        response.firstname = user.getFirstname();
        response.lastname = user.getLastname();
        response.address = user.getAddress();
        response.city = user.getCity();
        response.zipCode = user.getZipCode();
        response.state = user.getState();
        response.phoneNumber = user.getPhoneNumber();
        response.email = user.getEmail();
        return response;
    }
}
