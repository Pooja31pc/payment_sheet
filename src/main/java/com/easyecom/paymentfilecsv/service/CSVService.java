package com.easyecom.paymentfilecsv.service;

import com.easyecom.paymentfilecsv.helper.CSVHelper;
import com.easyecom.paymentfilecsv.model.PaymentDetails;
import com.easyecom.paymentfilecsv.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    PaymentDetailsRepository paymentDetailsRepo;

    public void save(MultipartFile file) {
        try {
            List<PaymentDetails> paymentDetailsList = CSVHelper.csvToPayment(file.getInputStream());
            paymentDetailsRepo.saveAll(paymentDetailsList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<PaymentDetails> getAllPaymentDetails() {
        return paymentDetailsRepo.findAll();
    }

}
