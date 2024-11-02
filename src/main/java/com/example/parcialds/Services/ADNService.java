package com.example.parcialds.Services;

import com.example.parcialds.entities.ADN;
import com.example.parcialds.repositories.ADNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class ADNService {

    @Autowired
    private ADNRepository ADNRepository;

    public boolean isMutant(String[] dna) {
        int sequenceCount = 0;
        int size = dna.length;



        sequenceCount += checkAllHorizontal(dna, size);
        sequenceCount += checkAllVertical(dna, size);
        sequenceCount += checkAllDiagonals(dna, size);


        return sequenceCount > 1;
    }


    private int checkAllHorizontal(String[] dna, int size) {
        return IntStream.range(0, size)
                .map(i -> checkSequence(dna[i]))
                .sum();
    }

    private int checkAllVertical(String[] dna, int size) {
        return IntStream.range(0, size)
                .map(j -> {
                    StringBuilder column = new StringBuilder();
                    IntStream.range(0, dna.length)
                            .forEach(i -> column.append(dna[i].charAt(j)));
                    return checkSequence(column.toString());
                })
                .sum();
    }

    private int checkAllDiagonals(String[] dna, int size) {
        int count = 0;


        for (int start = 0; start < size; start++) {

            StringBuilder diagonal1 = new StringBuilder();
            for (int i = 0; i + start < size; i++) {
                diagonal1.append(dna[i].charAt(i + start));
            }
            count += checkSequence(diagonal1.toString());


            if (start > 0) {
                StringBuilder diagonal2 = new StringBuilder();
                for (int i = 0; i + start < size; i++) {
                    diagonal2.append(dna[i + start].charAt(i));
                }
                count += checkSequence(diagonal2.toString());
            }
        }


        for (int start = 0; start < size; start++) {

            StringBuilder diagonal3 = new StringBuilder();
            for (int i = 0; i + start < size; i++) {
                diagonal3.append(dna[i].charAt(size - 1 - i - start));
            }
            count += checkSequence(diagonal3.toString());


            if (start > 0) {
                StringBuilder diagonal4 = new StringBuilder();
                for (int i = 0; i + start < size; i++) {
                    diagonal4.append(dna[i + start].charAt(size - 1 - i));
                }
                count += checkSequence(diagonal4.toString());
            }
        }

        return count;
    }

    private int checkSequence(String sequence) {
        int count = 0;
        char currentChar = sequence.charAt(0);
        int currentStreak = 1;


        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == currentChar) {
                currentStreak++;
                if (currentStreak == 4) {
                    count++;
                    currentStreak = 0;
                }
            } else {
                currentChar = sequence.charAt(i);
                currentStreak = 1;
            }
        }

        return count;
    }

    public ADN saveDna(String[] dna, boolean isMutant) {
        String dnaAsString = Arrays.toString(dna);


        Optional<ADN> existingDna = ADNRepository.findByDna(dnaAsString);


        if (existingDna.isPresent()) {
            return existingDna.get();
        }

        ADN ADNEntity = new ADN();
        ADNEntity.setDna(dna);
        ADNEntity.setMutant(isMutant);
        return ADNRepository.save(ADNEntity);
    }
}
