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
public class MainSchedule {

    public static void main(String[] args) {
        // - handling jika inputan jmlshift, tgl, bln, thn bukan integer
        System.out.println("PEKERJA 1");
        Pekerja pekerja = new Pekerja();
        callFunction(pekerja, 5, 4, 4, 2018, 1, 1, 1995);

        Pekerja pekerja2 = new Pekerja();
        callFuction(pekerja2, pekerja, 4, 4, 1995);

        CompareBiorhythms compareBio = new CompareBiorhythms();
//        compareBio.perbandingan(pekerja.getBiorhythms().total, pekerja2.getBiorhythms().total, pekerja.getJmlShift(), pekerja);
//        compareBio.table(pekerja, pekerja2);
    }

    static void callFunction(Pekerja pekerja, int jmlShift, int tglShift, int blnShift, int thnShift, int tglLahir,
            int blnLahir, int thnLahir) {
        pekerja.MakeJmlShift(jmlShift);
        pekerja.makeAppendShift(tglShift, blnShift, thnShift);
        pekerja.makeCalShift();
        pekerja.makeAppendforBirth(tglLahir, blnLahir, thnLahir);
        pekerja.Hitung(pekerja.getShift());
    }

    static void callFuction(Pekerja pekerja, Pekerja pekerja1, int tglLahir, int blnLahir, int thnLahir) {
        pekerja.setJmlShift(pekerja1.getJmlShift());
        pekerja.setTglshift(pekerja1.getTglshift());
        pekerja.makeAppendforBirth(tglLahir, blnLahir, thnLahir);
        pekerja.Hitung(pekerja1.getShift());
    }
}
