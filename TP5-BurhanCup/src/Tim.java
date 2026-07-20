/**
 * Kelas dasar (abstract) untuk semua jenis tim yang mengikuti BurhanCup.
 * Tidak boleh diinstansiasi langsung -- selalu lewat subclass.
 */
public abstract class Tim {
    protected String namaTim;

    public Tim(String namaTim) {
        this.namaTim = namaTim;
    }

    public String getNamaTim() {
        return namaTim;
    }

    /**
     * Biaya pendaftaran tim ini ke turnamen.
     * Beda tiap jenis tim -- wajib di-override oleh subclass.
     */
    public abstract int getBiayaPendaftaran();
}
