package org.example.controller;

import org.example.model.EnvelopeGillum;
import org.example.model.FundFolderGillum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHelperGillum {


    public boolean writeFile(FundFolderGillum folder) {
        String folderName = folder.getFolderName() + ".txt";

            try {
                PrintWriter listOfObjects = new PrintWriter(folderName);

                listOfObjects.println(folder.getMonthlyIncome() + "," + folder.getSavingsAmount());

                for (EnvelopeGillum e : folder.getEnvelopes()) {
                    listOfObjects.println(e.getName() + "," + e.getType() + "," + e.getAllocatedAmount());

                }

                listOfObjects.close();

            } catch (FileNotFoundException e) {
                System.out.println("File name must not contain '/' or ' ' (use - as replacement)");
                return false;
            }

            return true;
    }

    public FundFolderGillum readFile(String folderName) {
        FundFolderGillum folder = new FundFolderGillum();
        String folderNameFormatted = folderName + ".txt";

        Scanner fileIn;

        try {
            fileIn = new Scanner(new File(folderNameFormatted));

            if (fileIn.hasNextLine()) {
                String value = fileIn.nextLine();
                String[] parts = value.split(",");

                double monthlyIncome = Double.parseDouble(parts[0]);
                folder.setMonthlyIncome(monthlyIncome);

                double savings = Double.parseDouble(parts[1]);
                folder.setSavingsAmount(savings);
            }

            while (fileIn.hasNextLine()) {
                String value = fileIn.nextLine();
                String[] parts = value.split(",");

                String name = parts[0];
                char type = parts[1].charAt(0);
                double allocatedAmount = Double.parseDouble(parts[2]);
                EnvelopeGillum currentEnvelope = new EnvelopeGillum(name, type);

                currentEnvelope.setAllocatedAmount(allocatedAmount);

                folder.addEnvelope(currentEnvelope);
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file called  '" + folderNameFormatted + "'");
        }

        return folder;
    }
}
