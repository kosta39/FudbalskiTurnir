package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Igrac;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *Predstavlja sistemsku operaciju koja se koristi za ucitavanje postojecih igraca
 * iz baze podataka. Implementira apstraktne metode klase AbstractSO koju nasledjuje
 * @author Kosta
 */
public class SOGetAllIgrac extends AbstractSO {
	/**
	 * Lista svih igraca u bazi
	 */
    private ArrayList<Igrac> lista;
    /**
     * Vrsi se validacija za instancu objekta
     * @throws Exception ukoliko prosledjeni objekat nije instanca klase Igrac
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Igrac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Igrac!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi SELECT upit i rezultat smjesta u
     * listu koja sadrzi sve igrace.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> igraci = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Igrac>) (ArrayList<?>) igraci;
    }
    /**
     * Vraca listu sa postojecim igracima.
     * @return lista sa postojecim igracima.
     */
    public ArrayList<Igrac> getLista() {
        return lista;
    }

}
