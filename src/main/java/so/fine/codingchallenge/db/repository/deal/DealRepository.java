package so.fine.codingchallenge.db.repository.deal;

import org.springframework.data.jpa.repository.JpaRepository;
import so.fine.codingchallenge.db.entity.deal.AbstractDeal;
import so.fine.codingchallenge.db.entity.user.User;

import java.util.List;

public interface DealRepository extends JpaRepository<AbstractDeal, Long> {
    public List<AbstractDeal> findByUser(User user);
}
