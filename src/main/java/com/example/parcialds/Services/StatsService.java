package com.example.parcialds.Services;

import com.example.parcialds.dto.StatsResponse;
import com.example.parcialds.repositories.ADNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatsService {
    @Autowired
    private ADNRepository adnRepository;

    public StatsResponse getDnaStats() {
        long countMutantDna = adnRepository.countByIsMutant(true);
        long countHumanDna = adnRepository.countByIsMutant(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }
}
