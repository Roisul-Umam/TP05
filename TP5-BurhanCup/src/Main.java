import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // TODO Sub-Task 3: buat minimal satu TimFakultas dan dua TimUndangan
        // berbiaya pendaftaran berbeda.
        Tim[] daftarTim = {
            new TimFakultas("Fakultas Ilmu Hitam"),
            new TimUndangan("FASILKOM1945", 250000),
            new TimUndangan("Universitas Tetangga", 500000),
        };

        TurnamenManager manager = new TurnamenManager(daftarTim);

        try {
            manager.muatDataGol("data/gol.txt");
        } catch (IOException e) {
            System.out.println("Gagal membaca file gol: " + e.getMessage());
            return;
        }

        // TODO Sub-Task 3: cetak total gol tiap tim, tim dengan gol terbanyak,
        // dan total biaya pendaftaran seluruh tim ke konsol.
        for (int i = 0; i < daftarTim.length; i++) {
            System.out.println("Total gol " + daftarTim[i].getNamaTim() + ": " + manager.totalGol(i));
        }
        System.out.println("Tim dengan gol terbanyak: " + daftarTim[manager.timGolTerbanyak()].getNamaTim());
        System.out.println("Total biaya pendaftaran: " + manager.totalBiayaPendaftaran());
    }
}
