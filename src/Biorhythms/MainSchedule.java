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
        pekerja.MakeJmlShift(5);
        pekerja.makeAppendShift(4, 4, 2018);
        pekerja.makeCalShift();
        pekerja.makeAppendforBirth(4, 4, 1995);
        pekerja.Hitung(pekerja.getShift()); 
        pekerja.getFisik();
        pekerja.getEmosional();
        pekerja.getIntelektual();
        pekerja.getTotal();

        Pekerja pekerja2 = new Pekerja();
        pekerja2.setJmlShift(pekerja.getJmlShift());
        pekerja2.setTglshift(pekerja.getTglshift());
        pekerja2.makeAppendforBirth(4, 6, 1995);
        pekerja2.Hitung(pekerja.getShift());
        pekerja2.getFisik();
        pekerja2.getEmosional();
        pekerja2.getIntelektual();
        pekerja2.getTotal();
        CompareBiorhythms compareBio = new CompareBiorhythms();
        System.out.println(pekerja.total[0]);
        compareBio.perbandingan(pekerja.total, pekerja2.total, pekerja.getJmlShift(), pekerja);
        compareBio.table(pekerja, pekerja2);
        ////        do {
        //            //misalnya
        //            tanggal.MakeShift(29, 2, 2018, 6);
        ////        } while (tanggal.isValidate == false);
        //        do {
        //            tanggal.validate(28,2,1995);
        //        } while (tanggal.isValidate == false);
        //        Biorhythms s1 = new Biorhythms(tanggal.getJmlShift());
        //        tanggal.Hitung(tanggal.getShift(), s1);
        //        Pekerja p1 = new Pekerja(tanggal.getJmlShift());
        //
        //        System.out.println("PEKERJA 2");
        //        ValiDate tanggal2 = new ValiDate();
        //        tanggal2.setJmlShift(tanggal.getJmlShift());
        //        tanggal2.setTglshift(tanggal.getTglshift());
        //        do {
        //            tanggal2.validate(1,1,1996);
        //        } while (tanggal2.isValidate == false);
        //        Biorhythms s2 = new Biorhythms(tanggal2.getJmlShift());
        //        tanggal2.Hitung(tanggal2.getShift(), s2);
        //        Pekerja p2 = new Pekerja(tanggal.getJmlShift());
        //        p2.perbandingan(s1.total, s2.total, tanggal.getJmlShift(), tanggal,null );
    }
}
