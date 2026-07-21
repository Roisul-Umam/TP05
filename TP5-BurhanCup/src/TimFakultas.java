/**
 * Tim resmi perwakilan fakultas. Tidak dikenakan biaya pendaftaran.
 */
public class TimFakultas extends Tim {

    // TODO Sub-Task 2: tambahkan constant biaya pendaftaran (selalu 0 untuk semua instance).
    private static final int BIAYA_PENDAFTARAN = 0;
    public TimFakultas(String namaTim) {
        super(namaTim);
        // TODO Sub-Task 2: lengkapi jika diperlukan.
    
    }

    @Override
    public int getBiayaPendaftaran() {
        // TODO Sub-Task 2: kembalikan biaya pendaftaran tim fakultas (selalu 0).
        return BIAYA_PENDAFTARAN;
    }
}
