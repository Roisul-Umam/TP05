import java.io.IOException;

/**
 * Mengelola data turnamen BurhanCup: daftar tim (polymorphic) dan gol
 * tiap pertandingan (ragged array, sejajar index dengan daftarTim).
 */
public class TurnamenManager {
    private Tim[] daftarTim;          // polymorphic: TimFakultas / TimUndangan
    private int[][] golPertandingan;  // ragged: golPertandingan[i].length beda tiap tim

    public TurnamenManager(Tim[] daftarTim) {
        this.daftarTim = daftarTim;
        // Belum ada data pertandingan sampai muatDataGol() dipanggil.
        this.golPertandingan = new int[daftarTim.length][0];
    }

    public Tim[] getDaftarTim() {
        return daftarTim;
    }

    public int[][] getGolPertandingan() {
        return golPertandingan;
    }

    /** Total gol satu tim di seluruh pertandingannya. */
    public int totalGol(int timIndex) {
        // TODO Sub-Task 1: jumlahkan seluruh isi golPertandingan[timIndex].
        int total = 0; //Akumulator total gol
        for (int i = 0; i < golPertandingan[timIndex].length; i++) {
            total += golPertandingan[timIndex][i]; //Menambahkan gol dari setiap pertandingan ke total
        }
        return total;
    }

    /** Total gol seluruh tim di turnamen. Wajib memanggil totalGol(). */
    public int totalGolTurnamen() {
        // TODO Sub-Task 1: jumlahkan totalGol(i) untuk seluruh tim.
        int total = 0; //Akumulator total gol seluruh tim
        for (int i = 0; i < golPertandingan.length; i++) {
            total += totalGol(i);
        }
        return total;
    }

    /** Index pertandingan dengan gol terbanyak milik satu tim. -1 jika belum pernah main. */
    public int pertandinganTerbaik(int timIndex) {
        // TODO Sub-Task 1: cari index gol terbesar pada golPertandingan[timIndex].
        int maxIndex = -1; //Inisialisasi index pertandingan terbaik
        int maxGol = -1; //Inisialisasi jumlah gol terbanyak
        for (int i = 0; i < golPertandingan[timIndex].length; i++) {
            if (golPertandingan[timIndex][i] > maxGol) {
                maxGol = golPertandingan[timIndex][i]; //Update jumlah gol terbanyak
                maxIndex = i; //Update index pertandingan terbaik
            }
        }
        return maxIndex;
    }

    /** Rata-rata gol per pertandingan satu tim (dibulatkan ke bawah). 0 jika belum pernah main. */
    public int rataRataGol(int timIndex) {
        // TODO Sub-Task 1: totalGol(timIndex) dibagi jumlah pertandingan tim tsb.
        int totalGol = totalGol(timIndex); //Menghitung total gol tim
        int jumlahPertandingan = golPertandingan[timIndex].length; //Menghitung jumlah pertandingan tim
        if (jumlahPertandingan > 0) {
            return totalGol / jumlahPertandingan; //Menghitung rata-rata gol per pertandingan
        }
        return 0; //Jika tim belum pernah main, rata-rata gol adalah 0
    }

    /** Index tim dengan total gol tertinggi se-turnamen. Seri -> index terkecil. */
    public int timGolTerbanyak() {
        // TODO Sub-Task 1: bandingkan totalGol(i) untuk seluruh tim.
        int maxIndex = -1; //Inisialisasi index tim dengan gol terbanyak
        int maxGol = -1; //Inisialisasi jumlah gol terbanyak
        for (int i = 0; i < daftarTim.length; i++) {
            int totalGolTim = totalGol(i); //Menghitung total gol tim ke-i
            if (totalGolTim > maxGol) {
                maxGol = totalGolTim; //Update jumlah gol terbanyak
                maxIndex = i; //Update index tim dengan gol terbanyak
            }
        }
        return maxIndex;
    }

    /** Total biaya pendaftaran seluruh tim (wajib panggil getBiayaPendaftaran(), no instanceof). */
    public int totalBiayaPendaftaran() {
        // TODO Sub-Task 2: jumlahkan getBiayaPendaftaran() milik tiap objek Tim.
        int totalBiaya = 0; //Akumulator total biaya pendaftaran
        for (Tim daftarTim1 : daftarTim) {
            totalBiaya += daftarTim1.getBiayaPendaftaran(); //Menambahkan biaya pendaftaran tim ke total
        }
        return totalBiaya;
    }

    /**
     * Membaca file teks berisi data gol (satu baris per tim, sejajar urutan
     * daftarTim, dipisah koma; baris kosong = tim belum pernah bertanding)
     * lalu mengisi ulang golPertandingan.
     */
    public void muatDataGol(String namaFile) throws IOException {
        // TODO Sub-Task 3: baca file dengan try-with-resources (BufferedReader/Scanner),
        // parse tiap baris jadi int[], lalu timpa golPertandingan dengan hasilnya.
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(namaFile))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < daftarTim.length) {
                if (line.trim().isEmpty()) {
                    golPertandingan[index] = new int[0]; // Tim belum pernah bertanding
                } else {
                    String[] parts = line.split(",");
                    int[] golArray = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        golArray[i] = Integer.parseInt(parts[i].trim()); // Parse gol dari string ke int
                    }
                    golPertandingan[index] = golArray; // Simpan gol pertandingan untuk tim ini
                }
                index++;
            }
        }
    }
}
