package org.example.driver;

import org.example.view.FolderFrameGillum;

public class FundFolderDriverGillum {
    public static void main(String[] args) {

        FolderFrameGillum folderFrameGillum = new FolderFrameGillum();


//        Envelope gas = new Envelope("Gas", 'n', 145.65);
//        Envelope groceries = new Envelope("Groceries", 'n', 145.65);
//        FundFolder week1 = new FundFolder(134.32, 123.45);
//        week1.a`ddEnvelope(gas);
//        week1.addEnvelope(groceries);
//
//        System.out.println(week1);


//        Scanner scnr = new Scanner(System.in);
//        final int ZERO = 0;
//        final int ONE = 1;
//        String folderName;
//        String envelopeName;
//        String envelopeType;
//        double monthlyIncome;
//        boolean doneInputting = false;
//
//        FundFolder folder = new FundFolder();
//        FileHelper fh = new FileHelper();
//
//        System.out.println("1. Create New Folder.");
//        System.out.println("0. Load Existing Folder.");
//        System.out.print("Start: ");
//        int folderChoice = scnr.nextInt();
//
//        if (folderChoice == ONE) {
//            scnr.nextLine();
//            System.out.print("Enter folder name: ");
//            folderName = scnr.nextLine();
//            folder.setFolderName(folderName);
//            do {
//                System.out.println("'1' to Enter Envelope '0' to Exit: ");
//                try {
//                    int exit = scnr.nextInt();
//                    scnr.nextLine();
//                    if (exit == ZERO) {
//                        System.out.println("9You have finished inputting envelopes");
//                        doneInputting = true;
//                    } else {
//                        System.out.print("Envelope name: ");
//                        envelopeName = scnr.nextLine();
//                        boolean validType = false;
//                        do {
//                            System.out.print("Enter (W)ant or (N)eed: ");
//                            envelopeType = scnr.nextLine();
//                            envelopeType = envelopeType.toLowerCase();
//                            if (envelopeType.charAt(ZERO) == 'w') {
//                                validType = true;
//                            } else if (envelopeType.charAt(ZERO) == 'n') {
//                                validType = true;
//                            } else {
//                                System.out.println("Enter type 'W' or 'N'");
//                            }
//                        } while (!validType);
//
//                        Envelope envelope = new Envelope(envelopeName, envelopeType.charAt(0));
//                        folder.addEnvelope(envelope);
//                    }
//                } catch (InputMismatchException e) {
//                    System.out.println("Enter a number: '1' to continue, '0' to exit");
//                    scnr.nextLine();
//                }
//            } while (!doneInputting);
//            boolean validIncome = false;
//            do {
//                System.out.print("Enter monthly income: ");
//                String inputtedIncome = scnr.nextLine();
//                try {
//                    monthlyIncome = Double.parseDouble(inputtedIncome);
//                    validIncome = true;
//                    folder.setMonthlyIncome(monthlyIncome);
//                } catch (NumberFormatException e) {
//                    System.out.println("\nEnter valid format ('00.00')");
//                }
//            } while (!validIncome);
//
//            folder.calculateTotals();
//            System.out.println(folder.getResults());
//
//            System.out.print("Would you like to save ('y' or 'n'): ");
//            if (scnr.nextLine().equals("y")) {
//                fh.writeFile(folder);
//                System.out.println("File saved.");
//            } else {
//                System.out.println("File not saved.");
//            }
//
//        } else if (folderChoice == ZERO) {
//            scnr.nextLine();
//            System.out.print("Enter folder name: ");
//            folderName = scnr.nextLine();
//
//            folder = fh.readFile(folderName);
//            folder.calculateTotals();
//
//            System.out.println(folder.getResults());
//        }
    }
}
