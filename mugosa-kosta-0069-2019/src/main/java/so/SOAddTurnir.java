package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Turnir;
import domain.Utakmica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import so.AbstractSO;

/**
 * Sistemska operacija koja sluzi za dodavanje novog turnira u bazu, sto sa sobom
 * povlaci i dodavanje svih utakmica turnira. Nasledjuje apstraktnu klasu AbstractSO
 * pa samim tim i implementira njene apstraktne metode.
 * 
 * @author Kosta
 */
public class SOAddTurnir extends AbstractSO {
	/**
	 * Vrsi validaciju za pet postavljenih uslova.
	 * @throws Exception ukoliko prosledjeni objekat nije instanca klase Turnir,
	 * 					ukoliko je broj utakmica na turniru manji od dva ili veci od deset,
	 * 					ukoliko je datum pocetka turnira neki datum posle danasnjeg,
	 * 					ukoliko je datum pocetka turnira neki datum posle datuma zavrsetka turnira,
	 * 					ukoliko je datum zavrsetka turnira neki datum posle danasnjeg.
	 */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Turnir!");
        }

        Turnir t = (Turnir) ado;

        if (t.getUtakmice().size() < 2 || t.getUtakmice().size() > 10) {
            throw new Exception("Turnir mora imati izmedju 2 i 10 utakmica!");
        }

        if (!t.getDatumOd().before(new Date())) {
            throw new Exception("Datum od mora biti pre danasnjeg datuma!");
        }

        if (!t.getDatumOd().before(t.getDatumDo())) {
            throw new Exception("Datum od mora biti pre datuma do!");
        }

        if (!t.getDatumDo().before(new Date())) {
            throw new Exception("Datum do mora biti pre danasnjeg datuma!");
        }

    }
    /**
     * Poziva se broker baze podataka koji vrsi INSERT upit i koristeci generisane kljuceve
     * se u bazu dodaje turnir.
     * 
     * S obzirom da je Utakmica slab objekat klase Turnir, poziva se INSERT upit za sve utakmice turnira,
     * koje se takodje dodaju u bazu podataka.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long turnirID = tableKeys.getLong(1);

        Turnir t = (Turnir) ado;
        t.setTurnirID(turnirID);

        for (Utakmica utakmica : t.getUtakmice()) {
            utakmica.setTurnir(t);
            DBBroker.getInstance().insert(utakmica);
        }

    }

}
