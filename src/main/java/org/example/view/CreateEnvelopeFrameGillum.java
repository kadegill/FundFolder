package org.example.view;

import org.example.controller.FileHelperGillum;
import org.example.model.EnvelopeGillum;
import org.example.model.FundFolderGillum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CreateEnvelopeFrameGillum extends JFrame implements ActionListener {

    private JButton backBtn;
    private JButton submitBtn;
    private JButton doneBtn;
    private JTextField folderNameT;
    private JTextField incomeT;
    private JTextField categoryNameT;
    private JTextField categoryTypeT;
    private FundFolderGillum folder = new FundFolderGillum();
    private FileHelperGillum fh = new FileHelperGillum();

    public CreateEnvelopeFrameGillum() {

        // Images
        ImageIcon addEnvelopeIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/add_envelope.png")));
        this.setIconImage(addEnvelopeIcon.getImage());
        this.getContentPane().setBackground(new Color(225, 225, 225));


        ImageIcon envelopeIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/envelope_icon.png")));
        JLabel envelopeLabel = new JLabel();
        envelopeLabel.setBounds(140, 213, 50, 50);
        envelopeLabel.setIcon(envelopeIcon);


        // Labels
        JLabel title = new JLabel("Create Folder");
        title.setFont(new Font(null, Font.BOLD, 25));
        title.setBounds(0, 0, 350, 40);

        JPanel banner = new JPanel();
        banner.setBorder(BorderFactory.createLineBorder(Color.black));
        banner.setBounds(0, 0, 350, 40);
        banner.setBackground(new Color(0x71967b));
        banner.setOpaque(true);

        JLabel folderName = new JLabel("Folder Name");
        folderName.setFont(new Font("Dialog", Font.PLAIN, 20));
        folderName.setBounds(30, 45, 200, 35);

        JLabel income = new JLabel("Monthly Income");
        income.setFont(new Font("Dialog", Font.PLAIN, 20));
        income.setBounds(180, 45, 200, 35);

        JLabel categoryNameL = new JLabel("Envelope Name:");
        categoryNameL.setFont(new Font("Dialog", Font.PLAIN, 15));
        categoryNameL.setBounds(15, 95, 175, 50);

        JLabel typeL = new JLabel("Envelope Type:");
        typeL.setFont(new Font("Dialog", Font.PLAIN, 15));
        typeL.setBounds(175, 95, 175, 50);

        // Text Box
        folderNameT = new JTextField();
        folderNameT.setPreferredSize(new Dimension(250, 30));
        folderNameT.setBounds(15, 75, 150, 30);
        folderNameT.setFont(new Font("Dialog", Font.PLAIN, 15));

        incomeT = new JTextField();
        incomeT.setPreferredSize(new Dimension(250, 30));
        incomeT.setBounds(175, 75, 150, 30);
        incomeT.setFont(new Font("Dialog", Font.PLAIN, 15));

        categoryNameT = new JTextField();
        categoryNameT.setPreferredSize(new Dimension(250, 30));
        categoryNameT.setBounds(15, 135, 150, 30);
        categoryNameT.setFont(new Font("Dialog", Font.PLAIN, 15));

        categoryTypeT = new JTextField();
        categoryTypeT.setPreferredSize(new Dimension(250, 30));
        categoryTypeT.setBounds(175, 135, 150, 30);
        categoryTypeT.setFont(new Font("Dialog", Font.PLAIN, 15));

        // Buttons
        backBtn = new JButton("Home");
        backBtn.setBounds(205, 220, 115, 35);
        backBtn.addActionListener(this);
        backBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        backBtn.setFocusable(false);
//        backBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        backBtn.setForeground(new Color(0xffffff));
        backBtn.setBackground(new Color(0x254a2f));
        backBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        submitBtn = new JButton("Add Envelope");
        submitBtn.addActionListener(this);
        submitBtn.setBounds(105, 175, 130, 35);
        submitBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        submitBtn.setFocusable(false);
//        backBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        submitBtn.setForeground(new Color(0xffffff));
        submitBtn.setBackground(new Color(0x254a2f));
        submitBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        doneBtn = new JButton("Save");
        doneBtn.addActionListener(this);
        doneBtn.setBounds(15, 220, 110, 35);
        doneBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        doneBtn.setFocusable(false);
//        backBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        doneBtn.setForeground(new Color(0xffffff));
        doneBtn.setBackground(new Color(0x254a2f));
        doneBtn.setBorder(BorderFactory.createLineBorder(Color.black));


        // Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350, 300);
        this.setLayout(null);
        banner.add(title);
        this.add(banner);
        this.add(folderName);
        this.add(income);
        this.add(categoryNameL);
        this.add(typeL);
        this.add(folderNameT);
        this.add(incomeT);
        this.add(categoryNameT);
        this.add(categoryTypeT);
        this.add(submitBtn);
        this.add(envelopeLabel);
        this.add(doneBtn);
        this.add(backBtn);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            FolderFrameGillum home = new FolderFrameGillum();
        } else if (e.getSource() == submitBtn) {

            String categoryName = "";
            char categoryType = ' ';

            if (!categoryNameT.getText().isEmpty()) {
                categoryName = categoryNameT.getText();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a envelope name");
            }

            if (!categoryTypeT.getText().isEmpty()) {
                String wantOrNeed = categoryTypeT.getText().toLowerCase();
                if (wantOrNeed.equalsIgnoreCase("want") || wantOrNeed.equalsIgnoreCase("need") || wantOrNeed.equalsIgnoreCase("w") || wantOrNeed.equalsIgnoreCase("n"))  {
                    categoryType = wantOrNeed.charAt(0);
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter (W)ant or (N)eed");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please enter envelope type");
            }

            EnvelopeGillum envelope = new EnvelopeGillum(categoryName, categoryType);
            folder.addEnvelope(envelope);

            if (!categoryNameT.getText().isEmpty() && !categoryTypeT.getText().isEmpty()) {
                clearCategoryFields();
            }

        } else if (e.getSource() == doneBtn) {

            String folderName = "";
            String inputtedIncome = "";
            double monthlyIncome = 0.0;

            if (!folderNameT.getText().isEmpty()) {
                folderName = folderNameT.getText();
            } else {
                JOptionPane.showMessageDialog(this, "Enter folder name");
            }
            folder.setFolderName(folderName);


            if (!incomeT.getText().isEmpty()) {
                inputtedIncome = incomeT.getText();
            } else {
                JOptionPane.showMessageDialog(this, "Enter monthly income");
            }

            try {
                monthlyIncome = Double.parseDouble(inputtedIncome);
                folder.setMonthlyIncome(monthlyIncome);

                folder.calculateTotals();
                fh.writeFile(folder);

                JOptionPane.showMessageDialog(this, "Folder '" + folderName + "' saved!");

                clearFolderFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid format. Ensure income is '00.00'");
            }

        }
    }

    private void clearCategoryFields() {
        categoryNameT.setText("");
        categoryTypeT.setText("");

    }

    private void clearFolderFields() {
        folderNameT.setText("");
        incomeT.setText("");

    }
}
