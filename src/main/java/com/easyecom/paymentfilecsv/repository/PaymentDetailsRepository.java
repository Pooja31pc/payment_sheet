package com.easyecom.paymentfilecsv.repository;

import com.easyecom.paymentfilecsv.model.PaymentDetails;
import com.easyecom.paymentfilecsv.model.ResultSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, String> {

   @Query("select new com.easyecom.paymentfilecsv.model.ResultSheet(p.orderNum, p.transferredAmount-p.costPrice, p.transferredAmount, p.comission+p.paymentGateway+p.pickPackFee) from PaymentDetails p")
   List<ResultSheet> resultSheet();

}
