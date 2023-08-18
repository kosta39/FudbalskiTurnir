package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju koja se koristi za ucitavanje postojecih administratora
 * iz baze podataka. Implementira apstraktne metode klase AbstractSO koju nasledjuje
 * 
 * @author Kosta
 */
public class SOGetAllAdministrator extends AbstractSO {
	/**
	 * Lista svih administratora u bazi
	 */
    private ArrayList<Administrator> lista;
    /**
     * Vrsi se validacija za instancu objekta
     * @throws Exception ukoliko prosledjeni objekat nije instanca klase Administrator
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi SELECT upit i rezultat smjesta u
     * listu koja sadrzi sve administratore.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> administratori = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Administrator>) (ArrayList<?>) administratori;
    }
    /**
     * Vraca listu sa postojecim administratorima.
     * @return lista sa postojecim administratorima.
     */
    public ArrayList<Administrator> getLista() {
        return lista;
    }

}
