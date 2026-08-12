package so.fine.codingchallenge.service.deal;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import so.fine.codingchallenge.db.entity.deal.AbstractDeal;
import so.fine.codingchallenge.db.entity.user.User;
import so.fine.codingchallenge.db.repository.deal.DealRepository;
import so.fine.codingchallenge.db.repository.user.UserRepository;
import so.fine.codingchallenge.domain.deal.DealRequest;
import so.fine.codingchallenge.domain.deal.DealResponse;

import java.List;

@Service
public class DealService {
    private final DealRepository dealRepository;
    private final UserRepository userRepository;

    public DealService(DealRepository dealRepository, UserRepository userRepository) {
        this.dealRepository = dealRepository;
        this.userRepository = userRepository;
    }


    public DealResponse createDealForUser(Long id, DealRequest dealRequest) {
        // Fetch the user
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));

        AbstractDeal deal = DealMapper.toEntity(dealRequest);
        deal.setUser(user);

        // Save the deal to the database
        AbstractDeal savedDeal = dealRepository.save(deal);

        // Return as DealResponse
        return DealMapper.toResponse(savedDeal);
    }

    public List<DealResponse> getDealsForUser(Long id) {
        List<AbstractDeal> dealList = dealRepository.findByUser(userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        return dealList.stream().map(DealMapper::toResponse).toList();
    }
}
