package modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Galeria implements Iterable<KiallitasiTargy>, Serializable {

    ArrayList<KiallitasiTargy> kiallitasiTargyak;

    public Galeria() {
        this.kiallitasiTargyak = new ArrayList<>();
    }

    public void kiallitasiTargyFelvetel(KiallitasiTargy targy) {
        this.kiallitasiTargyak.add(targy);
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList getKiallitasiTargyak() {
        return new ArrayList(this.kiallitasiTargyak);
    }

    class KiallitasiIterator implements Iterator<KiallitasiTargy> {

        private int i;

        public KiallitasiIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < kiallitasiTargyak.size();
        }

        @Override
        public KiallitasiTargy next() {
            return kiallitasiTargyak.get(i++);
        }

    }
}
