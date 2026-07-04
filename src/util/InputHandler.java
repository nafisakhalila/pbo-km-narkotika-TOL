package util;
import java.util.Scanner;
/**helper ini buat validasi input, biar ga gampang crash kalo user salah ketik
dipake di hampir semua menu progam ini.
 */
public class InputHandler {
    //minta input angka bulat, ulang terus kalo salah format
    public static int validasilnt(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka bulat. Coba lagi.");
            }
        }
    }
    public static double validasiDouble(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            }catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
            }
        }
    }
    public static String validasiString(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String input=sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Coba lagi.");
                continue;
            }

            return input;
        }
    }
    /**disini buat validasi pilihan menu (misal 1-5), manggil validasilnt di dalemnya*/
    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
        int pilihan;
        while (true) {
            pilihan = validasilnt(prompt, sc);
            if (pilihan < min || pilihan > max) {
                System.out.println("Pilihan harus antara" + min + "-" + max +". Coba lagi.");
                continue;
            }
            break;
        }
        return pilihan;
    }
}
