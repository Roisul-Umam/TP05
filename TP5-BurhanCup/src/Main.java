import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // TODO Sub-Task 3: buat minimal satu TimFakultas dan dua TimUndangan
        // berbiaya pendaftaran berbeda.
        Tim[] daftarTim = {
            // new TimFakultas("Fakultas Ilmu Komputer"),
            // new TimUndangan("Alumni FASILKOM", 250000),
            // new TimUndangan("Universitas Tetangga", 500000),
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
    }
}
