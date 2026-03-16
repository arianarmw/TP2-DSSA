public class Stack {

    Node top;

    // Menambahkan transaksi ke stack
    public void push(Node data) {

        Node newNode = new Node(data.kode, data.nama, data.total);

        newNode.next = top;
        top = newNode;

    }

    // Menampilkan riwayat transaksi
    public void displayStack() {

        if (top == null) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        Node temp = top;

        System.out.println("=== RIWAYAT TRANSAKSI ===");

        while (temp != null) {
            System.out.println(temp.kode + " - " + temp.nama + " - Rp" + temp.total);
            temp = temp.next;
        }
    }

}