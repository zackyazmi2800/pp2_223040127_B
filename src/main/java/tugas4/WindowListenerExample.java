/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas4;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author zack
 */

public class WindowListenerExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("WindowListener Example");

        // Membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Lakukan operasi pada jendela.");
        label.setBounds(50, 150, 300, 30);

        // Menambahkan WindowListener ke frame
        frame.addWindowListener(new WindowListener() {
            // Dijalankan ketika jendela dibuka
            public void windowOpened(WindowEvent e) {
                label.setText("Window Opened.");
                System.out.println("Window Opened.");
            }

            // Dijalankan ketika jendela sedang dalam proses penutupan
            public void windowClosing(WindowEvent e) {
                label.setText("Window Closing.");
                System.out.println("Window Closing.");
                // Bisa menambahkan System.exit(0); jika ingin menghentikan program
            }

            // Dijalankan ketika jendela benar-benar ditutup
            public void windowClosed(WindowEvent e) {
                System.out.println("Window Closed.");
                System.out.println("Window Closing.");
            }

            // Dijalankan ketika jendela diminimalkan
            public void windowIconified(WindowEvent e) {
                label.setText("Window Minimized.");
                System.out.println("Window Minimized.");
            }

            // Dijalankan ketika jendela dipulihkan dari minimalkan
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window Restored.");
                System.out.println("Window Restored.");
            }

            // Dijalankan ketika jendela menjadi aktif (berfokus)
            public void windowActivated(WindowEvent e) {
                label.setText("Window Activated.");
                System.out.println("Window Activated.");
                
            }

            // Dijalankan ketika jendela kehilangan fokus
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window Deactivated.");
                System.out.println("Window Deactivated.");
            }
        });

        // Menambahkan label ke frame
        frame.add(label);

        // Setting frame
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Agar jendela benar-benar tertutup
    }
}
