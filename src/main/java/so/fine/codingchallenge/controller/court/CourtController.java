package so.fine.codingchallenge.controller.court;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import so.fine.codingchallenge.domain.court.CourtResponse;
import so.fine.codingchallenge.service.court.CourtService;

@RestController
@RequestMapping("/courts")
public class CourtController {
    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    @GetMapping("/zip-code/{zipCode}")
    public ResponseEntity<CourtResponse> getCourtByZipCode(@PathVariable("zipCode") String zipCode) {
        CourtResponse response = courtService.getCourtByZipCode(zipCode);
        return ResponseEntity.ok(response);
    }
}
