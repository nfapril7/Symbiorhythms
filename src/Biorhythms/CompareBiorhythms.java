/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biorhythms;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author april nf
 */
public class CompareBiorhythms {
    
    /**
     *
     * @param BiorithmsPekerja1 : Total nilai Biorythms dari pekerja 1
     * @param BiorithmsPekerja2 : Total nilai Biorythms dari pekerja 2
     * @param jumlahshift : Jumlah hari shift yang diinputkan antara 5 sampai 10
     * hari
     * @param v : Memanggil class untuk mengambil nilai tanggal shift dari objek
     * v
     * @return : Mengembalikan nilai diantara pekerja 1 atau 2 yang akan
     * terpilih pada masing-masing jadwal shift
     */
    public String[] perbandingan(double BiorithmsPekerja1[], double BiorithmsPekerja2[], int jumlahshift, Pekerja pekerja) {
        String pilih[] = new String[jumlahshift];
//        jTable1 = new JTable(model);         
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < jumlahshift; i++) {
            if (BiorithmsPekerja1[i] > BiorithmsPekerja2[i]) {
                pilih[i] = "Pekerja 1";
            } else {
                pilih[i] = "Pekerja 2";
            }
            list.add(new Object[]{pekerja.Shift[i], pilih[i]});
            System.out.println(pekerja.Shift[i]+" - "+pilih[i]);
        }

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Tanggal", "Nama"});
        for (Object obj : list) {
            model.addRow((Object[]) obj);
        }
//        , Pekerja p, javax.swing.JTable jTable1
//        jTable1.setModel(model);
        return pilih;
    }

    /**
     * Membuat table untuk menampilkan nilai Biothythms
     *
     * @param b1 memerlukan inputan objek b1 dari class Biorhythms untuk pekerja
     * 1
     * @param b2 memerlukan inputan objek b2 dari class Biorhythms untuk pekerja
     * 2
     * @param jTable1 memerlukan inputan parameter berupa objek dari Jtable
     * untuk menampilkan nilai Biorhythms pekerja 1
     * @param jTable2 memerlukan inputan parameter berupa objek dari Jtable
     * untuk menampilkan nilai Biorhythms pekerja 2
     * @param jumlahshift memerlukan inputan parameter jumlah hari shift
     * @param v memerlukan inputan parameter berupa objek dari class ValiDate
     * untuk memanggil nilai variabel shift[]
     */
    public void table(Pekerja bio1 , Pekerja bio2) {
    //, javax.swing.JTable jTable1, javax.swing.JTable jTable2,
        List<Object> list = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        for (int i = 0; i < bio1.getJmlShift(); i++) {
//            list.add(new Object[]{bio1.Shift[i], bio1.fisik[i], bio1.emosional[i], bio1.intelektual[i], bio1.total[i]});
//            list2.add(new Object[]{bio2.Shift[i], bio2.fisik[i], bio2.emosional[i], bio2.intelektual[i], bio2.total[i]});
            System.out.println(bio1.emosional[i]+" - "+bio2.emosional[i]);
        }
        DefaultTableModel model = new DefaultTableModel();
        DefaultTableModel model2 = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Tanggal", "Fisik", "Emosional", "Intelektual", "Total"});
        model2.setColumnIdentifiers(new Object[]{"Tanggal", "Fisik", "Emosional", "Intelektual", "Total"});
        for (Object obj : list) {
            model.addRow((Object[]) obj);
        }
//        jTable1.setModel(model);

        for (Object obj : list2) {
            model2.addRow((Object[]) obj);
        }
//        jTable2.setModel(model2);
    }
}
