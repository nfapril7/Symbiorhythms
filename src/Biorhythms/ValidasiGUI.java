/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biorhythms;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author april nf
 */
public class ValidasiGUI {
        /**
     * Menghandle jika inputan user selain integer
     *
     * @param evt variabel untuk menset objek dari keyevent method
     * validasiKarakter digunakan untuk validasi agar tidak bisa menginputkan
     * selain integer
     */
    public void validasiKarakter(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        try {
            if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
                evt.consume();
            }
        } catch (NumberFormatException ex) {
            useJOption("Inputan tidak diperbolehkan selain angka");
        }
    }

    /**
     * Menghandle jika inputan jumlah diigt melebihi batas maksimal yang
     * diperbolehkan
     *
     * @param evt memerlukan aksi evt
     * @param jTField memerlukan inputan parameter objek jtextfield
     * @param batas_atas memerlukan inputan nilai batas digit maksimal dari
     * suatu variabel bulan
     */

    public void validasiJumlah(java.awt.event.KeyEvent evt, javax.swing.JTextField jTField, int batas_atas) {
        String c = jTField.getText();
        if (c.length() > batas_atas) {
            evt.consume();
        }

    }

    /**
     * Menghandle jika inputan jumlah shit melebihi atau kurang dari persyaratan
     * yaitu antara 5 sampai 10 hari
     *
     * @param evt memerlukan aksi evt
     * @param jTField memerukan inputan parameter objek jtextfield
     * @param batas_atas memerlukan inputan nilai batas maksimal dari jumlah
     * shift yaitu maksimal 10 hari
     * @param batas_bawah memerlukan inputan nilai batas minimal dari jumlah
     * shift yaitu minimal 5 hari
     */
    public void validasiBatas(java.awt.event.KeyEvent evt, javax.swing.JTextField jTField, int batas_atas, int batas_bawah) {
        String jml = (jTField.getText());
        try {
            if (Integer.parseInt(jml) < batas_bawah) {
                useJOption("Kurang kondisi");
                jTField.setText("");
            }
            if (Integer.parseInt(jml) > batas_atas) {
                useJOption("Melebihi kondisi");
                jTField.setText("");
            }
        } catch (NumberFormatException ex) {
            useJOption("Inputan tidak boleh selain angka");
        }
    }

    void useJOption(String pesan) {
        JOptionPane.showMessageDialog(null, pesan,
                "Warning", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
