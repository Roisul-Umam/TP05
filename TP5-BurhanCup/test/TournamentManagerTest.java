import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
/**
 * Tulis unit test kalian di sini. Minimal satu happy path + satu edge case
 * per method wajib (lihat TP5.docx bagian Sub-Task 1, 2, dan 3).
 *
 * Contoh satu test happy path sudah disediakan sebagai referensi format --
 * silakan hapus/ganti sesuai kebutuhan.
 */
public class TournamentManagerTest {

    @Test
    public void totalGol_menjumlahkanSeluruhGolSatuTim() {
        Tim[] tim = { new TimFakultas("Tim Contoh") };
        TournamentManager manager = new TournamentManager(tim);

        // TODO: isi golPertandingan lewat cara yang kalian sediakan
        
        // (misalnya lewat constructor lain, setter, atau muatDataGol()),
        // lalu assert hasil totalGol() sesuai ekspektasi.

        assertEquals(9, manager.totalGol(0));
    }

    // TODO: totalGolTurnamen() -- happy path + pastikan memanggil totalGol()
    @Test
    public void totalGolTurnamen_menjumlahkanSeluruhGolSemuaTim() {
        Tim[] tim = {
            new TimFakultas("Tim Contoh 1"),
            new TimFakultas("Tim Contoh 2")
        };
        TournamentManager manager = new TournamentManager(tim);
        assertEquals(18, manager.totalGolTurnamen());
    }
    // TODO: pertandinganTerbaik() -- happy path + tim dengan 0 pertandingan -> -1
    @Test
    public void pertandinganTerbaik_mencariIndexGolTerbanyakSatuTim() {
        Tim[] tim = { new TimFakultas("Tim Contoh") };
        TournamentManager manager = new TournamentManager(tim);
        assertEquals(2, manager.pertandinganTerbaik(0));
    }
    // TODO: rataRataGol() -- happy path (pembulatan ke bawah) + tim dengan 0 pertandingan -> 0
    @Test
    public void rataRataGol_menghitungRataRataGolSatuTim() {
        Tim[] tim = { new TimFakultas("Tim Contoh") };
        TournamentManager manager = new TournamentManager(tim);
        assertEquals(3, manager.rataRataGol(0));
    }
    // TODO: timGolTerbanyak() -- happy path + kasus seri -> index terkecil
    @Test
    public void timGolTerbanyak_mencariIndexTimDenganTotalGolTertinggi() {
        Tim[] tim = {
            new TimFakultas("Tim Contoh 1"),
            new TimFakultas("Tim Contoh 2")
        };
        TournamentManager manager = new TournamentManager(tim);
        assertEquals(0, manager.timGolTerbanyak());
    }
    // TODO: totalBiayaPendaftaran() -- campuran TimFakultas & TimUndangan
    @Test
    public void totalBiayaPendaftaran_menjumlahkanBiayaPendaftaranSemuaTim() {
        Tim[] tim = {
            new TimFakultas("Tim Contoh 1"),
            new TimUndangan("Tim Contoh 2", 100),
            new TimFakultas("Tim Contoh 3"),
            new TimUndangan("Tim Contoh 4", 200)
        };
        TournamentManager manager = new TournamentManager(tim);
        assertEquals(300, manager.totalBiayaPendaftaran());
    }
    // TODO: muatDataGol() -- baca file kecil contoh, verifikasi isi golPertandingan
    @Test
    public void muatDataGol_membacaFileDanMengisiGolPertandingan() {
        Tim[] tim = {
            new TimFakultas("Tim Contoh 1"),
            new TimFakultas("Tim Contoh 2")
        };
        TournamentManager manager = new TournamentManager(tim);
        try {
            manager.muatDataGol("gol.txt");
        } catch (IOException e) {
            fail("IOException terjadi saat membaca file: " + e.getMessage());
        }
        assertEquals(3, manager.totalGol(0));
        assertEquals(5, manager.totalGol(1));
    }
}
