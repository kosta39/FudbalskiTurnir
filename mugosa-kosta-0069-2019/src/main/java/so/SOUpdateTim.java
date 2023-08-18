package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Igrac;
import domain.Tim;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * Sistemska operacija kojom se mijenja postojeci tim iz baze podataka, pri cemu se takodje
 * mijenjaju i njegovi igraci. Nasledjuje apstraktnu klasu AbstractSO pa samim tim
 * i implementira njene apstraktne metode.
 * 
 * @author Kosta
 */
public class SOUpdateTim extends AbstractSO {
	/**
	 * Vrsi validaciju za tri postavljena uslova.
	 * @throws Exception ukoliko prosledjeni objekat nije instanca klase Tim,
	 * 					ukoliko izmijenjeni naziv tima vec postoji kao naziv nekog vec unijetog tima,
	 * 					ukoliko je novi broj igraca tima manji od pet ili veci od deset.
	 */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }

        Tim t = (Tim) ado;

        ArrayList<Tim> timovi = (ArrayList<Tim>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Tim postojeciTim : timovi) {
            if (!postojeciTim.getTimID().equals(t.getTimID())) {
                if (postojeciTim.getNazivTima().equals(t.getNazivTima())) {
                    throw new Exception("Vec postoji tim s tim nazivom!");
                }
            }
        }
        
        if (t.getIgraci().size() < 5 || t.getIgraci().size() > 10) {
            throw new Exception("Tim mora da ima izmedju 5 i 10 igraca!");
        }

    }
    /**
     * Poziva se broker baze podataka koji vrsi UPDATE upit pomocu koga se vrsi izmjena
     * postojeceg tima iz baze podataka.
     * 
     * Radi lakse implementacije pri svakoj izmjeni tima poziva se takodje i DELETE upit
     * pomocu koga se brisu svi igraci tima, nakon cega se mijenja tim da bi se kasnije
     * pozvao INSERT upit gdje se dodaju igraci tako izmijenjenog tima.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        DBBroker.getInstance().update(ado);
        
        Tim t = (Tim) ado;
        Igrac i = t.getIgraci().get(0);
        DBBroker.getInstance().delete(i);
        
        for (Igrac igrac : t.getIgraci()) {
            DBBroker.getInstance().insert(igrac);
        }
        
    }

}
