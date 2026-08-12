package so.fine.codingchallenge.domain.deal;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DealResponse {
    private Long id;
    private String type; // "A" or "B"
    private String name;
    private String description;
    private Long userId;
    private String status; // NEW, IN_PROGRESS, CLOSED

    // DealA-specific fields
    private List<Double> withdrawals;
    private List<Double> deposits;
    private Double amountInvolved;

    // DealB-specific fields
    private Double grossSalary;
    private LocalDate contractStartDate;

    // Explicit getters/setters for static analyzers
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Double> getWithdrawals() { return withdrawals; }
    public void setWithdrawals(List<Double> withdrawals) { this.withdrawals = withdrawals; }

    public List<Double> getDeposits() { return deposits; }
    public void setDeposits(List<Double> deposits) { this.deposits = deposits; }

    public Double getAmountInvolved() { return amountInvolved; }
    public void setAmountInvolved(Double amountInvolved) { this.amountInvolved = amountInvolved; }

    public Double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(Double grossSalary) { this.grossSalary = grossSalary; }

    public LocalDate getContractStartDate() { return contractStartDate; }
    public void setContractStartDate(LocalDate contractStartDate) { this.contractStartDate = contractStartDate; }
}