package com.example.demo.service;

import com.example.demo.model.crime;
import com.example.demo.repository.crime_dataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class crime_dataService {

    @Autowired
    private crime_dataRepository Crime_dataRepository;

    public List<crime> searchByDate(String fromDate, String toDate) {
        // Remove AM/PM from the input strings
        fromDate = removeAmPm(fromDate);
        toDate = removeAmPm(toDate);

        // Define the format for parsing
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"); // Adjust the format as needed

        // Convert fromDate and toDate from String to LocalDateTime
        String fromDateTime = String.valueOf(LocalDateTime.parse(fromDate, formatter));
        String toDateTime = String.valueOf(LocalDateTime.parse(toDate, formatter));

        return Crime_dataRepository.findByDateOccBetween(fromDateTime, toDateTime);
    }

    private String removeAmPm(String dateTime) {
        // Use regex to replace " AM" or " PM" with an empty string
        return dateTime.replaceAll("\\s*[AP]M$", "").trim();
    }

    // Method to import CSV
    public void importCsv(MultipartFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            Set<String> seenColumns = new HashSet<>();

            for (CSVRecord csvRecord : csvParser) {
                crime crime = new crime();

                crime.setDrNo(csvRecord.get("DR_NO").trim());
                crime.setDateRptd(removeAmPm(csvRecord.get("Date Rptd").trim()));
                crime.setDateOcc(removeAmPm(csvRecord.get("DATE OCC").trim()));
                crime.setTimeOcc(csvRecord.get("TIME OCC").trim());
                crime.setArea(csvRecord.get("AREA "));
                crime.setAreaName(csvRecord.get("AREA NAME").trim());
                crime.setRptDistNo(csvRecord.get("Rpt Dist No").trim());
                crime.setCrmCdDesc(csvRecord.get("Crm Cd Desc").trim());
                crime.setVictAge(csvRecord.get("Vict Age").trim());
                crime.setVictSex(csvRecord.get("Vict Sex").trim());
                crime.setVictDescent(csvRecord.get("Vict Descent").trim());
                crime.setPremisCd(csvRecord.get("Premis Cd").trim());
                crime.setPremisDesc(csvRecord.get("Premis Desc").trim());
                crime.setWeaponUsedCd(csvRecord.get("Weapon Used Cd").trim());
                crime.setWeaponDesc(csvRecord.get("Weapon Desc").trim());
                crime.setStatus(csvRecord.get("Status").trim());
                crime.setStatusDesc(csvRecord.get("Status Desc").trim());

                // Save the crime object immediately
                try {
                    Crime_dataRepository.save(crime); // Save one by one
                } catch (Exception e) {
                    System.err.println("Error saving record: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("IOException while reading the CSV file: " + e.getMessage());
            throw e; // Rethrow the exception after logging
        } catch (Exception e) {
            System.err.println("Error processing the CSV file: " + e.getMessage());
            e.printStackTrace(); // Log the stack trace for debugging
        }
    }
}
