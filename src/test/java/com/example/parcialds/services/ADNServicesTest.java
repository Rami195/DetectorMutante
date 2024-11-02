package com.example.parcialds.services;

import com.example.parcialds.Services.ADNService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ADNServicesTest {

    // Tests  de matriz 6x6
    @Test
    public void testRows() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testColumns() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "AGAATG",
                "TGCAGT",
                "GCTTCC",
                "GTCCTC",
                "GTAGTC",
                "GGTCAC"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testMainDiagonals() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "AGAATG",
                "TACAGT",
                "GCAGCC",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testSecondaryLeftDiagonals() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "ATAATG",
                "GTTAGT",
                "GGCTCG",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testSecondaryRightDiagonals() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testTertiaryLeftDiagonals() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "ATGATG",
                "GTAGTA",
                "CCTTGG",
                "TCTAGG",
                "GGCGTC",
                "AGTCAA"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testTertiaryRightDiagonals() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "ATGATG",
                "GTATTA",
                "AATTGG",
                "ACTAGT",
                "GGAGTC",
                "AGGCAA"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testNonMutant() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "ATGATG",
                "GTCTTA",
                "AATTGG",
                "ACTAGT",
                "GGATTC",
                "AGGCAA"
        };
        assertFalse(adnService.isMutant(dna));
    }


    // -------------------------------

    @Test
    public void testMutant1() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testNonMutant1() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertFalse(adnService.isMutant(dna));
    }

    @Test
    public void testMutant2() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testMutant3() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testNonMutant2() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };
        assertFalse(adnService.isMutant(dna));
    }

    @Test
    public void testMutant4() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };
        assertTrue(adnService.isMutant(dna));
    }

    @Test
    public void testMutant5() {
        ADNService adnService = new ADNService();
        String[] dna = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        };
        assertTrue(adnService.isMutant(dna));
    }
}
