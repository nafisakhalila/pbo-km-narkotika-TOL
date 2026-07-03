package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import java.util.ArrayList;

//jembatan antara View sama Model
//semua request dari UI lewat sini dulu sebelum sampe ke repository
public class KnowledgeController {

    private KnowledgeRepository repository;

    public KnowledgeController() {
        repository = new KnowledgeRepository();
    }

    //data mentah dari form/CSV -> object Putusan
    //urutan array-nya harus pas, kalo ga bakal kena catch di bawah
    public boolean tambahPutusan(String[] data) {
        try {
            Putusan p = new Putusan(
                    data[0], data[1], data[2], data[3],
                    Integer.parselnt(data[4]), data[5],
                    Double.parseDouble(data[6]), data[7], data[8],
                    Integer.parselnt(data[9]), Double.parseDouble(data[10]), data[11]
            );
            repository.simpan(p);
            return true;
        } catch (Exception e) {
            //bisa NumberFormatException atau ArrayIndexOutOfBounds, males dibedain
            return false;
        }
    }

    // cari putusan, mode-nya cuma dua: "nomor" atau "nama"
    // TODO: mungkin nanti tambah mode pencarian lain kalo dibutuhin
    public ArrayList<Putusan> cariPutusan(String keyword, String mode) {
        if (mode.equalsIgnoreCase("nomor")) {
            ArrayList<Putusan> hasil = new ArrayList<>();
            Putusan p = repository.cariByNomor(keyword);
            if (p != null) {
                hasil.add(p);
            }
            return hasil;
        }

        return repository.cariByNama(keyword);
    }

    // filter data, kriteria "jenis" (narkotika) atau "pengadilan"
    public ArrayList<Putusan> filterPutusan(String kriteria, String nilai) {
        if (kriteria.equalsIgnoreCase("jenis")) {
            return repository.filterByJenis(nilai);
        }

        return repository.filterByPengadilan(nilai);
    }

    // hapus berdasarkan nomor perkara, return false kalo ga ketemu
    public boolean hapusPutusan(String nomor) {
        return repository.hapus(nomor);
    }

    // ngitung statistik dari semua data yang ada
    public StatistikPutusan getStatistik() {
        return new StatistikPutusan(repository.getDaftarSemua());
    }

    // buat nampilin semua data di tabel/list view
    public ArrayList<Putusan> getSemuaPutusan() {
        return repository.getDaftarSemua();
    }
}
}

