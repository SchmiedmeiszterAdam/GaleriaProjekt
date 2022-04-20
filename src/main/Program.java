package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        System.out.println("\nÁllapotmentés");
        mentes(galeria);
        
//        System.out.println("\nBeolvasás");
//        Galeria ujGaleria = betolt();
    }

    private static void mentes(Galeria galeria) {
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("galeria.ser"))) {
            objKi.writeObject(galeria);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Galeria betolt() {
        Galeria galeria = new Galeria();
        try (ObjectInputStream objKi = new ObjectInputStream(new FileInputStream("galeria.ser"))) {
            galeria = (Galeria) objKi.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return galeria;
        }
    }

}
