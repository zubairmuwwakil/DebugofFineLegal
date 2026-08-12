package so.fine.codingchallenge.service.deal;

import so.fine.codingchallenge.db.entity.deal.AbstractDeal;
import so.fine.codingchallenge.db.entity.deal.DealA;
import so.fine.codingchallenge.db.entity.deal.DealB;
import so.fine.codingchallenge.db.entity.deal.DealStatus;
import so.fine.codingchallenge.domain.deal.DealRequest;
import so.fine.codingchallenge.domain.deal.DealResponse;

public class DealMapper {
    public static AbstractDeal toEntity(DealRequest request) {
        AbstractDeal deal;
        if ("A".equalsIgnoreCase(request.getType())) {
            DealA dealA = new DealA();
            dealA.setWithdrawals(request.getWithdrawals());
            dealA.setDeposits(request.getDeposits());
            dealA.setAmountInvolved(request.getAmountInvolved());
            deal = dealA;
        } else if ("B".equalsIgnoreCase(request.getType())) {
            DealB dealB = new DealB();
            dealB.setGrossSalary(request.getGrossSalary());
            dealB.setAmountInvolved(request.getAmountInvolved());
            dealB.setContractStartDate(request.getContractStartDate());
            deal = dealB;
        } else {
            throw IllegalArgumentException("Invalid deal type: " + request.getType());
        }

        deal.setName(request.getName());
        deal.setDescription(request.getDescription());
        deal.setStatus(DealStatus.valueOf(request.getStatus().toUpperCase()));
        return deal;
    }

    public static DealResponse toResponse(AbstractDeal deal) {
        DealResponse response = new DealResponse();
        response.setId(deal.getId());
        response.setName(deal.getName());
        response.setDescription(deal.getDescription());
        response.setStatus(deal.getStatus().name());
        if (deal instanceof DealA dealA) {
            response.setType("A");
            response.setWithdrawals(dealA.getWithdrawals());
            response.setDeposits(dealA.getDeposits());
            response.setAmountInvolved(dealA.getAmountInvolved());
        } else if (deal instanceof DealB dealB) {
            response.setType("B");
            response.setGrossSalary(dealB.getGrossSalary());
            response.setContractStartDate(dealB.getContractStartDate());
            response.setAmountInvolved(dealB.getAmountInvolved());
        }
        return response;
    }
}

