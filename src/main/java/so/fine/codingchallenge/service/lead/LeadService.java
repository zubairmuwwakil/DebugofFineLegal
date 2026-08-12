package so.fine.codingchallenge.service.lead;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import so.fine.codingchallenge.config.ZipToCityConfig;
import so.fine.codingchallenge.db.entity.lead.Lead;
import so.fine.codingchallenge.db.entity.user.User;
import so.fine.codingchallenge.db.repository.user.UserRepository;
import so.fine.codingchallenge.domain.lead.LeadRequest;
import so.fine.codingchallenge.domain.lead.LeadResponse;
import so.fine.codingchallenge.domain.user.UserResponse;
import so.fine.codingchallenge.db.repository.lead.LeadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    private final LeadRepository leadRepository;
    private final UserRepository userRepository;
    private final ZipToCityConfig zipToCityConfig;

    public LeadService(LeadRepository leadRepository, UserRepository userRepository, ZipToCityConfig zipToCityConfig) {
        this.leadRepository = leadRepository;
        this.userRepository = userRepository;
        this.zipToCityConfig = zipToCityConfig;
    }

    public List<LeadResponse> getAllLeads() {
        return leadRepository.findAll().stream().
                map(LeadResponse::toLeadResponse).
                toList();
    }

    public Optional<LeadResponse> getLeadById(Long id) {
        return leadRepository.findById(id).map(LeadResponse::toLeadResponse);
    }

    public LeadResponse createLead(LeadRequest leadRequest) {
        Lead newLead = leadRepository.save(LeadRequest.toLeadEntity(leadRequest));
        return LeadResponse.toLeadResponse(newLead);
    }

    public UserResponse convertLeadToUser(Long id) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lead not found with id: " + id));

        // Resolve the state using the zip code
        String city = zipToCityConfig.getZipMap().getOrDefault(lead.getZipCode(), "Unknown");

        // Create a User using the resolved state
        User user = new User();
        user.setFirstname(lead.getFirstname());
        user.setLastname(lead.getLastname());
        user.setAddress(lead.getAddress());
        user.setCity(lead.getCity());
        user.setZipCode(lead.getZipCode());
        user.setState(city);  // Resolved state
        user.setCourt("Default Court");
        user.setPhoneNumber(lead.getPhoneNumber());
        user.setEmail(lead.getEmail());

        User savedUser = userRepository.save(user);
        lead.setUser(savedUser);
        leadRepository.insert(lead);

        return UserResponse.toUserResponse(savedUser);
    }
}
