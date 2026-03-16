class Node {

    String kodeBuku;
    String judul;
    String penulis;
    Node next;
	public String nomor;
	public String nama;
	public String total;

    public Node(String kodeBuku, String judul, String penulis2, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
