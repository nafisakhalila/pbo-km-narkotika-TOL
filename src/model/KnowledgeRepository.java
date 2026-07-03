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
     * Datanya diambil dari rekap 49 putusan kasus narkotika (PN Surabaya & PN Serui).
     */
    private void loadSampleData() {
        // data ini diambil dari kumpulan putusan PN Surabaya & PN Serui (2024-2025)
        // sebagian data mentahnya berantakan (format tanggal beda-beda, satuan berat
        // barang bukti ga seragam, dll), jadi beberapa nilai di bawah ini udah
        // dirapikan/disederhanain manual biar cocok sama tipe data di constructor Putusan

        simpan(new Putusan("1/Pid.Sus/2024/PN Sby", "PN Surabaya", "03/06/2024",
                "Ricky Noviyanto", 35, "Shabu (Metamfetamina)",
                2.09, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Membeli dan menjual Narkotika Golongan I", 84, 1000000000.0,
                "Dr. Nurnaningsih Amriani, S.H., M.H. (Hakim Ketua), Widiarso, S.H., M.H. (Hakim Anggota), dan Abu Achmad Sidqi Amsya, S.H. (Hakim Anggota)"));

        simpan(new Putusan("3/Pid.Sus/2024/PN Sby", "PN Surabaya", "20/1/2024",
                "Putu Gede Dhani Gita Candra", 25, "Shabu (Metamfetamina)",
                2.38, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Membeli dan menjual Narkotika Golongan I", 72, 1000000000.0,
                "Cokia Ana Pontia O, S.H., M.H. (Hakim Ketua), Titik Budi Winarti, S.H., M.H. (Hakim Anggota), dan Djuanto, S.H., M.H. (Hakim Anggota)"));

        simpan(new Putusan("7/Pid.Sus/2024/PN.Sby", "PN Surabaya", "30/01/2024",
                "Muahmmad Ricky Bagus", 26, "Shabu (Kristal Metamfetamina)",
                0.316, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Menyimpan, Memiliki, Menguasai, dan Menyediakan Narkotika", 48, 1000000000.0,
                "Alex Adam Faisal, S.H. (Hakim Ketua), Mochammad Djoenaidie, S.H., M.H., dan Suswanti, S.H., M.Hum. (Hakim Anggota)"));

        simpan(new Putusan("9/Pid.Sus/2025/PN Sru", "PN Serui", "15/05/2025",
                "Ghito Rolies Jems Tanawani", 34, "Tanaman (Ganja)",
                37.7, "Pasal 111 ayat (1) UU RI No. 35 Tahun 2009",
                "Pembeli dan penguasa Narkotika", 54, 1000000000.0,
                "Yuliana Ayomi, S.H. (Hakim Ketua), Taufik, S.H. (Hakim Anggota), dan M. Syukri Al-Bakri, S."));

        simpan(new Putusan("186/Pid.Sus/2024/PN Sby", "PN Surabaya", "07/03/2024",
                "Agus Arianto", 45, "Shabu (Metamfetamina))",
                0.61, "Pasal 114 ayat (1) UU No. 35 Tahun 2009",
                "Pengedar dan Penjual Narkotika", 72, 1500000000.0,
                "Hakim Ketua: Dr. Nurnaningsih Amriani, S.H., M.H. Hakim Anggota: Abu Achmad Sidqi Amsya, S.H. dan Widiarso, S.H., M.H."));

        simpan(new Putusan("11/Pid.Sus/2024/PN Sby", "PN Surabaya", "28/02/2024",
                "Gatut Setyo Utomo", 23, "Shabu (Metamfetamina)",
                0.146, "Pasal 114 ayat (1) Jo. Pasal 132 ayat (1) UU RI No. 35 Tahun 2009",
                "Perantara jual beli Narkotika", 78, 1000000000.0,
                "Hakim Ketua: Rudito Surotomo, S.H., M.H.; Hakim Anggota: R. Yoes Hartyarso, S.H., M.H. dan Arlandi Triyogo, S.H., M.H."));

        simpan(new Putusan("13/Pid.Sus/2024/PN Sby", "PN Surabaya", "19/02/2024",
                "Mochamad Yahya", 33, "Sabu (Kristal Metamfetamina) dan Sediaan Farmasi (Pil LL/Triheksifenidil HCl)",
                0.629, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Menjual dan menjadi Perantara jual beli Narkotika", 72, 1000000000.0,
                "Silfi Yanti Zulfia, S.H., M.H. (Ketua), Saifudin Zuhri, S.H., M.H. (Anggota), dan Taufan Mandala, S.H., M.Hum. (Anggota)"));

        simpan(new Putusan("139/Pid.Sus/2024/PN Sby", "PN Surabaya", "06/03/2024",
                "Mustofek", 42, "Shabu (Kristal Metamfetamina)",
                7.688, "Pasal 114 ayat (2) Undang-Undang Nomor 35 Tahun 2009",
                "Perantara dalam jual beli", 84, 1000000000.0,
                "Hakim Ketua: Titik Budi Winarti, S.H., M.H. Hakim Anggota: Antyo Harri Susetyo, S.H dan Cokia Ana Pontia Oppusunggu, S.H., M.H."));

        simpan(new Putusan("20/Pid.Sus/2024/PN Sby", "PN Surabaya", "21/02/2024",
                "Imam Afandi", 32, "Shabu (Metamfetamina)",
                0.395, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar, Membeli, dan Menjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Khadwanto, S.H. Hakim Anggota: Suparno, S.H., M.H. dan I Ketut Kimiarsa, S.H., M.H."));

        simpan(new Putusan("25/Pid.Sus/2024/PN Sby", "PN Surabaya", "21/03/2024",
                "Moch. Mansur", 28, "Pil Ekstasi (MDMA) berlogo \"Kuda\"/Ferrari",
                18.7, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar, Perantara jual, dan Pengedar Narkotika", 108, 1000000000.0,
                "Hakim Ketua: Tongani, S.H., M.H. Hakim Anggota: Silfi Yanti Zulfia, S.H., M.H. dan Darwanto, S.H., M.H."));

        simpan(new Putusan("27/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-07-03 00:00:00",
                "Moch. Fahri", 52, "Shabu (Metamfetamina)",
                1.834, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar, Penjual, dan Pemakai", 102, 1000000000.0,
                "Hakim Ketua: Silfi Yanti Zulfia, S.H., M.H. Hakim Anggota: Tongani, S.H., M.H. dan Darwanto, S.H., M.H."));

        simpan(new Putusan("29/Pid.Sus/2024/PN Sby", "PN Surabaya", "22/05/2024",
                "Akhmad Riyanto", 30, "Shabu (Kristal Metamfetamina)",
                998.8, "Pasal 14 ayat (2) jo. Pasal 132 ayat (1) UU No. 36 Tahun 2009",
                "Perantara menerima perintah dari DPO untuk menyerahkan sabu", 84, 1000000000.0,
                "Hakim Ketua: Tongani, S.H., M.H. Hakim Anggota: Darwanto, S.H., M.H. dan Silfi Yanti Zulfia, S.H., M.H."));

        simpan(new Putusan("174/Pid.Sus/2024/PN Sby", "PN Surabaya", "25/03/2024",
                "Jeffri Andriyanto", 34, "Bukan tanaman jenis shabu (Metamfetamina)",
                22.37, "Pasal 114 ayat (2) UU No.35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 108, 800000000.0,
                "Hakim Ketua: Ferdinand Marcus Leander, S.H., M.H. Hakim Anggota: Ni Putu Sri Indayani, S.H., M.H. dan Toniwidjaya Hansberd hilly, S.H."));

        simpan(new Putusan("31/Pid.Sus/2024/PN Sby", "PN Surabaya", "08/02/2024",
                "Muchamad Umar Faroq", 28, "Shabu (Kristal Metamfetamina)",
                903.7, "Pasal 14 ayat (2) jo. Pasal 132 ayat (1) UU No. 36 Tahun 2009",
                "Perantara, Menerima perintar dan menerima dengan imbalan uang", 84, 1000000000.0,
                "Hakim Ketua: Tongani, S.H., M.H. Hakim Anggota: Darwanto, S.H., M.H. dan Silfi Yanti Zulfia, S.H., M.H."));

        simpan(new Putusan("196/Pid.Sus/2024/PN Sby", "PN Surabaya", "28/03/2024",
                "Soepranu", 42, "Bukan tanaman jenis sabu (Metamfetamina)",
                2.480, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 60, 800000000.0,
                "Hakim Ketua: Abu Achmad Sidqi Amsya, S.H. Hakim Anggota: Dr. Nurnaningsih Amriani, S.H., M.H. dan  Widiarso, S.H., M.H."));

        simpan(new Putusan("34/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-07-03 00:00:00",
                "Abdul Gefur", 44, "Shabu (Kristal Metamfetamina)",
                0.836, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Pemilik, Pemakai, dan Pengedar Narkotika", 60, 800000000.0,
                "Hakim Ketua: Mochammad Djoenaidie, S.H., M.H. Hakim Anggota: Alex Adam Faisal, S.H. dan Sudar, S.H., M.Hum"));

        simpan(new Putusan("36/Pid.Sus/2024/PN Sby", "PN Surabaya", "22/02/2024",
                "Tover Tukan", 37, "Shabu (Kristal Metamfetamina)",
                0.407, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan Perantara jual beli Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Moch. Taufik Tatas Prihyantono, S.H. Hakim Anggota: Ni Putu Sri Indayani, S.H., M.H. dan Sutrisno, S.H., M.H."));

        simpan(new Putusan("39/Pid.Sus/2024/PN Sby", "PN Surabaya", "20/02/2024",
                "Moch. Riadi", 26, "Shabu (Kristal Metamfetamina)",
                0.229, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan Perantara jual beli Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Erintuah Damanik, S.H., M.H. Hakim Anggota: Hj. Halima Umaternate, S.H., M.H. dan I Ketut Kimiarsa, S.H., M.H."));

        simpan(new Putusan("49/Pid.Sus/2024/PN Sby", "PN Surabaya", "22/02/2024",
                "Abdur Rohman", 27, "Shabu (Kristal Metamfetamina)",
                1.448, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan Perantara jual beli Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Mochammad Djoenaidie, S.H., M.H. Hakim Anggota: Alex Adam Faisal, S.H. dan Sudar, S.H., M.Hum."));

        simpan(new Putusan("50/Pid.Sus/2024/PN Sby", "PN Surabaya", "19/03/2024",
                "Guntur Pamungkas", 27, "Shabu (Kristal Metamfetamina)",
                2.089, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan Perantara jual beli Narkotika", 84, 1000000000.0,
                "Hakim Ketua: Sudar, S.H., M.Hum. Hakim Anggota: Alex Adam Faisal, S.H. dan Suswanti, S.H., M.Hum."));

        simpan(new Putusan("54/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-01-02 00:00:00",
                "Warda Andreansyah", 24, "Shabu (Kristal Metamfetamina)",
                0.001, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pemilik dan Penguasa Narkotika", 66, 1000000000.0,
                "namaHakim Hakim Ketua: Heru Hanindyo, S.H., M.H., LL.M. Hakim Anggota: R. Yoes Hartyarso, S.H., M.H. dan Rudito Surotomo, S.H., M.H."));

        simpan(new Putusan("55/Pid.Sus/2024/PN Sby", "PN Surabaya", "22/02/2025",
                "Ilham Reza Izzuddin", 25, "Ganja (batang, daun, dan biji)",
                12.72, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan Perantara jual beli Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Erintuah Damanik, S.H., M.H. Hakim Anggota: Hj. Halima Umaternate, S.H., M.H. dan I Ketut Kimiarsa, S.H., M.H."));

        simpan(new Putusan("58/Pid.Sus/2024/PN Sby", "PN Surabaya", "21/03/2024",
                "Kasmanto", 38, "Shabu (Kristal Metamfetamina)",
                0.079, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Pemilik dan Penguasa Narkotika", 48, 0.0,
                "Hakim Ketua: Saifudin Zuhri, S.H., M.Hum. Hakim Anggota: Silfi Yanti Zulfia, S.H., M.H. dan Taufan Mandala, S.H., M.Hum."));

        simpan(new Putusan("61/Pid.Sus/2024/PN Sby", "PN Surabaya", "19/02/2024",
                "Fausen", 24, "Shabu (Kristal Metamfetamina)",
                0.551, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Pemilik dan Penguasa Narkotika", 72, 800000000.0,
                "Hakim Ketua: Taufan Mandala, S.H., M.Hum. Hakim Anggota: Silfi Yanti Zulfia, S.H., M.H. dan Saifudin Zuhri, S.H., M.H."));

        simpan(new Putusan("62/Pid.Sus/2024/PN Sby", "PN Surabaya", "22/02/2024",
                "Muhammad Rochman", 37, "Shabu (Kristal Metamfetamina)",
                0.069, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Pemilik dan Penguasa Narkotika", 66, 900000000.0,
                "Hakim Ketua: Dr. Nurnaningsih Amriani, S.H., M.H. Hakim Anggota: Widiarso, S.H., M.H. dan Abu Achmad Sidqi Amsya, S.H."));

        simpan(new Putusan("143/Pid.Sus/2024/PN Sby", "PN Surabaya", "24/04/2024",
                "Anty Arianty", 29, "Shabu (Kristal Metamfetamina)",
                499, "Pasal 114 ayat (2) jo. Pasal 132 ayat (1) UU No. 36 Tahun 2009",
                "Pembeli dan Penguasa Narkotika", 72, 800000000.0,
                "Hakim Ketua: I Ketut Kimiarsa, S.H., M.H. Hakim Anggota: Erintuah Damanik, S.H., M.H. dan Suparno, S.H., M.H."));

        simpan(new Putusan("65/Pid.Sus/2024/PN Sby", "PN Surabaya", "21/03/2024",
                "Musaffa", 36, "Ekstasi dengan logo \"Rolex\"",
                7.96, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 96, 1000000000.0,
                "Hakim Ketua: Widiarso, S.H., M.H. Hakim Anggota: Dr. Nurnaningsih Amriani, S.H., M.H. dan Abu Achmad Sidqi Amsya, S.H."));

        simpan(new Putusan("67/Pid.Sus/2024/PN Sby", "PN Surabaya", "14/03/2024",
                "Lanang Firdaus Ingpranata Buana", 20, "Sinte (Tembakau Gorilla)",
                39.4, "Pasal 114 ayat (2) UU RI No. 35 Tahun 2009",
                "Bandar dan Pengedar Narkotika", 104, 1000000000.0,
                "Hj. Halima Umaternate, S.H., M.H. (Hakim Ketua)"));

        simpan(new Putusan("79/Pid.Sus/2024/PN Sby", "PN Surabaya", "25/03/2024",
                "Moch. Nopel", 42, "Shabu (Kristal Metamfetamina)",
                0.469, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Djuanto, S.H., M.H. Hakim Anggota: Antyo Harri Susetyo, S.H.; Cokia Ana Pontia Opposunggu, S.H., M.H"));

        simpan(new Putusan("80/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-09-04 00:00:00",
                "Moch. Dahlan", 49, "Shabu (Kristal Metamfetamina)",
                5.018, "Pasal 114 ayat (2) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 84, 1000000000.0,
                "Hakim Ketua: Djuanto, S.H., M.H. Hakim Anggota: Antyo Harri Susetyo, S.H.; Cokia Ana Pontia Opposunggu, S.H., M.H."));

        simpan(new Putusan("86/Pid.Sus/2024/PN Sby", "PN Surabaya", "29/02/2024",
                "Moch. Oesman", 48, "Bukan tanaman jenis sabu (Metamfetamina)",
                2.12, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: I Dewa Gede Suarditha, S.H., M.H. Hakim Anggota: Dr. Nurnaningsih Amriani, S.H., M.H. dan Abu Achmad Sidqi Amsya, S.H."));

        simpan(new Putusan("87/Pid.Sus/2024/PN Sby", "PN Surabaya", "21/03/2024",
                "Yuli Subagyo", 42, "Bukan tanaman jenis sabu (Metamfetamina)",
                1.681, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Ni Putu Sri Indayani, S.H., M.H. Hakim Anggota: Moch. Taufik Tatas Prihyantono, S.H. dan Toniwidjaya Hansberd Hilly, S.H."));

        simpan(new Putusan("88/Pid.Sus/2024/PN Sby", "PN Surabaya", "25/03/2024",
                "Ahmad Faisol", 26, "Ganja (Tanaman) dan Sabu (Metamfetamina)",
                2387.14, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar, Penjual, dan Pemakai Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Ferdinand Marcus Leander, S.H., M.H. Hakim Anggota: Sutrisno, S.H., M.H. dan Toniwidjaya Hansberd Hilly, S.H."));

        simpan(new Putusan("91/Pid.Sus/2024/PN Sby", "PN Surabaya", "25/03/2024",
                "Ketot Samiawan", 34, "Bukan tanaman jenis sabu (Metamfetamina)",
                4.003, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Ni Putu Sri Indayani, S.H., M.H. Hakim Anggota: Moch. Taufik Tatas Prihyantono, S.H. dan Toniwidjaya Hansberd Hilly, S.H."));

        simpan(new Putusan("95/Pid.Sus/2024/PN Sby", "PN Surabaya", "13/03/2024",
                "Rasmat", 58, "Bukan tanaman jenis sabu (Metamfetamina)",
                0.772, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 84, 1000000000.0,
                "Hakim Ketua: Alex Adam Faisal, S.H. Hakim Anggota: Mochammad Djoenaidie, S.H., M.H. dan Mangapul, S.H., M.H."));

        simpan(new Putusan("145/Pid.Sus/2024/PN Sby", "PN Surabaya", "24/04/2024",
                "Dedi Soenanrno", 46, "Shabu (Metamfetamina)",
                499, "Pasal 114 ayat (2) jo. Pasal 132 ayat (1) UU No. 36 Tahun 2009",
                "Perantara jual beli Narkotika", 96, 1000000000.0,
                "Hakim Ketua: I Ketut Kimiarsa, S.H., M.H. Hakim Anggota: Erintuah Damanik, S.H., M.H. dan Suparno, S.H., M.H."));

        simpan(new Putusan("97/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-04-04 00:00:00",
                "Dimas Agus Setiawan", 21, "Bukan tanaman jenis sabu (Metamfetamina)",
                0.259, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Ferdinand Marcus Leander, S.H., M.H. Hakim Anggota: Moch. Taufik Tatas Prihyantono, S.H. dan Toniwidjaya Hansberd Hilly, S.H."));

        simpan(new Putusan("98/Pid.Sus/2024/PN Sby", "PN Surabaya", "29/02/2024",
                "Moch. Saiful", 37, "Bukan tanaman jenis sabu (Metamfetamina)",
                0.469, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Mangapul, S.H., M.H. Hakim Anggota: Alex Adam Faisal, S.H. dan Mochammad Djoenaidie, S.H., M.H."));

        simpan(new Putusan("148/Pid.Sus/2024/PN Sby", "PN Surabaya", "14/03/2024",
                "Sahrul", 21, "Bukan tanaman jenis sabu (Metamfetamina)",
                0.962, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan perantara jual beli Narkotika", 82, 1000000000.0,
                "Hakim Ketua: Rudito Surotomo, S.H., M.H. Hakim Anggota: R. Yoes Hartyarso, S.H., M.H. dan Heru Hanindyo, S.H., M.H., LL.M."));

        simpan(new Putusan("109/Pid.Sus/2024/PN Sby", "PN Surabaya", "18/03/2024",
                "Achmad Surya Dwiyansyah", 29, "Bukan tanaman jenis sabu (Metamfetamina)",
                1.43, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Pemilik dan Penguasa Narkotika", 54, 1000000000.0,
                "Antyo Harri Susetyo, S.H. (Hakim Ketua); Titik Budi Winarti, S.H., M.H. (Hakim Anggota); Cokia Ana Pontia Oppusunggu, S.H., M.H. (Hakim Anggota)."));

        simpan(new Putusan("153/Pid.Sus/2024/PN Sby", "PN Surabaya", "27/05/2024",
                "Matkurdi", 30, "Shabu (Metamfetamina)",
                0.735, "Pasal 112 ayat (1) UU RI No. 35 Tahun 2009",
                "Kurir dan Penguasa Narkotika", 48, 1000000000.0,
                "Hakim Ketua: Sudar, S.H., M.Hum. Hakim Anggota: Alex Adam Faisal, S.H. dan Mangapul, S.H., M.H."));

        simpan(new Putusan("114/Pid.Sus/2024/PN Sby", "PN Surabaya", "22/04/2024",
                "Mochamad Bushiri", 23, "Narkotika dalam bentuk tanaman (ganja)",
                10.406, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 84, 1000000000.0,
                "Hakim Ketua: Dr. Nurnaningsih Amriani, S.H., M.H. Hakim Anggota: Widiarso, S.H., M.H. dan I Dewa Gede Suarditha, S.H., M.H."));

        simpan(new Putusan("119/Pid.Sus/2024/PN Sby", "PN Surabaya", "18/03/2024",
                "Agham Taufan Ariesti", 22, "Bukan tanaman jenis sabu (Metamfetamina)",
                0.026, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pembeli Narkotika", 60, 1000000000.0,
                "Hakim Ketua: Djuanto, S.H., M.H. Hakim Anggota: Antyo Harri Susetyo, S.H. dan Cokia Ana Pontia Oppusunggu, S.H., M.H."));

        simpan(new Putusan("121/Pid.Sus/2024/PN Sby", "PN Surabaya", "13/03/2024",
                "Tri Melania Hendriany", 37, "Bukan tanaman jenis sabu (Metamfetamina)",
                21.85, "Pasal 114 ayat (2) UU RI No. 35 Tahun 2009",
                "Pengedan dan perantara jual beli Narkotika", 108, 1000000000.0,
                "Hakim Ketua: Khadwanto, S.H. Hakim Anggota: Suparno, S.H., M.H. dan Erintuah Damanik, S.H., M.H."));

        simpan(new Putusan("123/Pid.Sus/2024/PN Sby", "PN Surabaya", "28/02/2024",
                "Teguh Waskito", 45, "Bukan tanaman jenis sabu (Metamfetamina)",
                0.464, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 84, 1000000000.0,
                "Hakim Ketua: Antyo Harri Susetyo, S.H. Hakim Anggota: Titik Budi Winarti, S.H., M.H. dan Cokia Ana Pontia Oppusunggu, S.H., M.H."));

        simpan(new Putusan("124/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-06-03 00:00:00",
                "Ari Budiatmaja", 35, "Bukan tanaman jenis sabu (Metamfetamina)",
                12.528, "Pasal 114 ayat (2) UU RI No. 35 Tahun 2009",
                "Pengedar dan Perantara jual beli Narkotika", 132, 1000000000.0,
                "Hakim Ketua: Suparno, S.H., M.H. Hakim Anggota: Erintuah Damanik, S.H., M.H. Hakim Anggota: Khadwanto, S.H."));

        simpan(new Putusan("126/Pid.Sus/2024/PN Sby", "PN Surabaya", "25/03/2024",
                "Rahmad Indra", 37, "Bukan tanaman jenis sabu (Metamfetamina)",
                1.863, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Antyo Harri Susetyo, S.H. Hakim Anggota: Djuanto, S.H., M.H. Hakim Anggota: Cokia Ana Pontia Opposunggu, S.H., M.H."));

        simpan(new Putusan("130/Pid.Sus/2024/PN Sby", "PN Surabaya", "25/03/2024",
                "Suryanto", 49, "Bukan tanaman jenis sabu (Metamfetamina)",
                2.26, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 72, 1000000000.0,
                "Hakim Ketua: Antyo Harri Susetyo, S.H. Hakim Anggota: Titik Budi Winarti, S.H., M.H Hakim Anggota: Cokia Ana Pontia Oppusunggu, S.H., M.H."));

        simpan(new Putusan("133/Pid.Sus/2024/PN Sby", "PN Surabaya", "21/03/2024",
                "Heri Setyawan", 26, "Bukan tanaman jenis sabu (Metamfetamina)",
                2.01, "Pasal 114 ayat (1) UU RI No. 35 Tahun 2009",
                "Pengedar dan penjual Narkotika", 60, 1000000000.0,
                "Hakim Ketua: Silfi Yanti Zulfia, S.H., M.H Hakim Anggota: Darwanto, S.H., M.H. Hakim Anggota: Tongani, S.H., M.H"));

        simpan(new Putusan("173/Pid.Sus/2024/PN Sby", "PN Surabaya", "25/03/2024",
                "Bagus Dwi Agus Wiranata", 31, "Bukan tanaman jenis sabu (Metamfetamina)",
                23.471, "Pasal 112 ayat (2) jo. Pasal 132 ayat (1) UU No. 35 Tahun 2009",
                "Kurir dan penguasa Narkotika", 84, 4000000000.0,
                "Hakim Ketua: Ferdinand Marcus Leander, S.H., M.H. Hakim Anggota: Ni Putu Sri Indayani, S.H., M.H. dan Toniwidjaya Hansberd Hilly, S.H."));


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