package modell;

import java.util.Calendar;
import java.util.Date;

public abstract class KiallitasiTargy implements Comparable<KiallitasiTargy> {

    private Date letrehozas;
    String keszito, cim;
    private static Calendar c = Calendar.getInstance();

    public KiallitasiTargy(Date letrehozas, String keszito, String cim) throws RosszDatumException {
        if (letrehozas.after(c.getTime())) {
            throw new RosszDatumException("Nem jó dátum");
        } else {
            this.letrehozas = letrehozas;
        }
        this.keszito = keszito;
        this.cim = cim;
    }

    public KiallitasiTargy(String keszito, String cim) throws RosszDatumException {
        this(c.getTime(), keszito, cim);
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }

}
