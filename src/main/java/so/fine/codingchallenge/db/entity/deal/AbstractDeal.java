package so.fine.codingchallenge.db.entity.deal;

import jakarta.persistence.*;
import lombok.Data;
import so.fine.codingchallenge.db.entity.user.User;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Ensures separate tables for subclasses
@Data
public abstract class AbstractDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double amountInvolved;

    @Enumerated(EnumType.STRING)
    private DealStatus status; // Enum for status

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Associated Lead

    // Explicit getters/setters for static analyzers
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getAmountInvolved() { return amountInvolved; }
    public void setAmountInvolved(Double amountInvolved) { this.amountInvolved = amountInvolved; }

    public DealStatus getStatus() { return status; }
    public void setStatus(DealStatus status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}