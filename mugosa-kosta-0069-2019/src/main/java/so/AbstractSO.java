package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import java.sql.SQLException;

/**
 * Predstavlja apstraktnu klasu koju nasledjuju sve klase sistemskih operacija.
 * 
 * Sadrzi pet apstraktnih metoda od cega se dvije odnose na samo izvrsavanje i validaciju
 * sistemskih operacija, dvije sluze da se potvrdi ili ponisti odredjena transakcija, a poslednja
 * poziva sve ostale metode i objedinjuje ih.
 * 
 * @author Kosta
 */
public abstract class AbstractSO {
    /**
     * Sluzi za validaciju unijetih podataka.
     * 
     * Za svaku sistemsku operaciju je drugacije napisana, pa samim tim je i
     * drugacije implementirana u svakoj od klasa koje nasledjuju
     * @param ado predstavlja domenski objekat koji sadrzi podatke nad kojima se vrsi sama validacija
     * @throws Exception ukoliko dodje do greske prilikom validacije
     */
    protected abstract void validate(AbstractDomainObject ado) throws Exception;
    /**
     * Sluzi za pokretanje sistemskih operacija.
     * 
     * Kod nje se poziva broker baze koji izvrsava odredjene upite.
     * 
     * Za svaku sistemsku operaciju je drugacije napisana, pa samim tim je i
     * drugacije implementirana u svakoj od klasa koje nasledjuju
     * @param ado predstavlja domenski objekat koji sadrzi podatke pomocu kojih se izvrsavaju sistemske operacije
     * @throws Exception ukoliko dodje do greske prilikom izvrsavanja sistemske operacije
     */
    protected abstract void execute(AbstractDomainObject ado) throws Exception;
    /**
     * Koristi se za poziv ostalih metoda ove klase i objedinjuje ih u cjelinu
     * @param ado predstavlja domenski objekat koji sadrzi podatke pomocu kojih se izvrsavaju ostale metode klase
     * @throws Exception ukoliko dodje do greske u nekoj od faza izvrsenja ostalih metoda klase
     */
    public void templateExecute(AbstractDomainObject ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }
    /**
     * Potvrdjuje transakciju koja je rezultat izvrsenja sistemske operacije
     * @throws SQLException ukoliko dodje do greske prilikom potvrdjivanja transakcije
     */
    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }
    /**
     * Ponistava transakciju koja je rezultat izvrsenja sistemske operacije
     * @throws SQLException ukoliko dodje do greske prilikom ponistavanja transakcije
     */
    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
