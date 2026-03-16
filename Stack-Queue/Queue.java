public class Queue {

    Node front;
    Node rear;
    int size = 0;
    int max = 5;

    // Menambahkan pelanggan ke antrian
    public void enqueue(String kode, String nama, int total) {

        if (size == max) {
            System.out.println("Antrian penuh! Maksimal 5 pelanggan.");
            return;
        }

        Node newNode = new Node(kode, nama, total);

        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;

        System.out.println("Data pelanggan berhasil ditambahkan ke antrian.");
    }

    // Menghapus pelanggan dari antrian
    public Node dequeue() {

        if (front == null) {
            System.out.println("Antrian kosong.");
            return null;
        }

        Node temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return temp;
    }

    // Menampilkan antrian
    public void displayQueue() {

        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        Node temp = front;

        System.out.println("\n=== DAFTAR ANTRIAN ===");

        while (temp != null) {

            System.out.println(temp.kode + " - "
                    + temp.nama + " - Rp"
                    + String.format("%,d", temp.total).replace(",", "."));

            temp = temp.next;
        }
    }
}