package org.example.view;

import org.example.model.FundFolderGillum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Objects;

public class CompoundInterestFrameGillum extends JFrame implements ActionListener {

    DecimalFormat df = new DecimalFormat("$00.00");

    JTextField principalT;
    JTextField interestRateT;
    JTextField compoundT;
    JTextField yearsT;

    JButton calcBtn;
    JButton backBtn;
    JButton resetBtn;

    JLabel totalO;
    JLabel interestEarnedO;

    public CompoundInterestFrameGillum() {

        // Images
        ImageIcon calc = new ImageIcon(Objects.requireNonNull(getClass().getResource("/calc.png")));
        this.setIconImage(calc.getImage());
        this.getContentPane().setBackground(new Color(225, 225, 225));

        // Principle
        JLabel principleL = new JLabel("Principle Investment:");
        principleL.setFont(new Font("Dialog", Font.PLAIN, 20));
        principleL.setBounds(20, 20, 190, 25);

        principalT = new JTextField();
        principalT.setBounds(210, 23, 100, 25);
        principalT.setFont(new Font("Dialog", Font.PLAIN, 15));

        // Interest Rate
        interestRateT = new JTextField();
        interestRateT.setBounds(210, 63, 100, 25);
        interestRateT.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel interestRateL = new JLabel("Interest Rate: ");
        interestRateL.setFont(new Font("Dialog", Font.PLAIN, 20));
        interestRateL.setBounds(20, 60, 190, 25);

        // Compound
        compoundT = new JTextField();
        compoundT.setBounds(210, 103, 100, 25);
        compoundT.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel compoundL = new JLabel("Times Compounded: ");
        compoundL.setFont(new Font("Dialog", Font.PLAIN, 20));
        compoundL.setBounds(20, 100, 190, 25);

        // Years
        yearsT = new JTextField();
        yearsT.setBounds(210, 153, 100, 25);
        yearsT.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel yearsL = new JLabel("Years: ");
        yearsL.setFont(new Font("Dialog", Font.PLAIN, 20));
        yearsL.setBounds(20, 150, 190, 25);

        // Separator
        JSeparator line = new JSeparator();
        line.setBounds(20, 200, 300, 2);
        line.setBackground(Color.BLACK);

        // Total
        JLabel totalL = new JLabel("Total Amount: ");
        totalL.setFont(new Font("Dialog", Font.PLAIN, 20));
        totalL.setBounds(20, 220, 190, 25);

        totalO = new JLabel();
        totalO.setFont(new Font("Dialog", Font.PLAIN, 20));
        totalO.setBounds(200, 220, 190, 25);

        // Interest Earned
        JLabel interestEarnedL = new JLabel("Interest Earned: ");
        interestEarnedL.setFont(new Font("Dialog", Font.PLAIN, 20));
        interestEarnedL.setBounds(20, 260, 190, 25);

        interestEarnedO = new JLabel();
        interestEarnedO.setFont(new Font("Dialog", Font.PLAIN, 20));
        interestEarnedO.setBounds(200, 260, 190, 25);

        // Buttons
        calcBtn = new JButton("Calculate");
        calcBtn.setBounds(50, 330, 120, 35);
        calcBtn.addActionListener(this);
        calcBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        calcBtn.setFocusable(false);
        calcBtn.setForeground(new Color(0xffffff));
        calcBtn.setBackground(new Color(0x254a2f));
        calcBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        backBtn = new JButton("Home");
        backBtn.setBounds(220, 330, 115, 35);
        backBtn.addActionListener(this);
        backBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        backBtn.setFocusable(false);
//        backBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        backBtn.setForeground(new Color(0xffffff));
        backBtn.setBackground(new Color(0x254a2f));
        backBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        // Title
        JLabel title = new JLabel("Compound Interest Calculator");
        title.setFont(new Font(null, Font.BOLD, 25));
        title.setBounds(0, 0, 400, 40);

        JPanel banner = new JPanel();
        banner.setBorder(BorderFactory.createLineBorder(Color.black));
        banner.setBounds(0, 0, 400, 40);
        banner.setBackground(new Color(0x71967b));
        banner.setOpaque(true);
        banner.add(title);

        // Panels
        JPanel contentFrame = new JPanel();
        contentFrame.setLayout(null);
        contentFrame.setBounds(30, 15, 330, 300);
        contentFrame.setBackground(new Color(0xB7E3B2));
        contentFrame.add(principleL);
        contentFrame.add(principalT);
        contentFrame.add(interestRateL);
        contentFrame.add(interestRateT);
        contentFrame.add(compoundL);
        contentFrame.add(compoundT);
        contentFrame.add(yearsL);
        contentFrame.add(yearsT);
        contentFrame.add(line);
        contentFrame.add(totalL);
        contentFrame.add(totalO);
        contentFrame.add(interestEarnedL);
        contentFrame.add(interestEarnedO);

        JPanel holderFrame = new JPanel();
        holderFrame.setLayout(null);
        holderFrame.setBounds(0, 40, 400, 375);
        holderFrame.setBackground(new Color(0xd9f5d5));
        holderFrame.add(contentFrame);
        holderFrame.add(calcBtn);
        holderFrame.add(backBtn);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400, 450);
        this.setLayout(null);
        this.add(banner);
        this.add(holderFrame);
//        this.add(contentFrame);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            FolderFrameGillum home = new FolderFrameGillum();
        } else if (e.getSource() == calcBtn) {
            try {
                double principle = Double.parseDouble(principalT.getText());
                double rate = Double.parseDouble(interestRateT.getText());
                int compound = Integer.parseInt(compoundT.getText());
                int years = Integer.parseInt(yearsT.getText());

                FundFolderGillum folder = new FundFolderGillum();
                double total = folder.compoundInterest(principle, rate, compound, years);
                double interestEarned = total - principle;

                totalO.setText(String.valueOf(df.format(total)));
                interestEarnedO.setText(String.valueOf(df.format(interestEarned)));

                principalT.setText("");
                interestRateT.setText("");
                compoundT.setText("");
                yearsT.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input invalid, enter valid number format.\nExamples: \nPrincipal (1000.00), \nRate (0.05), \nCompounded (4), \nYears (1).");
            }
        }
    }
}
