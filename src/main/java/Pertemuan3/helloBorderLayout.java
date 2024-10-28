package Pertemuan3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class helloBorderLayout extends JFrame {
    // Constructor to set up the GUI components
    public helloBorderLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create labels
        JLabel labelPertanyaan = new JLabel("Apakah ibukota Indonesia?");
        JLabel labelHasil = new JLabel("Jawab pertanyaan di atas");
        
        // Create buttons
        JButton buttonA = new JButton("Jakarta");
        JButton buttonB = new JButton("Bandung");
        JButton buttonC = new JButton("Surabaya");
        
        // Add action listeners to the buttons
        buttonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("Jawaban anda benar");
            }
        });
        
        buttonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("Jawaban anda salah");
            }
        });
        
        buttonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("Jawaban anda salah");
            }
        });
        
        // Set layout and add components to the frame
        this.setLayout(new BorderLayout());
        this.add(labelPertanyaan, BorderLayout.NORTH);
        this.add(labelHasil, BorderLayout.SOUTH);
        this.add(buttonA, BorderLayout.WEST);
        this.add(buttonB, BorderLayout.CENTER);
        this.add(buttonC, BorderLayout.EAST);
        
        // Set the window size
        this.setSize(400, 200);
    }
    
    // Main method to run the program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                helloBorderLayout h = new helloBorderLayout();
                h.setVisible(true);
            }
        });
    }
}
