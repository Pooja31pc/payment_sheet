package com.easyecom.paymentfilecsv.controller;

import com.easyecom.paymentfilecsv.helper.CSVHelper;
import com.easyecom.paymentfilecsv.message.ResponseMessage;
import com.easyecom.paymentfilecsv.model.PaymentDetails;
import com.easyecom.paymentfilecsv.model.ResultSheet;
import com.easyecom.paymentfilecsv.repository.PaymentDetailsRepository;
import com.easyecom.paymentfilecsv.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/csv")
public class UserController {

    @Autowired
    CSVService fileService;

    @Autowired
    PaymentDetailsRepository paymentDetailsRepo;

    @PostMapping("/uploadfile")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                e.printStackTrace();
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/paymentdetails")
    public ResponseEntity<List<PaymentDetails>> getAllTutorials() {
        try {
            List<PaymentDetails> paymentDetails = fileService.getAllPaymentDetails();

            if (paymentDetails.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(paymentDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/resultsheet")
    public List<ResultSheet> getResultSheet() {
        List<ResultSheet> resultSheet = paymentDetailsRepo.resultSheet();

        return resultSheet;
    }

}
