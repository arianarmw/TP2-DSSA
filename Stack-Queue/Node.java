public class Node {

    String kode;
    String nama;
    int total;
    Node next;

    public Node(String kode, String nama, int total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }

}