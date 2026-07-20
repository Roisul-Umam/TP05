/**
 * Tim undangan (alumni / kampus tetangga). Biaya pendaftaran ditentukan
 * saat tim didaftarkan dan boleh berbeda antar tim.
 */
public class TimUndangan extends Tim {

    // TODO Sub-Task 2: tambahkan field biayaPendaftaran (beda-beda tiap objek).

    public TimUndangan(String namaTim, int biayaPendaftaran) {
        super(namaTim);
        // TODO Sub-Task 2: simpan biayaPendaftaran ke field.
    }

    @Override
    public int getBiayaPendaftaran() {
        // TODO Sub-Task 2: kembalikan biaya pendaftaran tim ini.
        return 0;
    }
}
