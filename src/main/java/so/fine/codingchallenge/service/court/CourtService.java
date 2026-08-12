package so.fine.codingchallenge.service.court;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import so.fine.codingchallenge.domain.court.CourtResponse;

@Service
public class CourtService {
    private final WebClient.Builder webClient;
    @Value("court-by-zip-code-service")
    private String courtByZipCodeService;

    public CourtService(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    public CourtResponse getCourtByZipCode(String zipCode) {
        return webClient.build()
                .get()
                .uri(courtByZipCodeService+"/court/zip-code/{zipCode}", zipCode)
                .retrieve()
                .bodyToMono(CourtResponse.class)
                .block();
    }
}
