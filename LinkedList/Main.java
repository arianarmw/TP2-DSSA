import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();

        list.loadFile();

        int menu;

        do {

            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Update Buku");
            System.out.println("3. Hapus Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Tampilkan Semua Buku");
            System.out.println("6. Keluar");

            System.out.print("Pilih menu: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {

                case 1:

                    System.out.print("Kode Buku: ");
                    String kode = input.nextLine();

                    System.out.print("Judul: ");
                    String judul = input.nextLine();

                    System.out.print("Penulis: ");
                    String penulis = input.nextLine();

                    list.tambahBuku(kode, judul, penulis);
                    break;

                case 2:

                    System.out.print("Kode buku yang diupdate: ");
                    String kodeUpdate = input.nextLine();

                    System.out.print("Judul baru: ");
                    String judulBaru = input.nextLine();

                    System.out.print("Penulis baru: ");
                    String penulisBaru = input.nextLine();

                    list.updateBuku(kodeUpdate, judulBaru, penulisBaru);
                    break;

                case 3:

                    System.out.print("Kode buku yang dihapus: ");
                    String kodeHapus = input.nextLine();

                    list.hapusBuku(kodeHapus);
                    break;

                case 4:

                    System.out.print("Kode buku yang dicari: ");
                    String kodeCari = input.nextLine();

                    list.cariBuku(kodeCari);
                    break;

                case 5:
                    list.tampilBuku();
                    break;

                case 6:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (menu != 6);
    }
}
