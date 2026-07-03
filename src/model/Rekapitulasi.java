package model;
/**
 * Interface buat entitas-entitas yang bisa ngehasilin rekapitulasi/ringkasan data.
 * Dipisah jadi interface sendiri (bukan digabung ke EntitasHukum) soalnya
 * konsepnya beda, ga semua EntitasHukum tentu butuh fitur rekap kayak gini,
 * jadi lebih fleksibel kalo dipisah (prinsip interface segregation).
 *
 * Class yang implement interface ini wajib nyediain cara buat:
 * 1. Ngasih ringkasan dalam bentuk teks
 * 2. Ngitung total kerugian (biasanya dari denda atau nilai kerugian lain)
 */
public interface Rekapitulasi {

    // ngembaliin ringkasan kasus dalam bentuk kalimat, biasanya dipake buat laporan
    String ringkasan();

    // ngembaliin total kerugian (dalam rupiah), tiap class bisa beda cara ngitungnya
    double getTotalKerugian();
}