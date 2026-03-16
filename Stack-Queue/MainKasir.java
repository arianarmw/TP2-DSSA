import java.util.Scanner;

public class MainKasir {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Queue antrian = new Queue();
        Stack riwayat = new Stack();

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

                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = input.nextLine();

                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan Total Belanja: ");
                    int total = input.nextInt();
                    input.nextLine();

                    antrian.enqueue(kode, nama, total);

                    break;

                case 2:

                    Node pelanggan = antrian.dequeue();

                    if (pelanggan != null) {

                        System.out.println("Melayani pelanggan "
                                + pelanggan.kode
                                + " (" + pelanggan.nama + ")");

                        riwayat.push(pelanggan);

                        System.out.println("Transaksi disimpan ke riwayat.");

                    }

                    break;

                case 3:

                    antrian.displayQueue();
                    break;

                case 4:

                    riwayat.displayStack();
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