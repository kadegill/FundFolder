package org.example.test;

import org.example.model.EnvelopeGillum;
import org.example.model.FundFolderGillum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FundFolderGillumTest {

    private FundFolderGillum folder;

    @BeforeEach
    public void testFolder() {
        folder = new FundFolderGillum();

        folder.setFolderName("TestFolder");
        folder.setMonthlyIncome(1200.00);

        EnvelopeGillum test1 = new EnvelopeGillum("Gas", 'n');
        folder.addEnvelope(test1);
        EnvelopeGillum test2 = new EnvelopeGillum("Games", 'w');
        folder.addEnvelope(test2);

    }

    @Test
    public void testAddEnvelopeEnvelope() {
        int beginingSize = folder.getEnvelopes().size();
        EnvelopeGillum testNewEnvelope = new EnvelopeGillum("Groceries", 'N');

        folder.addEnvelope(testNewEnvelope);

        assertEquals(beginingSize + 1, folder.getEnvelopes().size(), "Should be 3");

    }

//    public void addEnvelope(Envelope envelope) {
//        envelopes.add(envelope);
//    }

    @Test
    public void testCalculateTotals() {
        folder.calculateTotals();

        // Savings
        assertEquals(240.00, folder.getSavingsAmount(), "20% of 1200 is 240");

        // Needs
        ArrayList<EnvelopeGillum> testEnvelopes = folder.getEnvelopes();
        assertEquals(600.00, testEnvelopes.get(0).getAllocatedAmount(), 0.01, "50% of 1200 is 600");

        // Wants
        assertEquals(360.00, testEnvelopes.get(1).getAllocatedAmount(), 0.01, "30% of 1200 is 360");

    }

//    public void calculateTotals() {
//        final double NEEDS = 0.50;
//        final double WANTS = 0.30;
//        final double SAVINGS = 0.20;
//
//        int wantCount = 0;
//        int needCount = 0;
//
//        for (Envelope e : envelopes) {
//            if (e.getType() == 'w') {
//                wantCount++;
//            } else {
//                needCount++;
//            }
//        }
//
//        double calculatedWants = monthlyIncome * WANTS;
//        double calculatedNeeds = monthlyIncome * NEEDS;
//        double calculatedSavings = monthlyIncome * SAVINGS;
//
//        for (Envelope e : envelopes) {
//            if (e.getType() == 'w') {
//                e.setAllocatedAmount(calculatedWants);
//            } else {
//                e.setAllocatedAmount(calculatedNeeds);
//            }
//        }
//
//        setSavingsAmount(calculatedSavings);
//    }

    @Test
    public void testCompoundInterestDoubleDoubleIntInt() {
        double p = 1000.00;
        double r = 0.05;
        int timesCompounded = 4;
        int years = 1;

        double ciResult = folder.compoundInterest(p, r, timesCompounded, years);

        assertEquals(1050.95, ciResult, 0.01, "Compound interest over a year should be 1050.95");
    }

//    public double compoundInterest(double originalAmount, double interestRate, int timesCompounded, int years) {
//        final int ONE = 1;
//
//        double total = originalAmount * Math.pow((ONE + interestRate / timesCompounded), timesCompounded * years);
//
//        return total;
//
//    }
}
