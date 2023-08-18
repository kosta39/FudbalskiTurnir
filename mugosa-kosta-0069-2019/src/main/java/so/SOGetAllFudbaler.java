/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Fudbaler;
import java.util.ArrayList;

/**
 * Predstavlja sistemsku operaciju koja se koristi za ucitavanje postojecih fudbalera
 * iz baze podataka. Implementira apstraktne metode klase AbstractSO koju nasledjuje
 * 
 * @author Kosta
 */
public class SOGetAllFudbaler extends AbstractSO {
	/**
	 * Lista svih fudbalera u bazi
	 */
    private ArrayList<Fudbaler> lista;
    /**
     * Vrsi se validacija za instancu objekta
     * @throws Exception ukoliko prosledjeni objekat nije instanca klase Administrator
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Fudbaler)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Fudbaler!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi SELECT upit i rezultat smjesta u
     * listu koja sadrzi sve fudbalere.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> fudbaleri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Fudbaler>) (ArrayList<?>) fudbaleri;
    }
    /**
     * Vraca listu sa postojecim fudbalerima.
     * @return lista sa postojecim fudbalerima.
     */
    public ArrayList<Fudbaler> getLista() {
        return lista;
    }

}
