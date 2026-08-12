package so.fine.codingchallenge.db.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import so.fine.codingchallenge.db.entity.lead.Lead;
import so.fine.codingchallenge.db.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<Lead, Long> {
}

