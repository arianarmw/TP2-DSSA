import java.io.*;
import java.util.*;

class LinkedList {

    Node head;
    String fileName = "C:\\Users\\nutel\\OneDrive - Bina Nusantara\\Data Structures and Algorithms\\TP2-DSSA\\LinkedList\\buku.txt";

    // =========================
    // LOAD DATA DARI FILE
    // =========================
    public void loadFile() {

        try {

            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
                return;
            }

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] data = line.split(",");

                insertNode(data[0], data[1], data[2]);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error membaca file");
        }
    }

    // =========================
    // SIMPAN KE FILE
    // =========================
    public void saveFile() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            Node temp = head;

            while (temp != null) {

                writer.write(temp.kodeBuku + "," + temp.judul + "," + temp.penulis);
                writer.newLine();

                temp = temp.next;
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error menyimpan file");
        }
    }

    // =========================
    // INSERT NODE INTERNAL
    // =========================
    private void insertNode(String kode, String judul, String penulis) {

        Node newNode = new Node(kode, judul, penulis, penulis);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // =========================
    // TAMBAH BUKU
    // =========================
    public void tambahBuku(String kode, String judul, String penulis) {

        if (kode.length() > 5) {
            System.out.println("Kode buku maksimal 5 karakter.");
            return;
        }

        insertNode(kode, judul, penulis);
        saveFile();

        System.out.println("Data buku berhasil ditambahkan.");
    }

    // =========================
    // UPDATE BUKU
    // =========================
    public void updateBuku(String kode, String judulBaru, String penulisBaru) {

        Node temp = head;

        while (temp != null) {

            if (temp.kodeBuku.equals(kode)) {

                temp.judul = judulBaru;
                temp.penulis = penulisBaru;

                saveFile();

                System.out.println("Data buku berhasil diupdate.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Buku tidak ditemukan.");
    }

    // =========================
    // HAPUS BUKU BERDASARKAN KODE
    // =========================
    public void hapusBuku(String kode) {

        if (head == null) {
            System.out.println("Data kosong.");
            return;
        }

        if (head.kodeBuku.equals(kode)) {
            head = head.next;
            saveFile();
            System.out.println("Buku berhasil dihapus.");
            return;
        }

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.kodeBuku.equals(kode)) {

                temp.next = temp.next.next;

                saveFile();

                System.out.println("Buku berhasil dihapus.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Buku tidak ditemukan.");
    }

    // =========================
    // CARI BUKU
    // =========================
    public void cariBuku(String kode) {

        Node temp = head;

        while (temp != null) {

            if (temp.kodeBuku.equals(kode)) {

                System.out.println("\nBuku ditemukan:");
                System.out.println("Kode: " + temp.kodeBuku);
                System.out.println("Judul: " + temp.judul);
                System.out.println("Penulis: " + temp.penulis);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Buku tidak ditemukan.");
    }

    // =========================
    // TAMPILKAN SEMUA BUKU
    // =========================
    public void tampilBuku() {

        Node temp = head;
        int total = 0;

        if (temp == null) {
            System.out.println("Belum ada data buku.");
            return;
        }

        System.out.println("\n=== DAFTAR BUKU ===");

        while (temp != null) {

            System.out.println(
                    "Kode: " + temp.kodeBuku +
                            " | Judul: " + temp.judul +
                            " | Penulis: " + temp.penulis);

            temp = temp.next;
            total++;
        }

        System.out.println("Total Buku: " + total);
    }
}
