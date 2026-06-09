package org.example.model;

public class EnvelopeGillum {
    private String name;
    private char type;
    private double allocatedAmount;

    // Default
    public EnvelopeGillum() {
        this.allocatedAmount = 0.0;
    }

    // Non-Default
    public EnvelopeGillum(String name, char type) {
        this.name = name;
        this.type = type;
    }

    // Getters
    public String getName() {
        String capedName = "";

        if (name.isEmpty()) {
            name = "";
        } else {
            capedName = name.substring(0, 1).toUpperCase() + name.substring(1);
        }

        return capedName;
    }

    public char getType() {
        return Character.toUpperCase(type);
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    // Helpers
    @Override
    public String toString() {
        return "Envelope{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", allocatedAmount=" + allocatedAmount +
                '}';
    }
}
