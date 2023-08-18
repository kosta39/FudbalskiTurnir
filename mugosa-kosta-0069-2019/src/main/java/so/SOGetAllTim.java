package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Tim;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *Predstavlja sistemsku operaciju koja se koristi za ucitavanje postojecih timova
 * iz baze podataka. Implementira apstraktne metode klase AbstractSO koju nasledjuje
 * @author Kosta
 */
public class SOGetAllTim extends AbstractSO {
	/**
	 * Lista svih timova u bazi.
	 */
    private ArrayList<Tim> lista;
    /**
     * Vrsi se validacija za instancu objekta
     * @throws Exception ukoliko prosledjeni objekat nije instanca klase Tim
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi SELECT upit i rezultat smjesta u
     * listu koja sadrzi sve timove.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> timovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Tim>) (ArrayList<?>) timovi;
    }
    /**
     * Vraca listu sa postojecim timovima.
     * @return lista sa postojecim timovima.
     */
    public ArrayList<Tim> getLista() {
        return lista;
    }

}
