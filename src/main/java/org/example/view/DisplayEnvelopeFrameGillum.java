package org.example.view;

import org.example.controller.FileHelperGillum;
import org.example.model.EnvelopeGillum;
import org.example.model.FundFolderGillum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Objects;

public class DisplayEnvelopeFrameGillum extends JFrame implements ActionListener {

    private FundFolderGillum folder;
    private JButton backBtn;

    public DisplayEnvelopeFrameGillum(String fileName) {

        // Images
        ImageIcon displayedFolder = new ImageIcon(Objects.requireNonNull(getClass().getResource("/display_folder.png")));
        this.setIconImage(displayedFolder.getImage());
        this.getContentPane().setBackground(new Color(225, 225, 225));

        FileHelperGillum fh = new FileHelperGillum();
        this.folder = fh.readFile(fileName);
        final int GRID_SIZE = folder.getEnvelopes().size();
        DecimalFormat df = new DecimalFormat("$00.00");

        // Labels / Panels
        JPanel header = new JPanel(new GridLayout(1, 3));
        header.setBackground((new Color(0xA9C7A0)));
        header.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel headerName = new JLabel("Envelope", SwingConstants.CENTER);
        headerName.setFont(new Font("Dialog", Font.BOLD, 14));
        header.add(headerName);

        JLabel headerType = new JLabel("Type", SwingConstants.CENTER);
        headerType.setFont(new Font("Dialog", Font.BOLD, 14));
        header.add(headerType);

        JLabel headerAmount = new JLabel("Amount", SwingConstants.CENTER);
        headerAmount.setFont(new Font("Dialog", Font.BOLD, 14));
        header.setBorder((BorderFactory.createEmptyBorder(0, 0, 0, 10)));
        header.add(headerAmount);

        // Divider
        JPanel divider = new JPanel();
        divider.setPreferredSize(new Dimension(300, 2));
        divider.setBackground(new Color(0x254A2F));

        // Margin
        JPanel margin = new JPanel();
        margin.setPreferredSize(new Dimension(30, 300));

        // Banner
        JLabel title = new JLabel(fileName);
        title.setFont(new Font(null, Font.BOLD, 25));
        JPanel banner = new JPanel();
        banner.setBorder(BorderFactory.createLineBorder(Color.black));
        banner.setBackground(new Color(0x71967b));
        banner.setOpaque(true);
        banner.add(title, BorderLayout.CENTER);

        // Top Panel
        JPanel folderPanel = new JPanel();
        folderPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x254A2F)), // top & bottom border separator
                BorderFactory.createEmptyBorder(4, 15, 4, 15))
        );
        folderPanel.setBackground(new Color(0x71967b));

        JLabel monthlyIncome = new JLabel("Monthly Income: " + df.format(folder.getMonthlyIncome()));
        monthlyIncome.setFont(new Font("Dialog", Font.BOLD, 13));
        monthlyIncome.setForeground(Color.WHITE);
        folderPanel.add(monthlyIncome);

        JLabel allocatedSavings = new JLabel("Savings: " + df.format(folder.getSavingsAmount()));
        allocatedSavings.setFont(new Font("Dialog", Font.BOLD, 13));
        allocatedSavings.setForeground(Color.WHITE);
        folderPanel.add(allocatedSavings);

        // Table Panel
        JPanel envelopePanel = new JPanel();
        envelopePanel.setLayout(new GridLayout(GRID_SIZE, 3, 5, 5));
        envelopePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        for (EnvelopeGillum e : folder.getEnvelopes()) {
            JLabel name = new JLabel(e.getName(), SwingConstants.LEFT);
            name.setFont(new Font("Dialog", Font.PLAIN, 12));
            name.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

            JLabel category = new JLabel(String.valueOf(e.getType()), SwingConstants.CENTER);
            category.setFont(new Font("Dialog", Font.PLAIN, 12));

            JLabel allocatedAmount = new JLabel(String.valueOf(df.format(e.getAllocatedAmount())), SwingConstants.RIGHT);
            allocatedAmount.setFont(new Font("Dialog", Font.PLAIN, 12));
            allocatedAmount.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

            envelopePanel.add(name);
            envelopePanel.add(category);
            envelopePanel.add(allocatedAmount);
        }

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(header, BorderLayout.NORTH);
        contentPanel.add(divider, BorderLayout.CENTER);

        JPanel scrollArea = new JPanel(new BorderLayout());
        scrollArea.add(envelopePanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(scrollArea);
        scrollPane.setBorder(null);

        contentPanel.add(scrollPane);

        JPanel framePanel = new JPanel();
        framePanel.setLayout(new BorderLayout());
        framePanel.add(folderPanel, BorderLayout.NORTH);
        framePanel.add(contentPanel, BorderLayout.CENTER);

        // Buttons
        backBtn = new JButton("Home");
//        backBtn.setBounds(65, 150, 115, 35);
        backBtn.addActionListener(this);
        backBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        backBtn.setFocusable(false);
//        backBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        backBtn.setForeground(new Color(0xffffff));
        backBtn.setBackground(new Color(0x254a2f));
        backBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        // Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350, 300);
        this.setLayout(new BorderLayout());
//        this.add(margin, BorderLayout.WEST);
        this.add(banner, BorderLayout.NORTH);
        this.add(framePanel, BorderLayout.CENTER);;
        this.add(backBtn, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            FolderFrameGillum home = new FolderFrameGillum();
        }
    }
}
