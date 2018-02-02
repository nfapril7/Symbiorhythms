/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biorhythms;

import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author april nf, ryanpradnya
 */
public class Validation {
    
    boolean isValidate = true;
    Scanner in;
    SimpleDateFormat df;
    private int jumlahHariBulan;
    ValidasiGUI validasiGUI;

    /**
     * Konstruktor class ValiDate
     */
    public Validation() {
        in = new Scanner(System.in);
        df = new SimpleDateFormat("dd/mm/yyyy");
        validasiGUI = new ValidasiGUI();
    }

    /**
     *
     * @param jumlahHari : Men-set variabel jumlah hari berdasarkan bulan yang
     * diinputkaan yang nantinya akan digunakan untuk validasi agar inputan
     * tanggal user tidak melebihi/kurang dari jumlah hari dalam bulan
     */
    public void setJumlahHariBulan(int jumlahHariBulan) {
        this.jumlahHariBulan = jumlahHariBulan;
    }

    /**
     *
     * @return Mnegembalikan nilai jumlah hari shift
     */
    public int getJumlahHariBulan() {
        return jumlahHariBulan;
    }

    /**
     * Method makeBirthDate untuk merequest inputan user pada varibel: tgl ,
     * bln, tahun lahir pekerja
     */
    /**
     * Method validate untuk memvalidasi inputan tgl, bln, tahun
     */
    public boolean validasiTanggal(int tgl, int bln, int thn) {
        switch (bln) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                setJumlahHariBulan(31);
                check(tgl, bln, thn);
                break;
            case 2:
                int jumlah = thn % 4 == 0 ? 29 : 28;
                setJumlahHariBulan(jumlah);
                check(tgl, bln, thn);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                setJumlahHariBulan(30);
                check(tgl, bln, thn);
                break;
            default:
                isValidate = false;
        }
        return isValidate;
    }

    /**
     * Method check untuk menghandling jika inputan tgl dalam bulan
     * melebihi/kurang dari jumlah hari dalam suatu bulan
     */
    boolean check(int tgl, int bln, int thn) {
        try {
            assert (tgl <= getJumlahHariBulan() || tgl > 0);
            if (tgl > getJumlahHariBulan() || tgl < 0) {
                isValidate = false;
//                useJOption("Input data tanggal salah");
                throw new CustomException("Input data tanggal salah");
            }
            isValidate = true;
        } catch (CustomException ex) {
            System.out.println(ex.getMessage());
        }
        return isValidate;
    }

    /**
     * Method cehckLebih untuk menhandling jika date lahir melebihi date shift
     * misalnya, tgl shift : 1-1-2018, tgl lahir : 1-2-2018 maka jika inputan
     * seperti tersebut, akan memanggil class CustomException
     */
    boolean checkLebih(Date lahir, Date shift) {
        try {
            if (lahir.after(shift) || lahir.equals(shift)) {
                isValidate = false;
//                useJOption("Tanggal lahir tidak diperbolehkan melebihi tanggal shift");
                throw new CustomException("Tanggal lahir tidak diperbolehkan melebihi tanggal shift");
            }
            isValidate = true;
            
        } catch (CustomException ex) {
            System.out.println(ex.getMessage());
        }
        return isValidate;
    }
    
    boolean validasiShift(int jmlShift) {
        try {
            if (jmlShift < 5 || jmlShift > 10) {
                isValidate = false;
//                useJOption("Jumlah shift antara 5 sampai 10 hari");
                throw new CustomException("Jumlah shift antara 5 sampai 10 hari");
            } else {                
                isValidate = true;
            }
        } catch (CustomException ex) {
            System.out.println(ex.getMessage());
        }
        return isValidate;        
    }
    
}
