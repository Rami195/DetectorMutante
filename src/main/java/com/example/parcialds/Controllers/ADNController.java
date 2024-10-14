package com.example.parcialds.Controllers;

import com.example.parcialds.Services.ADNService;
import com.example.parcialds.Services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mutant")
public class ADNController {

    @Autowired
    private ADNService ADNService;
    @Autowired
    private StatsService statsService;

    @PostMapping("")
    public ResponseEntity<?> isMutant(@RequestBody Map<String, String[]> dna) {
        boolean isMutant = ADNService.isMutant(dna.get("dna"));
        ADNService.saveDna(dna.get("dna"), isMutant);
        if (isMutant) {
            return new ResponseEntity<>("Mutant detected", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        Map<String, Object> stats = statsService.getDnaStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}