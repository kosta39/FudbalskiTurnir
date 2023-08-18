/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Tim;
import so.AbstractSO;

/**
 *Sistemska operacija koja sluzi za brisanje postojeceg tima iz baze. Nasledjuje apstraktnu
 *klasu AbstractSO pa samim tim i implementira njene apstraktne metode.
 *
 * @author Kosta
 */
public class SODeleteTim extends AbstractSO {
	/**
	 * Vrsi validaciju za instancu objekta.
	 * @throws Exception ukoliko prosledjeni objekat nije instanca klase Tim.
	 */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi DELETE upit kojim se brise prosledjeni
     * objekat tima iz baze.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
