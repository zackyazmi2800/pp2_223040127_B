// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// public class HelloGridLayout extends JFrame implements ActionListener {
//     private JButton buttonA;
//     private JButton buttonB; 
//     private JButton buttonC; 
//     private JButton buttonD; 
//     private JButton buttonE; 
//     private JButton buttonF; 
//     private JButton buttonG; 
//     private JButton buttonH; 
//     private JButton buttonI;

//     private JButton[] buttons; 
//     private boolean gameOver;

//     public HelloGridLayout() {
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         gameOver = false;

//         // Initialize buttons
//         buttonA = new JButton("");
//         buttonB = new JButton("");
//         buttonC = new JButton("");
//         buttonD = new JButton("");
//         buttonE = new JButton("");
//         buttonF = new JButton("");
//         buttonG = new JButton("");
//         buttonH = new JButton("");
//         buttonI = new JButton("");

//         // Create button array
//         buttons = new JButton[9];
//         buttons[0] = buttonA;
//         buttons[1] = buttonB;
//         buttons[2] = buttonC;
//         buttons[3] = buttonD;
//         buttons[4] = buttonE;
//         buttons[5] = buttonF;
//         buttons[6] = buttonG;
//         buttons[7] = buttonH;
//         buttons[8] = buttonI;

//         buttonA.addActionListener(this);
//         buttonB.addActionListener(this);
//         buttonC.addActionListener(this);
//         buttonD.addActionListener(this);
//         buttonE.addActionListener(this);
//         buttonF.addActionListener(this);
//         buttonG.addActionListener(this);
//         buttonH.addActionListener(this);
//         buttonI.addActionListener(this);

//         this.setLayout(new GridLayout(3, 3));

//         this.add(buttonA); 
//         this.add(buttonB); 
//         this.add(buttonC); 
//         this.add(buttonD); 
//         this.add(buttonE); 
//         this.add(buttonF); 
//         this.add(buttonG); 
//         this.add(buttonH); 
//         this.add(buttonI);

//         this.setSize(300, 300);
//     }

//     public void actionPerformed(ActionEvent e) {
//         if (!gameOver) {
//             JButton button = (JButton) e.getSource();
//             if (button.getText().isEmpty()) {
//                 button.setText("O"); 
//                 checkWinner();
//                 if (!gameOver) {
//                     for (int i = 0; i < buttons.length; i++) {
//                         if (buttons[i].getText().isEmpty()) {
//                             buttons[i].setText("X");
//                             break; 
//                         }
//                     }
//                     checkWinner();
//                 }
//             }
//         }
//     }


