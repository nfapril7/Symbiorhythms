/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biorhythms;


/**
 *
 * @author april nf, ryanpradnya
 */
public class  Biorhythms {

    protected double fisik[]; 
    protected double emosional[]; 
    protected double intelektual[]; 
    protected double total[];

    /**
     * @param args Konstruktor untuk membuat objek array variabel fisik,
     * emosional, intelektual dan total serta meinisialisasi nilai variable
     * jumlah hari shift
     */
    //k1 tgl lahir, shift
      //k2 selisih hari      
    public Biorhythms() {
    }

    /**
     * Menjalankan fungsi Biorhythms untuk nilai emosional dengan rumus sin((2 * phi * hari) / 28)
     * @param hari jumlah selisih hari antara tanggal lahir pekerja dengan
     * tanggal shift
     * @return mengembalikan nilai biorhythms emosional
     */
    public double[] getEmosional(int hari[], int jmlshift) {         
        emosional = new double[jmlshift];
        for (int i = 0; i < emosional.length; i++) {
            emosional[i] = Math.sin((2 * Math.PI * hari[i]) / 28);
        }
        return emosional;
    }

    /**
     * Menjalankan fungsi Biorhythms untuk nilai fisik dengan rumus sin((2 * phi * hari) / 23)
     * @param hari jumlah selisih hari antara tanggal lahir pekerja dengan
     * tanggal shift
     * @return mengembalikan nilai biorhythms fisik
     */
    public double[] getFisik(int hari[], int jmlshift) {               
        fisik = new double[jmlshift];
        for (int i = 0; i < fisik.length; i++) {
            fisik[i] = Math.sin((2 * Math.PI * hari[i]) / 23);
        }
        return fisik;
    }

    /**
     * Menjalankan fungsi Biorhythms untuk nilai intelektual dengan rumus sin((2 * phi * hari) / 33)
     * @param hari jumlah selisih hari antara tanggal lahir pekerja dengan
     * tanggal shift
     * @return mengembalikan nilai biorhythms intelektual
     */
    public double[] getIntelektual(int hari[], int jmlshit) {        
        intelektual = new double[jmlshit];
        for (int i = 0; i < intelektual.length; i++) {
            intelektual[i] = Math.sin((2 * Math.PI * hari[i]) / 33);
        }
        return intelektual;
    }

    /**
     * Menambahkan nilai Biorhythms dari nilai emosional, fisik dan intelektual
     * @return mengembalikan nilai total dari nilai fisik, emosional, dan
     * intelektual
     */
    public double[] getTotal(int jmlshift) {
        total = new double[jmlshift];
        for (int i = 0; i < total.length; i++) {
            total[i] = fisik[i] + intelektual[i] + emosional[i];
        }
        return total;
    }
}
