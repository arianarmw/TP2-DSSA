import java.io.FileWriter;
import java.io.IOException;

public class Stack {

    Node top;

    // Menyimpan transaksi ke stack
    public void push(Node data) {

        Node newNode = new Node(data.kode, data.nama, data.total);

        newNode.next = top;
        top = newNode;

        simpanKeFile(newNode);
    }

    // Menampilkan riwayat transaksi
    public void displayStack() {

        if (top == null) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        Node temp = top;

        System.out.println("\n=== RIWAYAT TRANSAKSI ===");

        while (temp != null) {

            System.out.println(temp.kode + " - "
                    + temp.nama + " - Rp"
                    + String.format("%,d", temp.total).replace(",", "."));

            temp = temp.next;
        }
    }

    // Menyimpan transaksi ke file txt
    private void simpanKeFile(Node data) {

        try {

            FileWriter writer = new FileWriter("C:\\Users\\nutel\\OneDrive - Bina Nusantara\\Data Structures and Algorithms\\TP2-DSSA\\Stack-Queue\\riwayat_transaksi.txt", true);

            writer.write(data.kode + " | "
                    + data.nama + " | Rp"
                    + String.format("%,d", data.total).replace(",", ".")
                    + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Gagal menyimpan file.");
        }
    }
}