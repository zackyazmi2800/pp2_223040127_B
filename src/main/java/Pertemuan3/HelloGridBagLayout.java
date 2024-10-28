package Pertemuan3;

import java.awt.*;
import javax.swing.*;

public class HelloGridBagLayout extends JFrame {
    
    public HelloGridBagLayout() {
        // Set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a header label
        JLabel headerLabel = new JLabel("Layout in action: GridBagLayout", JLabel.CENTER);
        
        // Create control panel with FlowLayout
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        // Create the main panel with GridBagLayout
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setSize(300, 300);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        // Create GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Add Button 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JButton("Button 1"), gbc);
        
        // Add Button 2
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);
        
        // Add Button 3 with additional padding (ipady)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 20; // Increase height
        panel.add(new JButton("Button 3"), gbc);
        
        // Add Button 4
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 0; // Reset padding
        panel.add(new JButton("Button 4"), gbc);
        
        // Add Button 5 spanning two columns
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 5"), gbc);
        
        // Add the panel to the control panel
        controlPanel.add(panel);
        
        // Set layout for the frame
        this.setLayout(new GridLayout(2, 1));
        
        // Add header and control panel to the frame
        this.add(headerLabel);
        this.add(controlPanel);
        
        // Set frame size
        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridBagLayout h = new HelloGridBagLayout();
                h.setVisible(true);
            }
        });
    }
}
