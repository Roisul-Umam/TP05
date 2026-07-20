import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tulis unit test kalian di sini. Minimal satu happy path + satu edge case
 * per method wajib (lihat TP5.docx bagian Sub-Task 1, 2, dan 3).
 *
 * Contoh satu test happy path sudah disediakan sebagai referensi format --
 * silakan hapus/ganti sesuai kebutuhan.
 */
public class TournamentManagerTest {

    @Test
    void totalGol_menjumlahkanSeluruhGolSatuTim() {
        Tim[] tim = { new TimFakultas("Tim Contoh") };
        TournamentManager manager = new TournamentManager(tim);

        // TODO: isi golPertandingan lewat cara yang kalian sediakan
        // (misalnya lewat constructor lain, setter, atau muatDataGol()),
        // lalu assert hasil totalGol() sesuai ekspektasi.

        // assertEquals(9, manager.totalGol(0));
    }

    // TODO: totalGolTurnamen() -- happy path + pastikan memanggil totalGol()
    // TODO: pertandinganTerbaik() -- happy path + tim dengan 0 pertandingan -> -1
    // TODO: rataRataGol() -- happy path (pembulatan ke bawah) + tim dengan 0 pertandingan -> 0
    // TODO: timGolTerbanyak() -- happy path + kasus seri -> index terkecil
    // TODO: totalBiayaPendaftaran() -- campuran TimFakultas & TimUndangan
    // TODO: muatDataGol() -- baca file kecil contoh, verifikasi isi golPertandingan
}
