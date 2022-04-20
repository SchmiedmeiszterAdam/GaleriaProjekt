package modell;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Festmeny extends KiallitasiTargy implements Serializable{

    private String eleresiUt;

    public Festmeny(String keszito, String cim, Date letrehozas) throws RosszDatumException {
        super(keszito, cim, letrehozas);
    }

    public Festmeny(String keszito, String cim) throws RosszDatumException {
        super(keszito, cim);
    }

    public Festmeny(String keszito, String cim, String eleresiUt) throws RosszDatumException {
        super(keszito, cim);
        this.eleresiUt = eleresiUt;
    }

    public Festmeny(String keszito, String cim, String eleresiUt, Date letrehozas) throws RosszDatumException {
        super(keszito, cim, letrehozas);
        this.eleresiUt = eleresiUt;
    }

    public void megjelenito() {
        Path path = Paths.get(this.eleresiUt);
        if (Files.exists(path)) {
            System.out.println("Megjelenítés folyamatban...");
        } else {
            System.out.println("Nem lehet megjeleníteni");
        }
    }

    @Override
    public int compareTo(KiallitasiTargy o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + "Festmeny{" + "eleresiUt=" + eleresiUt + '}';
    }

}
