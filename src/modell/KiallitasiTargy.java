package modell;

import java.util.Calendar;
import java.util.Date;

public abstract class KiallitasiTargy implements Comparable<KiallitasiTargy> {

    private Date letrehozas;
    String keszito, cim;
    private static Calendar c = Calendar.getInstance();

    public KiallitasiTargy(String keszito, String cim, Date letrehozas) throws RosszDatumException {
        if (letrehozas.after(c.getTime())) {
            throw new RosszDatumException("Nem jó dátum");
        } else {
            this.letrehozas = letrehozas;
        }
        this.keszito = keszito;
        this.cim = cim;
    }

    public KiallitasiTargy(String keszito, String cim) throws RosszDatumException {
        this(keszito, cim, c.getTime());
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }

    @Override
    public String toString() {
        return "KiallitasiTargy{" + "letrehozas=" + letrehozas + ", keszito=" + keszito + ", cim=" + cim + '}';
    }

   
}
