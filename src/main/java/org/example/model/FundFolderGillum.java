package org.example.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FundFolderGillum {
    private ArrayList<EnvelopeGillum> envelopes;
    private String folderName;
    private double monthlyIncome;
    private double savingsAmount;

    DecimalFormat df = new DecimalFormat("$00.00");

    // Default
    public FundFolderGillum() {
        envelopes = new ArrayList<>();
    }

    // Non-Default
    public FundFolderGillum(String folderName, double monthlyIncome, double savingsAmount) {
        this.envelopes = new ArrayList<EnvelopeGillum>();
        this.folderName = folderName;
        this.monthlyIncome = monthlyIncome;
        this.savingsAmount = savingsAmount;
    }

    // Getters
    public ArrayList<EnvelopeGillum> getEnvelopes() {
        return envelopes;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getSavingsAmount() {
        return savingsAmount;
    }

    public String getFolderName() {
        return folderName;
    }

    // Setters
    public void setEnvelopes(ArrayList<EnvelopeGillum> envelopes) {
        this.envelopes = envelopes;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setSavingsAmount(double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    // Helpers
    @Override
    public String toString() {
        return "FundFolder{" +
                "envelopes=" + envelopes +
                ", totalIncome=" + monthlyIncome +
                ", savingsAmount=" + savingsAmount +
                '}';
    }

    public String getResults() {
        StringBuilder sb = new StringBuilder();
        sb.append("Budget Summary").append(" - ").append("Monthly Income: ").append(monthlyIncome).append(" - ").append("Savings: ").append(getSavingsAmount()) .append("\n");
        for(EnvelopeGillum e : envelopes) {
            sb.append(e.getName()).append(" - ").append(e.getType()).append(" - ").append(df.format(e.getAllocatedAmount())).append("\n");
        }

        return sb.toString();
    }

    public void addEnvelope(EnvelopeGillum envelope) {
        envelopes.add(envelope);
    }

    public void calculateTotals() {
        final double NEEDS = 0.50;
        final double WANTS = 0.30;
        final double SAVINGS = 0.20;

        double calculatedWants = monthlyIncome * WANTS;
        double calculatedNeeds = monthlyIncome * NEEDS;
        double calculatedSavings = monthlyIncome * SAVINGS;

        int wantCount = 0;
        int needCount = 0;

        for (EnvelopeGillum e : envelopes) {
            if (e.getType() == 'W') {
                wantCount++;
            } else {
                needCount++;
            }
        }

        double amountForWants = 0.0;
        double amountForNeeds = 0.0;
        double savingsTotal = 0.0;

        amountForWants = calculatedWants / wantCount;
        amountForNeeds = calculatedNeeds / needCount;
        savingsTotal = calculatedSavings;

        for (EnvelopeGillum e : envelopes) {
            if (e.getType() == 'W') {
                e.setAllocatedAmount(amountForWants);
            } else {
                e.setAllocatedAmount(amountForNeeds);
            }
        }

        setSavingsAmount(savingsTotal);
    }

    public double compoundInterest(double originalAmount, double interestRate, int timesCompounded, int years) {
        final int ONE = 1;

        double total = originalAmount * Math.pow((ONE + interestRate / timesCompounded), timesCompounded * years);

        return total;

    }

}
