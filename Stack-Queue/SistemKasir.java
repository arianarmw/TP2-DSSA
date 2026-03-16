import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SistemKasir {

    static Queue<Pelanggan> antrian = new LinkedList<>();
    static Stack<Pelanggan> riwayat = new Stack<>();
    static Scanner input = new Scanner(System.in);

    public static void tambahAntrian() {

        System.out.print("Masukkan Nomor Antrian: ");
        String nomor = input.nextLine();

        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Total Belanja: ");
        int total = input.nextInt();
        input.nextLine();

        Pelanggan pelanggan = new Pelanggan(nomor, nama, total);
        antrian.add(pelanggan);

        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    public static void layaniPelanggan() {

        if (antrian.isEmpty()) {
            System.out.println("Tidak ada pelanggan dalam antrian.");
        } else {

            Pelanggan pelanggan = antrian.poll();

            System.out.println("Melayani pelanggan "
                    + pelanggan.nomorAntrian
                    + " (" + pelanggan.namaPelanggan + ")");

            riwayat.push(pelanggan);

            System.out.println("Transaksi disimpan ke riwayat.");
        }
    }

    public static void tampilkanAntrian() {

        if (antrian.isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {

            System.out.println("=== DAFTAR ANTRIAN ===");

            for (Pelanggan p : antrian) {
                System.out.println(
                        p.nomorAntrian + " - "
                        + p.namaPelanggan + " - Rp"
                        + p.totalBelanja
                );
            }
        }
    }

    public static void lihatRiwayat() {

        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {

            System.out.println("=== RIWAYAT TRANSAKSI ===");

            for (int i = riwayat.size() - 1; i >= 0; i--) {

                Pelanggan p = riwayat.get(i);

                System.out.println(
                        p.nomorAntrian + " - "
                        + p.namaPelanggan + " - Rp"
                        + p.totalBelanja
                );
            }
        }
    }

    public static void main(String[] args) {

        int pilihan;

        do {

            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    tambahAntrian();
                    break;

                case 2:
                    layaniPelanggan();
                    break;

                case 3:
                    tampilkanAntrian();
                    break;

                case 4:
                    lihatRiwayat();
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);
    }
}