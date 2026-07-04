package view;

import controller.KnowledgeController;
import model.Putusan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

// Controller buat sisi tampilan (JavaFX)
// Tugas file ini cuma nyambungin UI ke KnowledgeController, gak ada logic bisnis di sini
// biar sesuai prinsip pemisahan tanggung jawab (MVC) yang diajarin di kelas
public class JavaFXController {

    // controller utama, isinya logic simpan/hapus/tampil data putusan
    private KnowledgeController controller = new KnowledgeController();

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

    // handler tombol "Tambah"
    @FXML
    private void handleTambahPutusan() {
        try {
            // catatan: sebagian data masih di-hardcode dulu karena form belum lengkap
            // (rencananya field2 ini bakal ditambah kalau ada waktu revisi)
            String nomor = txtNomorPerkara.getText();
            String nama = txtNamaTerdakwa.getText();
            String jenis = txtJenisNarkotika.getText();
            String vonis = txtVonis.getText();

            String[] data = {
                    nomor,
                    "PN Surabaya",
                    "01/01/2026",
                    nama,
                    "30",
                    jenis,
                    "1.0",
                    "Pasal 114 UU No. 35/2009",
                    "Kurir",
                    vonis,
                    "0",
                    "Hakim Contoh"
            };

            boolean sukses = controller.tambahPutusan(data);

            if (sukses) {
                lblStatus.setText("Data berhasil ditambahkan.");
            } else {
                lblStatus.setText("Gagal menambahkan data, coba cek lagi inputnya.");
            }

            refreshTabel();

        } catch (Exception e) {
            // ditangkap generic dulu, belum sempat bikin exception khusus
            lblStatus.setText("Ups, ada kesalahan. Coba periksa kembali input Anda.");
        }
    }

    // handler tombol "Hapus"
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