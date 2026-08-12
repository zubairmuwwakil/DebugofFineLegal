package so.fine.codingchallenge.controller.lead;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import so.fine.codingchallenge.domain.lead.LeadRequest;
import so.fine.codingchallenge.domain.lead.LeadResponse;
import so.fine.codingchallenge.domain.user.UserResponse;
import so.fine.codingchallenge.service.lead.LeadService;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {
    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @GetMapping
    public ResponseEntity<List<LeadResponse>> getAllLeads() {
        if (leadService.getAllLeads() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadResponse> getLeadById(@PathVariable("id") String id) {
        return leadService.getLeadById(Long.valueOf(id)).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LeadResponse> createLead(@RequestBody LeadRequest leadRequest) {
        LeadResponse leadResponse = leadService.createLead(leadRequest);
        if (leadResponse == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(leadResponse);
    }

    @PostMapping("/{id}/convert")
    public ResponseEntity<UserResponse> convertLeadToUser(@PathVariable("id") Long id) {
        UserResponse userResponse = leadService.convertLeadToUser(id);
        return ResponseEntity.ok(userResponse);
    }
}
