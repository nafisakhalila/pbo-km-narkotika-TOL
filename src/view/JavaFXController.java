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
    @FXML private TableColumn<Putusan, String> colNama;
    @FXML private TableColumn<Putusan, String> colJenis;
    @FXML private TableColumn<Putusan, Integer> colVonis;

    // method ini otomatis kepanggil pas FXML selesai di-load
    @FXML
    public void initialize() {
        // mapping kolom tabel ke atribut di model Putusan
        colNomor.setCellValueFactory(new PropertyValueFactory<>("nomorPerkara"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("namaTerdakwa"));
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenisNarkotika"));
        colVonis.setCellValueFactory(new PropertyValueFactory<>("vonisHukuman"));

        refreshTabel();
    }

    // handler tombol "Tambah"
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