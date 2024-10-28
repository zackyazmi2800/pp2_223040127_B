/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3;

import javax.swing.*;

/**
 *
 * @author zack
 */

public class LibraryController {
    private final LibraryApp view;

    public LibraryController(LibraryApp view) {
        this.view = view;
    }

    public void addDataToTable() {
        String judul = view.titleField.getText();
        String pengarang = view.authorField.getText();
        String tahun = view.yearSpinner.getValue().toString();
        String genre = (String) view.genreComboBox.getSelectedItem();
        String deskripsi = view.descriptionArea.getText();
        String jenis = view.typeList.getSelectedValue();
        String bisaDipinjam = view.borrowableRadioYes.isSelected() ? "Ya" : "Tidak";
        String tersedia = view.availabilityCheckBox.isSelected() ? "Ya" : "Tidak";

        view.getTableModel().addRow(new Object[]{judul, pengarang, tahun, genre, deskripsi, jenis, bisaDipinjam, tersedia});
        view.clearForm();
    }

    public void updateDataInTable(int selectedRow) {
        if (selectedRow != -1) {
            view.getTableModel().setValueAt(view.titleField.getText(), selectedRow, 0);
            view.getTableModel().setValueAt(view.authorField.getText(), selectedRow, 1);
            view.getTableModel().setValueAt(view.yearSpinner.getValue().toString(), selectedRow, 2);
            view.getTableModel().setValueAt(view.genreComboBox.getSelectedItem(), selectedRow, 3);
            view.getTableModel().setValueAt(view.descriptionArea.getText(), selectedRow, 4);
            view.getTableModel().setValueAt(view.typeList.getSelectedValue(), selectedRow, 5);
            view.getTableModel().setValueAt(view.borrowableRadioYes.isSelected() ? "Ya" : "Tidak", selectedRow, 6);
            view.getTableModel().setValueAt(view.availabilityCheckBox.isSelected() ? "Ya" : "Tidak", selectedRow, 7);
            view.clearForm();
        }
    }

    public void deleteDataFromTable(int selectedRow) {
        if (selectedRow != -1) {
            view.getTableModel().removeRow(selectedRow);
            view.clearForm();
        }
    }

    public void resetApp() {
        view.clearForm();
        view.getTableModel().setRowCount(0);
    }
}

