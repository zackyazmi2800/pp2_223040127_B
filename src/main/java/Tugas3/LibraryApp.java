/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author zack
 */


public class LibraryApp extends JFrame {
    public JTextField titleField, authorField;
    public JSpinner yearSpinner;
    public JComboBox<String> genreComboBox;
    public JCheckBox availabilityCheckBox;
    public JTextArea descriptionArea;
    public JList<String> typeList;
    public JRadioButton borrowableRadioYes, borrowableRadioNo;
    public ButtonGroup borrowableGroup;
    public JTable table;
    public DefaultTableModel tableModel;
    public int selectedRow = -1;
    public LibraryController controller;
    

    public LibraryApp() {
        controller = new LibraryController(this);
        setTitle("Sistem Manajemen Perpustakaan");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        createMenuBar();
        initializeInputPanel();
        initializeTable();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem resetItem = new JMenuItem("Reset App");
        resetItem.addActionListener(e -> controller.resetApp());
        menu.add(resetItem);

        JMenuItem exitItem = new JMenuItem("Exit App");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);

        setJMenuBar(menuBar);
    }

    private void initializeInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; inputPanel.add(new JLabel("Judul Buku:"), gbc);
        gbc.gridx = 1; titleField = new JTextField(20); inputPanel.add(titleField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; inputPanel.add(new JLabel("Pengarang:"), gbc);
        gbc.gridx = 1; authorField = new JTextField(20); inputPanel.add(authorField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; inputPanel.add(new JLabel("Tahun Terbit:"), gbc);
        gbc.gridx = 1; yearSpinner = new JSpinner(new SpinnerNumberModel(2000, 1900, 2100, 1));
        inputPanel.add(yearSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 3; inputPanel.add(new JLabel("Genre:"), gbc);
        gbc.gridx = 1; genreComboBox = new JComboBox<>(new String[]{"Fiksi", "Non-Fiksi", "Sains", "Sejarah", "Biografi"});
        inputPanel.add(genreComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 4; inputPanel.add(new JLabel("Deskripsi:"), gbc);
        gbc.gridx = 1; descriptionArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(descriptionArea), gbc);

        gbc.gridx = 0; gbc.gridy = 5; inputPanel.add(new JLabel("Jenis Buku:"), gbc);
        gbc.gridx = 1; typeList = new JList<>(new String[]{"Novel", "Majalah", "Komik", "Jurnal", "Ensiklopedia"});
        typeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inputPanel.add(new JScrollPane(typeList), gbc);

        gbc.gridx = 0; gbc.gridy = 6; inputPanel.add(new JLabel("Bisa Dipinjam:"), gbc);
        gbc.gridx = 1; 
        borrowableRadioYes = new JRadioButton("Ya");
        borrowableRadioNo = new JRadioButton("Tidak");
        borrowableGroup = new ButtonGroup();
        borrowableGroup.add(borrowableRadioYes);
        borrowableGroup.add(borrowableRadioNo);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        radioPanel.add(borrowableRadioYes);
        radioPanel.add(borrowableRadioNo);
        inputPanel.add(radioPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 7; inputPanel.add(new JLabel("Tersedia:"), gbc);
        gbc.gridx = 1; availabilityCheckBox = new JCheckBox("Ya");
        inputPanel.add(availabilityCheckBox, gbc);

        // Buttons for CRUD operations
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JButton addButton = new JButton("Tambah Buku");
        addButton.addActionListener(e -> controller.addDataToTable());
        JButton updateButton = new JButton("Perbarui Buku");
        updateButton.addActionListener(e -> controller.updateDataInTable(selectedRow));
        JButton deleteButton = new JButton("Hapus Buku");
        deleteButton.addActionListener(e -> controller.deleteDataFromTable(selectedRow));

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);

        add(inputPanel, BorderLayout.WEST);
    }

    private void initializeTable() {
        String[] columns = {"Judul", "Pengarang", "Tahun Terbit", "Genre", "Deskripsi", "Jenis", "Bisa Dipinjam", "Tersedia"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Listening for table row selection
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                selectedRow = table.getSelectedRow();
                loadDataToForm(selectedRow);
            }
        });
    }

    public void loadDataToForm(int row) {
        titleField.setText((String) tableModel.getValueAt(row, 0));
        authorField.setText((String) tableModel.getValueAt(row, 1));
        yearSpinner.setValue(Integer.parseInt(tableModel.getValueAt(row, 2).toString()));
        genreComboBox.setSelectedItem(tableModel.getValueAt(row, 3));
        descriptionArea.setText((String) tableModel.getValueAt(row, 4));
        typeList.setSelectedValue(tableModel.getValueAt(row, 5), true);
        borrowableRadioYes.setSelected("Ya".equals(tableModel.getValueAt(row, 6)));
        borrowableRadioNo.setSelected("Tidak".equals(tableModel.getValueAt(row, 6)));
        availabilityCheckBox.setSelected("Ya".equals(tableModel.getValueAt(row, 7)));
    }

    public void clearForm() {
        titleField.setText("");
        authorField.setText("");
        yearSpinner.setValue(2000);
        genreComboBox.setSelectedIndex(0);
        descriptionArea.setText("");
        typeList.clearSelection();
        borrowableGroup.clearSelection();
        availabilityCheckBox.setSelected(false);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryApp().setVisible(true));
    }
}
