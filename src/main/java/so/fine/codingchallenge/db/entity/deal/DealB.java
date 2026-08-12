package so.fine.codingchallenge.db.entity.deal;

import jakarta.persistence.Entity;
import lombok.Data;
import so.fine.codingchallenge.db.entity.deal.AbstractDeal;

import java.time.LocalDate;

@Entity
@Data
public class DealB extends AbstractDeal {
    private Double grossSalary;
    private LocalDate contractStartDate;

    // Explicit getters/setters
    public Double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(Double grossSalary) { this.grossSalary = grossSalary; }

    public LocalDate getContractStartDate() { return contractStartDate; }
    public void setContractStartDate(LocalDate contractStartDate) { this.contractStartDate = contractStartDate; }
}