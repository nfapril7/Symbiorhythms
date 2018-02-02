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
public class CustomException extends Exception {

    /**
     * Memanggil konstruktor kelas Exception
     * @param pesan memerlukan inputan parameter berupa pesan yang akan disampaikan ketika terjadi error  
     */
    public CustomException(String pesan) {
        super(pesan);
    }
        
}
