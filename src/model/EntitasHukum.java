package model;

/**
 * Superclass abstrak buat semua entitas hukum di sistem KMS ini.
 * Nyimpen atribut yang sama-sama dimiliki semua jenis entitas hukum:
 * nomor perkara, nama pengadilan, sama tanggal putusan.
 *
 * Dibuat abstract karena EntitasHukum sendiri ga akan pernah diinstansiasi
 * langsung — selalu lewat subclass-nya (contoh: Putusan).
 *
 * Dibuat untuk Tugas Besar PBO - Sistem Informasi Putusan Narkotika
 */
public abstract class EntitasHukum {

    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;

    public EntitasHukum(String nomorPerkara, String pengadilan, String tanggalPutusan) {
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
    }

    // getter dibuat public karena data ini emang perlu diakses dari luar (buat tampilan, dll)
    public String getNomorPerkara() { return nomorPerkara; }
    public String getPengadilan() { return pengadilan; }
    public String getTanggalPutusan() { return tanggalPutusan; }

    // setter sengaja dibuat protected aja, biar cuma subclass yang boleh ubah data ini
    // (dari luar package/class lain ga boleh sembarangan ganti nomor perkara dkk)
    protected void setNomorPerkara(String nomorPerkara) { this.nomorPerkara = nomorPerkara; }
    protected void setPengadilan(String pengadilan) { this.pengadilan = pengadilan; }
    protected void setTanggalPutusan(String tanggalPutusan) { this.tanggalPutusan = tanggalPutusan; }

    /**
     * Method abstrak buat ngasih ringkasan kasus dalam bentuk teks singkat.
     * Wajib di-override sama setiap subclass, soalnya beda jenis entitas
     * hukum pasti beda juga cara ringkasnya.
     * @return ringkasan kasus dalam bentuk String
     */
    public abstract String getRingkasanKasus();

    @Override
    public String toString() {
        return nomorPerkara + " (" + pengadilan + ")";
    }
}