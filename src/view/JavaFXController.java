package view;

import controller.KnowledgeController;
import model.Putusan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

/** Controller buat sisi tampilan (JavaFX)
Tugas file ini cuma nyambungin UI ke KnowledgeController
*/
 public class JavaFXController {

    /**controller utama, isinya logic simpan/hapus/tampil data putusan*/
    private KnowledgeController controller = new KnowledgeController();

    /** Input field untuk nomor perkara, nama terdakwa, jenis narkotika, vonis, pengadilan,
     * tanggal, umur, berat, pasal, peran, dwnda, hakim*/
    @FXML private TextField txtNomorPerkara;
    @FXML private TextField txtNamaTerdakwa;
    @FXML private TextField txtJenisNarkotika;
    @FXML private TextField txtVonis;
    @FXML private TextField txtPengadilan;
    @FXML private TextField txtTanggal;
    @FXML private TextField txtUmur;
    @FXML private TextField txtBerat;
    @FXML private TextField txtPasal;
    @FXML private TextField txtPeran;
    @FXML private TextField txtDenda;
    @FXML private TextField txtHakim;
    @FXML private TextField txtCari;
    @FXML private Label lblStatus;

    @FXML private TableView<Putusan> tabelPutusan;
    @FXML private TableColumn<Putusan, String> colNomor;
    @FXML private TableColumn<Putusan, String> colPengadilan;
    @FXML private TableColumn<Putusan, String> colTanggal;
    @FXML private TableColumn<Putusan, String> colNama;
    @FXML private TableColumn<Putusan, Integer> colUmur;
    @FXML private TableColumn<Putusan, String> colJenis;
    @FXML private TableColumn<Putusan, Double> colBerat;
    @FXML private TableColumn<Putusan, String> colPasal;
    @FXML private TableColumn<Putusan, String> colPeran;
    @FXML private TableColumn<Putusan, Integer> colVonis;
    @FXML private TableColumn<Putusan, Double> colDenda;
    @FXML private TableColumn<Putusan, String> colHakim;
    // method ini otomatis kepanggil pas FXML selesai di-load
    @FXML
    public void initialize() {
        // mapping kolom tabel ke atribut di model Putusan
        colNomor.setCellValueFactory(new PropertyValueFactory<>("nomorPerkara"));
        colPengadilan.setCellValueFactory(new PropertyValueFactory<>("pengadilan"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggalPutusan"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("namaTerdakwa"));
        colUmur.setCellValueFactory(new PropertyValueFactory<>("umurTerdakwa"));
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenisNarkotika"));
        colBerat.setCellValueFactory(new PropertyValueFactory<>("beratBarangBukti"));
        colPasal.setCellValueFactory(new PropertyValueFactory<>("pasalDilanggar"));
        colPeran.setCellValueFactory(new PropertyValueFactory<>("peranTerdakwa"));
        colVonis.setCellValueFactory(new PropertyValueFactory<>("vonisHukuman"));
        colDenda.setCellValueFactory(new PropertyValueFactory<>("vonisDenda"));
        colHakim.setCellValueFactory(new PropertyValueFactory<>("namaHakim"));

        refreshTabel();
    }

    /**
     * Handler untuk tombol "Tambah Putusan".
     * Setelah data diproses lewat KnowledgeController tambahPutusan,
     * label status akan diperbarui sesuai hasilnya, dan tabel akan di-refresh.
     */
    @FXML
    private void handleTambahPutusan() {
        try {
            String[] data = {
                    txtNomorPerkara.getText(),
                    txtPengadilan.getText(),
                    txtTanggal.getText(),
                    txtNamaTerdakwa.getText(),
                    txtUmur.getText(),
                    txtJenisNarkotika.getText(),
                    txtBerat.getText(),
                    txtPasal.getText(),
                    txtPeran.getText(),
                    txtVonis.getText(),
                    txtDenda.getText(),
                    txtHakim.getText()
            };

            boolean sukses = controller.tambahPutusan(data);

            if (sukses) {
                lblStatus.setText("Data berhasil ditambahkan.");
            } else {
                lblStatus.setText("Gagal menambahkan data, coba cek lagi inputnya.");
            }

            refreshTabel();

        } catch (Exception e) {
            lblStatus.setText("Ups, ada kesalahan. Coba periksa kembali input Anda.");
        }
    }
    /**
     * Handler untuk tombol "Cari".
     * Mencari putusan berdasarkan nomor perkara atau nama terdakwa
     * (dicoba dua-duanya, hasil yang ditemukan langsung ditampilkan di tabel).
     */
    @FXML
    private void handleCariPutusan() {
        String keyword = txtCari.getText();

        if (keyword == null || keyword.trim().isEmpty()) {
            lblStatus.setText("Masukkan kata kunci pencarian terlebih dahulu.");
            return;
        }

        // coba cari berdasarkan nomor perkara dulu
        ArrayList<Putusan> hasil = controller.cariPutusan(keyword, "nomor");

        // kalau gak ketemu, coba cari berdasarkan nama
        if (hasil.isEmpty()) {
            hasil = controller.cariPutusan(keyword, "nama");
        }

        if (hasil.isEmpty()) {
            lblStatus.setText("Data tidak ditemukan.");
        } else {
            lblStatus.setText("Ditemukan " + hasil.size() + " data.");
        }

        ObservableList<Putusan> data = FXCollections.observableArrayList(hasil);
        tabelPutusan.setItems(data);
    }
/**
 * Handler untuk tombol "Hapus Putusan".
 * Mengambil nomor perkara dari input field,lalu meminta
 *      * KnowledgeController hapusPutusan untuk menghapus data
 *      * dengan nomor perkara tersebut. Label status akan diperbarui sesuai hasilnya,
 *      * dan tabel akan di-refresh.
 *      */
    @FXML
    private void handleHapusPutusan() {
        String nomor = txtNomorPerkara.getText();
        boolean hapus = controller.hapusPutusan(nomor);

        lblStatus.setText(hapus ? "Data berhasil dihapus." : "Data tidak ditemukan.");
        refreshTabel();
    }

    // handler tombol "Refresh"
    @FXML
    private void handleRefresh() {
        refreshTabel();
    }

    // load ulang isi tabel dari controller
    private void refreshTabel() {
        ObservableList<Putusan> data = FXCollections.observableArrayList(controller.getSemuaPutusan());
        tabelPutusan.setItems(data);
    }
}