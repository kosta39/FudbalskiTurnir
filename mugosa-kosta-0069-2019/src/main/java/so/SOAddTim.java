package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Igrac;
import domain.Tim;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *Sistemska operacija koja sluzi za dodavanje novog tima u bazu, sto sa sobom
 * povlaci i dodavanje svih igraca tima. Nasledjuje apstraktnu klasu AbstractSO
 * pa samim tim i implementira njene apstraktne metode.
 * 
 * @author Kosta
 */
public class SOAddTim extends AbstractSO {
	/**
	 * Vrsi validaciju za tri postavljena uslova.
	 * @throws Exception ukoliko prosledjeni objekat nije instanca klase Tim,
	 * 					ukoliko naziv novog tima vec postoji kao naziv nekog vec unijetog tima,
	 * 					ukoliko je broj igraca tima manji od pet ili veci od deset.
	 */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }

        Tim t = (Tim) ado;

        ArrayList<Tim> timovi = (ArrayList<Tim>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Tim postojeciTim : timovi) {
            if (postojeciTim.getNazivTima().equals(t.getNazivTima())) {
                throw new Exception("Vec postoji tim s tim nazivom!");
            }
        }

        if (t.getIgraci().size() < 5 || t.getIgraci().size() > 10) {
            throw new Exception("Tim mora da ima izmedju 5 i 10 igraca!");
        }

    }
    /**
     * Poziva se broker baze podataka koji vrsi INSERT upit i koristeci generisane kljuceve
     * se u bazu dodaje tim.
     * 
     * S obzirom da je Igrac slab objekat klase Tim, poziva se INSERT upit za sve igrace tima,
     * koji se takodje dodaju u bazu podataka.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long timID = tableKeys.getLong(1);

        Tim t = (Tim) ado;
        t.setTimID(timID);

        for (Igrac igrac : t.getIgraci()) {
            igrac.setTim(t);
            DBBroker.getInstance().insert(igrac);
        }

    }
}
