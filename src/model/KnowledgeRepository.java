package model;
import java.util.ArrayList;
/**
 * Class ini berfungsi sebagai "database sementara" buat nyimpen data Putusan,
 * pakai ArrayList biasa (belum pakai database beneran / file).
 * pencarian by nomor/nama, sama filter by jenis & pengadilan.
 */
public class KnowledgeRepository {
    private ArrayList<Putusan> daftarPutusan = new ArrayList<>();
    public KnowledgeRepository() {
        loadSampleData();
    }

    /**
     * Load data dummy/sample buat testing awal.
     * TODO: isi minimal 50 data Putusan di sini
     */
    private void loadSampleData() {
        // masih kosong, nanti diisi belakangan
    }

    // nambah data baru ke daftar
    public void simpan(Putusan p) {
        daftarPutusan.add(p);
    }
    // cari 1 data spesifik pake nomor perkara, kalo ga ketemu balikin null
    public Putusan cariByNomor(String nomor) {
        for (Putusan p : daftarPutusan) {
            if (p.getNomorPerkara().equalsIgnoreCase(nomor)) {
                return p;
            }
        }
        return null;
    }

    // cari berdasarkan nama terdakwa, boleh sebagian aja (ga harus exact match)
    public ArrayList<Putusan> cariByNama(String nama) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getNamaTerdakwa().toLowerCase().contains(nama.toLowerCase())) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    // ==== fitur filter ====

    // filter data berdasarkan jenis narkotika (sabu, ganja, dll)
    public ArrayList<Putusan> filterByJenis(String jenis) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getJenisNarkotika().equalsIgnoreCase(jenis)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    // filter data berdasarkan nama pengadilan yang mengadili
    public ArrayList<Putusan> filterByPengadilan(String pengadilan) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getPengadilan().equalsIgnoreCase(pengadilan)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    // hapus data berdasarkan nomor perkara, balikin true kalo berhasil ketemu & kehapus
    public boolean hapus(String nomor) {
        return daftarPutusan.removeIf(p -> p.getNomorPerkara().equalsIgnoreCase(nomor));
    }

    //getter buat akses langsung dari luar
    public ArrayList<Putusan> getDaftarSemua() {
        return daftarPutusan;
    }
    public int getTotalData() {
        return daftarPutusan.size();
    }
}