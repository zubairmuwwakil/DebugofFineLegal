package so.fine.codingchallenge.db.repository.lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import so.fine.codingchallenge.db.entity.lead.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
