package view;

import controller.KnowledgeController;
import model.Putusan;
import model.StatistikPutusan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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
    /**
     * Handler untuk tombol "Statistik".
     * Menampilkan hasil kalkulasi StatistikPutusan dalam bentuk dialog popup
     * dengan tampilan yang lebih rapi dan terstruktur.
     */
    @FXML
    private void handleTampilkanStatistik() {
        StatistikPutusan stat = controller.getStatistik();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Statistik Putusan");
        alert.setHeaderText(null);

        // ===== Header =====
        Label headerTitle = new Label("📊 Laporan Statistik Putusan Narkotika");
        headerTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #1e3a8a;");

        Separator separator = new Separator();

        // ===== Ringkasan utama (grid biar rapi sejajar) =====
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(6);
        grid.setPadding(new Insets(10, 0, 10, 0));

        grid.add(buatLabelKey("Total Putusan"), 0, 0);
        grid.add(buatLabelValue(String.valueOf(stat.getTotalPutusan())), 1, 0);

        grid.add(buatLabelKey("Rata-rata Vonis"), 0, 1);
        grid.add(buatLabelValue(String.format("%.2f bulan", stat.getRataRataVonis())), 1, 1);

        grid.add(buatLabelKey("Rata-rata Denda"), 0, 2);
        grid.add(buatLabelValue(String.format("Rp%,.0f", stat.getRataRataDenda())), 1, 2);

        grid.add(buatLabelKey("Jenis Narkotika Terbanyak"), 0, 3);
        grid.add(buatLabelValue(stat.getJenisNarkotikaTerbanyak()), 1, 3);

        // ===== Distribusi peran terdakwa =====
        Label distribusiTitle = new Label("Distribusi Peran Terdakwa");
        distribusiTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #33475b; -fx-padding: 8 0 4 0;");

        VBox distribusiBox = new VBox(4);
        for (String d : stat.getDistribusiPeran()) {
            Label item = new Label("•  " + d);
            item.setStyle("-fx-text-fill: #475569;");
            distribusiBox.getChildren().add(item);
        }

        VBox content = new VBox(4, headerTitle, separator, grid, distribusiTitle, distribusiBox);
        content.setPadding(new Insets(15));
        content.setStyle("-fx-background-color: white;");

        alert.getDialogPane().setContent(content);
        alert.getDialogPane().setPrefWidth(650);

        alert.getDialogPane().getStylesheets().add(
                getClass().getResource("style.css").toExternalForm()
        );

        alert.showAndWait();
    }

    private Label buatLabelKey(String text) {
        Label l = new Label(text + " :");
        l.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
        return l;
    }

    private Label buatLabelValue(String text) {
        Label l = new Label(text);
        l.setStyle("-fx-text-fill: #1e293b; -fx-font-weight: 600; -fx-font-size: 13px;");
        l.setWrapText(true);
        l.setMaxWidth(400);
        return l;
    }

    // load ulang isi tabel dari controller
    private void refreshTabel() {
        ObservableList<Putusan> data = FXCollections.observableArrayList(controller.getSemuaPutusan());
        tabelPutusan.setItems(data);
    }
}