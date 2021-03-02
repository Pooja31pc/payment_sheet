package com.easyecom.paymentfilecsv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
    @Table(name = "payment_details")
    public class PaymentDetails {

        @Id
        private String orderNum;
        private Long saleAmount;
        private Long costPrice;
        private Long transferredAmount;
        private Long comission;
        private Long paymentGateway;
        private Long pickPackFee;

    public PaymentDetails() {

    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Long getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Long saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Long getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Long costPrice) {
        this.costPrice = costPrice;
    }

    public Long getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(Long transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public Long getComission() {
        return comission;
    }

    public void setComission(Long comission) {
        this.comission = comission;
    }

    public Long getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(Long paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Long getPickPackFee() {
        return pickPackFee;
    }

    public void setPickPackFee(Long pickPackFee) {
        this.pickPackFee = pickPackFee;
    }

    public PaymentDetails(String orderNum, Long saleAmount, Long costPrice, Long transferredAmount, Long comission, Long paymentGateway, Long pickPackFee) {
        this.orderNum = orderNum;
        this.saleAmount = saleAmount;
        this.costPrice = costPrice;
        this.transferredAmount = transferredAmount;
        this.comission = comission;
        this.paymentGateway = paymentGateway;
        this.pickPackFee = pickPackFee;
    }

    public PaymentDetails(Long saleAmount, Long costPrice, Long transferredAmount, Long comission, Long paymentGateway, Long pickPackFee) {
        this.saleAmount = saleAmount;
        this.costPrice = costPrice;
        this.transferredAmount = transferredAmount;
        this.comission = comission;
        this.paymentGateway = paymentGateway;
        this.pickPackFee = pickPackFee;
    }
}
