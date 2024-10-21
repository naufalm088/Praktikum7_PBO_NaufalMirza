/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum7;

/**
 *
 * @author Naufal Mirza Aldilla
 */

import java.util.Scanner;

public class Praktikum7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] kodeBarang = {"001", "002", "003", "004", "005"};
        String[] namaBarang = {"Pulpen", "Buku", "Pensil", "Spidol", "Penghapus"};
        int[] hargaBarang = {6000, 3500, 2500, 7000, 1000};
        int[] jumlahBeli = new int[5];
        int[] jumlahBayar = new int[5];
        
        int totalBayar = 0;
        
        System.out.print("Masukkan jumlah barang yang ingin dibeli : ");
        int jumlahItem = input.nextInt();
        
        for (int i = 0; i < jumlahItem; i++) {
            System.out.println("Data ke " + (i + 1));
            System.out.print("Masukkan Kode Barang: ");
            String kode = input.next();
            
            boolean ditemukan = false;
            for (int j = 0; j < kodeBarang.length; j++) {
                if (bandingkanString(kode, kodeBarang[j])) {
                    System.out.print("Masukkan jumlah yang ingin dibeli: ");
                    jumlahBeli[i] = input.nextInt();
                    
                    jumlahBayar[i] = jumlahBeli[i] * hargaBarang[j];
                    totalBayar += jumlahBayar[i];
                    
                    System.out.println("Nama Barang: " + namaBarang[j]);
                    System.out.println("Harga: " + hargaBarang[j]);
                    ditemukan = true;
                    break;
                }
            }
            
            if (!ditemukan) {
                System.out.println("Kode barang tidak ada!");
            }
        }
        
        System.out.println("\nSELAMAT BERBELANJA DI TOSERBA NOPAL");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("No  Kode Barang   Nama Barang   Harga   Jumlah Beli   Jumlah Bayar");
        System.out.println("+-------------------------------------------------------------------+");
        
        for (int i = 0; i < jumlahItem; i++) {
            for (int j = 0; j < kodeBarang.length; j++) {
                if (bandingkanString(kodeBarang[j], kodeBarang[i])) {
                    System.out.printf("%-3d %-12s %-12s %-7d %-12d %-12d\n", 
                        (i + 1), kodeBarang[i], namaBarang[j], hargaBarang[j], jumlahBeli[i], jumlahBayar[i]);
                }
            }
        }
        
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("Total Bayar Anda : " + "Rp. " +  totalBayar);
    }
    
    public static boolean bandingkanString(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}   