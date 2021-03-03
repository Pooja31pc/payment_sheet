package com.easyecom.paymentfilecsv.model;

import java.util.List;

public class ResultSheet {

    private String orderNumber;
    private int profit_loss;
    private Long transferredAmount;
    private int totalMarketplaceCharges;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProfit_loss() {
        return profit_loss;
    }

    public void setProfit_loss(int profit_loss) {
        this.profit_loss = profit_loss;
    }

    public Long getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(Long transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public int getTotalMarketplaceCharges() {
        return totalMarketplaceCharges;
    }

    public void setTotalMarketplaceCharges(int totalMarketplaceCharges) {
        this.totalMarketplaceCharges = totalMarketplaceCharges;
    }

    public ResultSheet() {
    }

    public ResultSheet(String orderNumber, long profit_loss, long transferredAmount, long totalMarketplaceCharges) {
        this.orderNumber = orderNumber;
        this.profit_loss = (int) profit_loss;
        this.transferredAmount = transferredAmount;
        this.totalMarketplaceCharges = (int) totalMarketplaceCharges;
    }
}
