package app;

import controller.KnowledgeController;
import view.ConsoleView;
import java.util.Scanner;

// entry point aplikasi versi console
// alurnya: tampilin menu -> proses pilihan -> ulang sampe user pilih keluar (0)
public class Main {
    public static void main(String[] args) {
        KnowledgeController controller = new KnowledgeController();
        ConsoleView view = new ConsoleView();
        Scanner sc = new Scanner(System.in);

        int pilihan;
        do {
            pilihan = view.tampilkanMenu(sc);

            switch (pilihan) {
                case 1: {
                    String[] data = view.inputFormPutusan(sc);
                    boolean sukses = controller.tambahPutusan(data);
                    view.tampilkanPesan(sukses
                            ? "Data berhasil ditambahkan."
                            : "Gagal menambahkan data. Periksa kembali input Anda.");
                    break;
                }

                case 2:
                    view.tampilkanDaftarPutusan(controller.getSemuaPutusan());
                    break;

                case 3: {
                    // pencarian, bisa by nomor perkara atau nama terdakwa
                    System.out.print("Cari berdasarkan (nomor/nama): ");
                    String mode = sc.nextLine();
                    System.out.print("Kata kunci: ");
                    String keyword = sc.nextLine();
                    view.tampilkanDaftarPutusan(controller.cariPutusan(keyword, mode));
                    break;
                }

                case 4: {
                    System.out.print("Filter berdasarkan (jenis/pengadilan): ");
                    String kriteria = sc.nextLine();
                    System.out.print("Nilai: ");
                    String nilai = sc.nextLine();
                    view.tampilkanDaftarPutusan(controller.filterPutusan(kriteria, nilai));
                    break;
                }

                case 5: {
                    System.out.print("Nomor perkara yang dihapus: ");
                    String nomor = sc.nextLine();
                    boolean hapus = controller.hapusPutusan(nomor);
                    view.tampilkanPesan(hapus ? "Data berhasil dihapus." : "Data tidak ditemukan.");
                    break;
                }

                case 6:
                    view.tampilkanStatistik(controller.getStatistik());
                    break;

                case 0:
                    view.tampilkanPesan("Terima kasih telah menggunakan aplikasi KMS Putusan Narkotika.");
                    break;

                default:
                    view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}