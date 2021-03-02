package com.easyecom.paymentfilecsv.helper;

import com.easyecom.paymentfilecsv.model.PaymentDetails;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "OrderNum", "Sale Amount", "Cost Price", "Transferred Amount", "Comission", "Payment Gateway", "PickPack Fee"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<PaymentDetails> csvToPayment(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<PaymentDetails> paymentDetails = new ArrayList<PaymentDetails>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                PaymentDetails paymentDetails1 = new PaymentDetails(
                        csvRecord.get("OrderNum"),
                        Long.parseLong(csvRecord.get("Sale Amount")),
                        Long.parseLong(csvRecord.get("Cost Price")),
                        Long.parseLong(csvRecord.get("Transferred Amount")),
                        Long.parseLong(csvRecord.get("Comission")),
                        Long.parseLong(csvRecord.get("Payment Gateway")),
                        Long.parseLong(csvRecord.get("PickPack Fee"))
                );

                paymentDetails.add(paymentDetails1);
            }

            return paymentDetails;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
