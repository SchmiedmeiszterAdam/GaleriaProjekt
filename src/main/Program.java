package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import modell.CimComparator;
import modell.Festmeny;
import modell.Galeria;
import modell.KeszitoComparator;
import modell.KiallitasiTargy;
import modell.RosszDatumException;

public class Program {

    public static void main(String[] args) throws RosszDatumException {
        Calendar c = Calendar.getInstance();
        Calendar rosszDatum = Calendar.getInstance();
        rosszDatum.set(2040, 10, 20);
        Galeria galeria = new Galeria();
        
        Festmeny f1 = new Festmeny("Készítő1", "Cím1");
        Festmeny f2 = new Festmeny("Készítő2", "Cím2", c.getTime());
        //Festmeny f3 = new Festmeny("Készítő3", "Cím3", rosszDatum.getTime());
        Festmeny f4 = new Festmeny("Készítő4", "Cím4", "kep.txt");
        Festmeny f5 = new Festmeny("Készítő5", "Cím5", "kep.txt", c.getTime());
        
        galeria.kiallitasiTargyFelvetel(f1);
        galeria.kiallitasiTargyFelvetel(f2);
        //galeria.kiallitasiTargyFelvetel(f3);
        galeria.kiallitasiTargyFelvetel(f4);
        galeria.kiallitasiTargyFelvetel(f5);

        ArrayList<KiallitasiTargy> cimszerintiLista = galeria.getKiallitasiTargyak();
        System.out.println("Cím szerinti rendezés");
        Collections.sort(cimszerintiLista, new CimComparator());
        for (KiallitasiTargy kiallitasiTargy : cimszerintiLista) {
            System.out.println(kiallitasiTargy);
        }
        
        ArrayList<KiallitasiTargy> keszitoszerintiLista = galeria.getKiallitasiTargyak();
        System.out.println("\nKészítő szerinti rendezés:");
        Collections.sort(keszitoszerintiLista, new KeszitoComparator());
        for (KiallitasiTargy kiallitasiTargy : keszitoszerintiLista) {
            System.out.println(kiallitasiTargy);
        }
        
        f5.megjelenito();
        f4.megjelenito();
        
    }

}