//     private void checkWinner() {
//         String winner = "";
//         if (!buttonA.getText().isEmpty()
//             && buttonA.getText().equals(buttonB.getText())
//             && buttonA.getText().equals(buttonC.getText())) {
//             winner = buttonA.getText();
//             buttonA.setForeground(Color.RED); 
//             buttonB.setForeground(Color.RED);
//             buttonC.setForeground(Color.RED);
//         } else if (!buttonD.getText().isEmpty()
//             && buttonD.getText().equals(buttonE.getText())
//             && buttonD.getText().equals(buttonF.getText())) {
//             winner = buttonD.getText();
//             buttonD.setForeground(Color.RED); 
//             buttonE.setForeground(Color.RED); 
//             buttonF.setForeground(Color.RED);
//         } else if (!buttonG.getText().isEmpty()
//             && buttonG.getText().equals(buttonH.getText())
//             && buttonG.getText().equals(buttonI.getText())) {
//             winner = buttonG.getText();
//             buttonG.setForeground(Color.RED); 
//             buttonH.setForeground(Color.RED); 
//             buttonI.setForeground(Color.RED);
//         } else if (!buttonA.getText().isEmpty()
//             && buttonA.getText().equals(buttonD.getText())
//             && buttonA.getText().equals(buttonG.getText())) {
//             winner = buttonA.getText();
//             buttonA.setForeground(Color.RED); 
//             buttonD.setForeground(Color.RED); 
//             buttonG.setForeground(Color.RED);
//         } else if (!buttonB.getText().isEmpty()
//             && buttonB.getText().equals(buttonE.getText())
//             && buttonB.getText().equals(buttonH.getText())) {
//             winner = buttonB.getText();
//             buttonB.setForeground(Color.RED); 
//             buttonE.setForeground(Color.RED); 
//             buttonH.setForeground(Color.RED);
//         } else if (!buttonC.getText().isEmpty()
//             && buttonC.getText().equals(buttonF.getText())
//             && buttonC.getText().equals(buttonI.getText())) {
//             winner = buttonC.getText();
//             buttonC.setForeground(Color.RED); 
//             buttonF.setForeground(Color.RED); 
//             buttonI.setForeground(Color.RED);
//         } else if (!buttonA.getText().isEmpty()
//             && buttonA.getText().equals(buttonE.getText())
//             && buttonA.getText().equals(buttonI.getText())) {
//             winner = buttonA.getText();
//             buttonA.setForeground(Color.RED); 
//             buttonE.setForeground(Color.RED); 
//             buttonI.setForeground(Color.RED);
//         } else if (!buttonC.getText().isEmpty()
//             && buttonC.getText().equals(buttonE.getText())
//             && buttonC.getText().equals(buttonG.getText())) {
//             winner = buttonC.getText();
//             buttonC.setForeground(Color.RED); 
//             buttonE.setForeground(Color.RED); 
//             buttonG.setForeground(Color.RED);
//         }

//         gameOver = !winner.isEmpty();
//     }

//     public static void main(String[] args) {
//         javax.swing.SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 HelloGridLayout h = new HelloGridLayout();
//                 h.setVisible(true);
//             }
//         });
//     }
// }

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloGridLayout extends JFrame implements ActionListener {
    private JButton[] buttons; // Array of buttons for the grid
    private boolean gameOver;
    private String currentPlayer;

    // Constructor to set up the GUI
    public HelloGridLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3)); // 3x3 grid for the tic-tac-toe game
        gameOver = false;
        currentPlayer = "O"; // "O" starts the game
        buttons = new JButton[9];

        // Initialize buttons and add them to the frame
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }

        this.setSize(300, 300); // Set window size
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        JButton buttonClicked = (JButton) e.getSource();

        // If button is empty, mark it with the current player's symbol
        if (buttonClicked.getText().equals("")) {
            buttonClicked.setText(currentPlayer);
            checkWinner();
            if (!gameOver) {
                // Switch player after every move
                currentPlayer = currentPlayer.equals("O") ? "X" : "O";
            }
        }
    }

    // Method to check if there's a winner
    private void checkWinner() {
        String winner = "";

        // Check rows, columns, and diagonals for a winner
        if (checkLine(0, 1, 2) || checkLine(3, 4, 5) || checkLine(6, 7, 8) || // Rows
            checkLine(0, 3, 6) || checkLine(1, 4, 7) || checkLine(2, 5, 8) || // Columns
            checkLine(0, 4, 8) || checkLine(2, 4, 6)) {                      // Diagonals
            gameOver = true;
            winner = currentPlayer;
        } else if (isBoardFull()) {
            gameOver = true;
            winner = "Draw";
        }

        if (gameOver) {
            if (!winner.equals("Draw")) {
                JOptionPane.showMessageDialog(this, "Player " + winner + " wins!");
            } else {
                JOptionPane.showMessageDialog(this, "It's a Draw!");
            }
        }
    }

    // Helper method to check if three buttons in a line are the same
    private boolean checkLine(int index1, int index2, int index3) {
        return buttons[index1].getText().equals(currentPlayer) &&
               buttons[index1].getText().equals(buttons[index2].getText()) &&
               buttons[index1].getText().equals(buttons[index3].getText());
    }

    // Helper method to check if the board is full
    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    // Main method to run the program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridLayout h = new HelloGridLayout();
                h.setVisible(true);
            }
        });
    }
}
