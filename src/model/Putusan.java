package model;
/**
 * Class entity utama buat representasiin satu data putusan pengadilan
 * pidana narkotika. Extends dari EntitasHukum (buat field umum kayak nomor
 * perkara, pengadilan, tanggal) dan implements Rekapitulasi (buat fitur ringkasan).
 * Semua field private, akses lewat getter/setter — biar sesuai prinsip enkapsulasi.
 */
public class Putusan extends EntitasHukum implements Rekapitulasi {
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;      // satuannya bulan
    private double vonisDenda;
    private String namaHakim;

    // buat ngitung udah berapa banyak objek Putusan yang kebuat (contoh static field)
    private static int jumlahDibuat = 0;

    // constructor kosong, kalo mau bikin objek dulu baru isi datanya belakangan pake setter
    public Putusan() {
        super("", "", "");
        jumlahDibuat++;
    }

    /**
     * Constructor lengkap, langsung isi semua data pas objek dibuat.
     */
    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan,
                   String namaTerdakwa, int umurTerdakwa, String jenisNarkotika,
                   double beratBarangBukti, String pasalDilanggar, String peranTerdakwa,
                   int vonisHukuman, double vonisDenda, String namaHakim) {
        super(nomorPerkara, pengadilan, tanggalPutusan);
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;
        jumlahDibuat++;
    }



    // setter buat field yang ada di parent class (EntitasHukum), tinggal diteruskan aja
    public void setNomorPerkara(String nomorPerkara) { super.setNomorPerkara(nomorPerkara); }
    public void setPengadilan(String pengadilan) { super.setPengadilan(pengadilan); }
    public void setTanggalPutusan(String tanggalPutusan) { super.setTanggalPutusan(tanggalPutusan); }

    // ==== getter & setter field milik Putusan sendiri ====

    public String getNamaTerdakwa() { return namaTerdakwa; }
    public void setNamaTerdakwa(String namaTerdakwa) { this.namaTerdakwa = namaTerdakwa; }

    public int getUmurTerdakwa() { return umurTerdakwa; }
    public void setUmurTerdakwa(int umurTerdakwa) {
        // validasi simpel, umur ga mungkin minus
        if (umurTerdakwa < 0) throw new IllegalArgumentException("Umur tidak boleh negatif");
        this.umurTerdakwa = umurTerdakwa;
    }

    public String getJenisNarkotika() { return jenisNarkotika; }
    public void setJenisNarkotika(String jenisNarkotika) { this.jenisNarkotika = jenisNarkotika; }

    public double getBeratBarangBukti() { return beratBarangBukti; }
    public void setBeratBarangBukti(double beratBarangBukti) {
        if (beratBarangBukti <= 0) throw new IllegalArgumentException("Berat harus > 0");
        this.beratBarangBukti = beratBarangBukti;
    }

    public String getPasalDilanggar() { return pasalDilanggar; }
    public void setPasalDilanggar(String pasalDilanggar) { this.pasalDilanggar = pasalDilanggar; }

    public String getPeranTerdakwa() { return peranTerdakwa; }
    public void setPeranTerdakwa(String peranTerdakwa) { this.peranTerdakwa = peranTerdakwa; }

    public int getVonisHukuman() { return vonisHukuman; }
    public void setVonisHukuman(int vonisHukuman) {
        if (vonisHukuman < 0) throw new IllegalArgumentException("Vonis tidak boleh negatif");
        this.vonisHukuman = vonisHukuman;
    }

    public double getVonisDenda() { return vonisDenda; }
    public void setVonisDenda(double vonisDenda) {
        if (vonisDenda < 0) throw new IllegalArgumentException("Denda tidak boleh negatif");
        this.vonisDenda = vonisDenda;
    }

    public String getNamaHakim() { return namaHakim; }
    public void setNamaHakim(String namaHakim) { this.namaHakim = namaHakim; }

    public static int getJumlahDibuat() { return jumlahDibuat; }

    // contoh method overloading #1 - versi ringkas, cuma nampilin info penting
    public void tampilkan() {
        System.out.println(getNomorPerkara() + " | " + namaTerdakwa + " | " + jenisNarkotika);
    }

    // contoh method overloading #2 - kalo detail=true, nampilin semua info lengkap
    public void tampilkan(boolean detail) {
        if (!detail) { tampilkan(); return; }
        System.out.println("Nomor       : " + getNomorPerkara());
        System.out.println("Pengadilan  : " + getPengadilan());
        System.out.println("Terdakwa    : " + namaTerdakwa + " (" + umurTerdakwa + " thn)");
        System.out.println("Jenis       : " + jenisNarkotika + " (" + beratBarangBukti + " gr)");
        System.out.println("Pasal       : " + pasalDilanggar);
        System.out.println("Peran       : " + peranTerdakwa);
        System.out.println("Vonis       : " + vonisHukuman + " bulan, denda Rp" + vonisDenda);
        System.out.println("Hakim       : " + namaHakim);
        System.out.println("Kategori    : " + getKategoriHukuman());
    }

    // buat nentuin kategori vonis: ringan/sedang/berat
    // ini asumsi aja: <=12 bulan ringan, <=48 bulan sedang, sisanya berat
    public String getKategoriHukuman() {
        if (vonisHukuman <= 12) return "Ringan";
        else if (vonisHukuman <= 48) return "Sedang";
        else return "Berat";
    }

    @Override
    public String getRingkasanKasus() {
        return namaTerdakwa + " divonis " + vonisHukuman + " bulan atas kepemilikan " + jenisNarkotika;
    }
    @Override
    public String toString() {
        return getNomorPerkara() + " - " + namaTerdakwa + " - " + getKategoriHukuman();
    }
    @Override
    public String ringkasan() {
        return "Putusan " + getNomorPerkara() + ": " + namaTerdakwa + ", " + jenisNarkotika
                + " (" + beratBarangBukti + " gr), vonis " + vonisHukuman + " bulan.";
    }
    @Override
    public double getTotalKerugian() {
        return vonisDenda;
    }
}