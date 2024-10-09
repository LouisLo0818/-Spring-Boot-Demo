package com.example.demo.controller;
import com.example.demo.model.crime;
import com.example.demo.repository.crime_dataRepository;
import com.example.demo.service.crime_dataService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api/crime")
public class crime_dataController {
    private static final Logger logger = LoggerFactory.getLogger(crime_dataController.class);
    @Autowired
    private crime_dataRepository crimeDataRepository;
    @Autowired
    private crime_dataService crimeDataService;

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test endpoint works!");
    }

    @PostMapping("/search")
    public ResponseEntity<List<crime>> getCrimesByDate(@RequestBody Map<String, String> request) {
        // Validate the input dates
        String fromDate = request.get("from_date");
        String toDate = request.get("to_date");

        System.out.println(fromDate);
        System.out.println(toDate);

        if (fromDate == null || fromDate.isEmpty() || toDate == null || toDate.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Bad request if dates are null or empty
        }

        // Retrieve crimes using the repository method
        List<crime> crimes = crimeDataRepository.findByDateOccBetween(fromDate, toDate);

        // Return the response
        return ResponseEntity.ok(crimes);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            crimeDataService.importCsv(file);
            return ResponseEntity.status(HttpStatus.OK).body("CSV uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading CSV: " + e.getMessage());
        }
    }
}
