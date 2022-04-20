package modell;

import java.text.Collator;
import java.util.Comparator;


public class CimComparator implements Comparator<KiallitasiTargy>{

   @Override
    public int compare(KiallitasiTargy o1,KiallitasiTargy o2) {
        Collator c = Collator.getInstance();
        return c.compare(o1.getCim(),(o2.getCim()));
    }
    
}
