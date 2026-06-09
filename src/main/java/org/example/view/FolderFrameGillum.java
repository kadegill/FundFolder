package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FolderFrameGillum extends JFrame implements ActionListener {

    private JButton loadFileBtn;
    private JButton createEnvelopeBtn;
    JButton compoundInterestBtn;

    public FolderFrameGillum() {

        // Images
        ImageIcon folderIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/folder_icon.png")));
        this.setIconImage(folderIcon.getImage());
        this.getContentPane().setBackground(new Color(225, 225, 225));

        // Labels
        JLabel title = new JLabel("Fund Folder");
        title.setFont(new Font(null, Font.BOLD, 25));
        title.setBounds(0, 0, 150, 40);

        JPanel banner = new JPanel();
        banner.setBorder(BorderFactory.createLineBorder(Color.black));
        banner.setBounds(0, 0, 300, 40);
        banner.setBackground(new Color(0x71967b));
        banner.setOpaque(true);

        // Buttons
        loadFileBtn = new JButton();
        loadFileBtn.setBounds(70, 110, 150, 35);
        loadFileBtn.addActionListener(this);
        loadFileBtn.setText("Load Folder");
        loadFileBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        loadFileBtn.setFocusable(false);
//        loadFileBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        loadFileBtn.setForeground(new Color(0xffffff));
        loadFileBtn.setBackground(new Color(0x254a2f));
        loadFileBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        // Create Btn
        createEnvelopeBtn = new JButton();
        createEnvelopeBtn.setBounds(70, 60, 150, 35);
        createEnvelopeBtn.addActionListener(this);
        createEnvelopeBtn.setText("Create Folder");
        createEnvelopeBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        createEnvelopeBtn.setFocusable(false);
//        createEnvelopeBtn.setIcon(addEnvelopeIcon);
//        createEnvelopeBtn.setHorizontalTextPosition(JButton.CENTER);
//        createEnvelopeBtn.setVerticalTextPosition(JButton.EAST);
//        createEnvelopeBtn.setPreferredSize();
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        createEnvelopeBtn.setForeground(new Color(0xffffff));
        createEnvelopeBtn.setBackground(new Color(0x254a2f));
        createEnvelopeBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        // CI Btn
        compoundInterestBtn = new JButton();
        compoundInterestBtn.setText("CI");
        compoundInterestBtn.addActionListener(this);
        compoundInterestBtn.setBounds(235, 110, 35, 35);
        compoundInterestBtn.setFocusable(false);
        compoundInterestBtn.setForeground(new Color(0xffffff));
        compoundInterestBtn.setBackground(new Color(0x254a2f));
        compoundInterestBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        // Frame
        this.setTitle("Fund Folder 2025");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300, 200);
        this.setLayout(null);
        banner.add(title);
        this.add(banner);
        this.add(loadFileBtn);
        this.add(createEnvelopeBtn);
        this.add(compoundInterestBtn);

        this.setVisible(true);

    }

    // Helpers
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadFileBtn) {
            this.dispose();
            LoadEnvelopeFrameGillum loadEnvelope = new LoadEnvelopeFrameGillum();
        } else if (e.getSource() == createEnvelopeBtn) {
            this.dispose();
            CreateEnvelopeFrameGillum createEnvelope = new CreateEnvelopeFrameGillum();
        } else if (e.getSource() == compoundInterestBtn) {
            this.dispose();
            CompoundInterestFrameGillum ciFrame = new CompoundInterestFrameGillum();
        }
    }
}
