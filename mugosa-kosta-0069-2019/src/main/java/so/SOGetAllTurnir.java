package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Turnir;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *Predstavlja sistemsku operaciju koja se koristi za ucitavanje postojecih turnira
 * iz baze podataka. Implementira apstraktne metode klase AbstractSO koju nasledjuje
 * @author Kosta
 */
public class SOGetAllTurnir extends AbstractSO {
	/**
	 * Lista svih turnira u bazi.
	 */
    private ArrayList<Turnir> lista;
    /**
     * Vrsi se validacija za instancu objekta
     * @throws Exception ukoliko prosledjeni objekat nije instanca klase Turnir
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Turnir!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi SELECT upit i rezultat smjesta u
     * listu koja sadrzi sve turnire.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> turniri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Turnir>) (ArrayList<?>) turniri;
    }
    /**
     * Vraca listu sa postojecim turnirima.
     * @return lista sa postojecim turnirima.
     */
    public ArrayList<Turnir> getLista() {
        return lista;
    }

}
