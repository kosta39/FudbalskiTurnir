package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Turnir;
import so.AbstractSO;

/**
 *Sistemska operacija koja sluzi za brisanje postojeceg turnira iz baze. Nasledjuje apstraktnu
 *klasu AbstractSO pa samim tim i implementira njene apstraktne metode.
 *
 * @author Kosta
 */
public class SODeleteTurnir extends AbstractSO {
	/**
	 * Vrsi validaciju za instancu objekta.
	 * @throws Exception ukoliko prosledjeni objekat nije instanca klase Turnir
	 */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Turnir!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi DELETE upit kojim se brise prosledjeni
     * objekat turnira iz baze.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
