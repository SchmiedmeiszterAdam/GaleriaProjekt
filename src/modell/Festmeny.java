package modell;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Festmeny extends KiallitasiTargy {

    private String eleresiUt;

    public Festmeny(Date letrehozas, String keszito, String cim) {
        super(letrehozas, keszito, cim);
    }

    private void megjelenito() {
        Path path = Paths.get(this.eleresiUt);
        if (Files.exists(path)) {
            System.out.println("Megjelenítés folyamatban...");
        }
        else{
            System.out.println("Nem lehet megjeleníteni");
        }
    }

    @Override
    public int compareTo(KiallitasiTargy o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
