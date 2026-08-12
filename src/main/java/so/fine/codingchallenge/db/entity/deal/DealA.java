package so.fine.codingchallenge.db.entity.deal;

import jakarta.persistence.Entity;
import lombok.Data;
import so.fine.codingchallenge.db.entity.deal.AbstractDeal;

import java.util.List;

@Entity
@Data
public class DealA extends AbstractDeal {
    private List<Double> withdrawals;
    private List<Double> deposits;

    // Explicit getters/setters
    public List<Double> getWithdrawals() { return withdrawals; }
    public void setWithdrawals(List<Double> withdrawals) { this.withdrawals = withdrawals; }

    public List<Double> getDeposits() { return deposits; }
    public void setDeposits(List<Double> deposits) { this.deposits = deposits; }
}