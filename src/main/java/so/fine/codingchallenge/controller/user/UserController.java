package so.fine.codingchallenge.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import so.fine.codingchallenge.domain.deal.DealRequest;
import so.fine.codingchallenge.domain.deal.DealResponse;
import so.fine.codingchallenge.service.deal.DealService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final DealService dealService;

    public UserController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping("/{id}/deals")
    public ResponseEntity<DealResponse> createDealForUser(@PathVariable("id") Long id, @RequestBody DealRequest dealRequest) {
        DealResponse dealResponse = dealService.createDealForUser(id, dealRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealResponse);
    }

    @GetMapping("/{id}/deals")
    public ResponseEntity<List<DealResponse>> getDealsOfUser(@PathVariable("id") Long id) {
        List<DealResponse> dealResponses = dealService.getDealsForUser(id);
        return ResponseEntity.ok(dealResponses);
    }
}
