package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

public class LoadEnvelopeFrameGillum extends JFrame implements ActionListener {

    private JButton backBtn;
    private JButton openFolder;

    public LoadEnvelopeFrameGillum() {

        // Images
        ImageIcon loadFolder = new ImageIcon(Objects.requireNonNull(getClass().getResource("/load_folder.png")));
        this.setIconImage(loadFolder.getImage());
        this.getContentPane().setBackground(new Color(225, 225, 225));

        // Labels
        JLabel title = new JLabel("Load Folder");
        title.setFont(new Font(null, Font.BOLD, 25));
        title.setBounds(0, 0, 250, 50);

        JPanel banner = new JPanel();
        banner.setBorder(BorderFactory.createLineBorder(Color.black));
        banner.setBounds(0, 0, 250, 50);
        banner.setBackground(new Color(0x71967b));
        banner.setOpaque(true);

        // Buttons
        backBtn = new JButton("Home");
        backBtn.setBounds(65, 150, 115, 35);
        backBtn.addActionListener(this);
        backBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
        backBtn.setFocusable(false);
//        backBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        backBtn.setForeground(new Color(0xffffff));
        backBtn.setBackground(new Color(0x254a2f));
        backBtn.setBorder(BorderFactory.createLineBorder(Color.black));

        openFolder = new JButton("Open Existing Folder");
        openFolder.addActionListener(this);
        openFolder.setBounds(35, 75, 175, 35);
        openFolder.setFont(new Font("Dialog", Font.PLAIN, 15));
        openFolder.setFocusable(false);
//        backBtn.setIcon(envelopeIcon);
//        loadFileBtn.setIconTextGap(); // - to bring closer + to push away
        openFolder.setForeground(new Color(0xffffff));
        openFolder.setBackground(new Color(0x254a2f));
        openFolder.setBorder(BorderFactory.createLineBorder(Color.black));

        // Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 250);
        this.setLayout(null);
        banner.add(title);
        this.add(banner);
        this.add(openFolder); // Add load_folder icon
        this.add(backBtn);
//        this.pack();

        this.setVisible(true);

    }

    // Helpers
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            FolderFrameGillum home = new FolderFrameGillum();
        } else if (e.getSource() == openFolder) {
            this.dispose();
            JFileChooser folderFinder = new JFileChooser();
            int response = folderFinder.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(folderFinder.getSelectedFile().getAbsolutePath());
                DisplayEnvelopeFrameGillum displayFrame = new DisplayEnvelopeFrameGillum(file.getName().replace(".txt", ""));

            }
        }
    }
}
