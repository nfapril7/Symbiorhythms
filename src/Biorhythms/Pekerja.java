/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biorhythms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author april nf, ryanpradnya
 *
 * Kelas Pekerja merupakan turunan dari kelas Biorythms Setiap pekerja mempunyai
 * nilai Bioryhtms yang berbeda-beda
 */
public class Pekerja {

    private Biorhythms biorhythms;
    private int jmlShift;
    protected Date Tgllahir;
    protected Date Tglshift;
    protected Date Shift[];
    Validation validation;
    SimpleDateFormat dateFormat;
    protected double fisik[];
    protected double emosional[];
    protected double intelektual[];
    protected double total[];

    public Pekerja() {
        biorhythms = new Biorhythms();
        validation = new Validation();
        dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    }

    /**
     *
     * @param Shift : Men-set variabel shift dengan tipe data Date dari inputan
     * tanggal, bulan, tahun yang diinputkan
     */
    public void setShift(Date[] Shift) {

        this.Shift = Shift;
    }

    /**
     *
     * @return Mengembalikan nilai variabel Shift
     */
    public Date[] getShift() {
        return Shift;
    }

    /**
     *
     * @param jmlShift : inputan berapa banyak jumlah shift dalam hari (inputan
     * harus 5 sampai 10 hari)
     */
    public void setJmlShift(int jmlShift) {
        this.jmlShift = jmlShift;
    }

    /**
     *
     * @return Mengembalikan nilai variabel jmlShift (jumlah hari shift)
     */
    public int getJmlShift() {
        return jmlShift;
    }

    /**
     *
     * @param Tgllahir : Men-set variabel Tgllahir dari inputan user tgl, bln,
     * thn lahir yang telah diubah ke dalam format dd/mm/yyyy
     */
    public void setTgllahir(Date Tgllahir) {
        this.Tgllahir = Tgllahir;
    }

    /**
     *
     * @return Mengembalikan nilai variabel Tgllahir dengan tipe data Date dari
     * inputan user pada varibael tgl, blln, thn lahir
     */
    public Date getTgllahir() {
        return Tgllahir;
    }

    /**
     *
     * @param Tglshift : Men-set variabel Tglshift dari inputan user tgl, bln,
     * thn shift yang telah diubah ke dalam format dd/mm/yyyy
     */
    public void setTglshift(Date Tglshift) {
        this.Tglshift = Tglshift;
    }

    /**
     *
     * @return Mengembalikan nilai variabel Tglshift dengan tipe data Date dari
     * inputan user tgl, bln, thn untuk jadwal shift dimulai
     */
    public Date getTglshift() {
        return Tglshift;
    }

    public double[] getEmosional() {
        emosional = biorhythms.emosional;
        return biorhythms.emosional; //To change body of generated methods, choose Tools | Templates.
    }
//

    public double[] getFisik() {
        fisik = biorhythms.fisik;
        return biorhythms.fisik; //To change body of generated methods, choose Tools | Templates.
    }
//

    public double[] getIntelektual() {
        intelektual = biorhythms.intelektual;
        return biorhythms.intelektual; //To change body of generated methods, choose Tools | Templates.
    }
//

    public double[] getTotal() {
        total = biorhythms.total;
        return biorhythms.total; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method HandlingBatasan berfungsi untuk menhandling jika inputan user pada
     * jumlah shift melebihi/kurang dari persyaratan (jumlah hari shift harus 5
     * sampai 10 hari);
     *
     * @param tglAwal : membutuhkan inputan parameter tgl shift
     * @param blnAwal : membutuhkan inputan parameter bulan shift
     * @param thnAwal : membutuhkan inputan parameter tahun shift
     */
    int MakeJmlShift(int jmlShift) {
        if (validation.validasiShift(jmlShift)) {
            setJmlShift(jmlShift);
        }
        return jmlShift;
    }

    /**
     * Method makeAppendShift untuk membentuk Date Shift Pertama menggabungkan
     * inputan parameter tgl, bln, thn menggunakan fungsi Append Mengubah
     * inputan user tgl, bln, thn yang bertipe data integer ke dalam tipe data
     * Date
     *
     * @param tgl : inputan parameter tgl lahir
     * @param bln : inputan parameter bln lahir
     * @param thn : inputan parameter thn lahir
     * @return : Mengembalikan nilai variabel Tglshift
     */
    Date makeAppendShift(int tgl, int bln, int thn) {
        if (validation.validasiTanggal(tgl, bln, thn)) {
            StringBuilder builder = new StringBuilder();
            builder.append(tgl);
            builder.append("/");
            builder.append(bln);
            builder.append("/");
            builder.append(thn);
            String tempShift = builder.toString();
            try {
                setTglshift(dateFormat.parse(tempShift));
                System.out.println("Tgl shift "+getTglshift());
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return Tglshift;
    }

    /**
     * Method makeCal untuk membuat tanggal shift sejumlah jumlah hari shift
     *
     */
    void makeCalShift() {
        Calendar cal = Calendar.getInstance();
        Date[] temp = new Date[getJmlShift()];
        for (int i = 0; i < jmlShift; i++) {
            cal.setTime(getTglshift());
            cal.add(Calendar.DAY_OF_MONTH, i);
            temp[i] = (cal.getTime());
            setShift(temp);
        }
    }

    /**
     * Method makeAppendforBirth untuk menggabungkan tgl, bln, thn lahir pekerja
     * kemudian diubah ke dalam format dd/mm/yyyy
     *
     * @param tgl
     * @param bln
     * @param thn
     * @return
     */
    Date makeAppendforBirth(int tgl, int bln, int thn) {
        if (validation.validasiTanggal(tgl, bln, thn)) {
            StringBuilder builder = new StringBuilder();
            builder.append(tgl);
            builder.append("/");
            builder.append(bln);
            builder.append("/");
            builder.append(thn);
            String lahir = builder.toString();
            try {
                if (validation.checkLebih(dateFormat.parse(lahir), getTglshift())) {
                    setTgllahir(dateFormat.parse(lahir));
                }
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return Tgllahir;
    }

    /**
     * Method Hitung untuk memanggil kelas Biorhythm jika tanggal shift dan
     * lahir sudah tervalidasi maka dapat dilakukan perhitungan dengan rumus
     * Biorhythms
     *
     * @param shift
     * @param sym
     */
    public void Hitung(Date shift[]) {
        if (validation.isValidate) {
            int hari[] = new int[getJmlShift()];
            fisik = new double[getJmlShift()];
            emosional = new double[getJmlShift()];
            intelektual = new double[getJmlShift()];
            total = new double[getJmlShift()];
            for (int i = 0; i < hari.length; i++) {
                hari[i] = (int) TimeUnit.MILLISECONDS.toDays((shift[i].getTime() - getTgllahir().getTime()));
                biorhythms.getFisik(hari, getJmlShift());
                biorhythms.getEmosional(hari, getJmlShift());
                biorhythms.getIntelektual(hari, getJmlShift());
                biorhythms.getTotal(getJmlShift());
            }
        }
    }

}
