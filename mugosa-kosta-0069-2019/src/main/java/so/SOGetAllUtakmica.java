/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Utakmica;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *Predstavlja sistemsku operaciju koja se koristi za ucitavanje postojecih utakmica
 * iz baze podataka. Implementira apstraktne metode klase AbstractSO koju nasledjuje
 * @author Kosta
 */
public class SOGetAllUtakmica extends AbstractSO {
	/**
	 * Lista svih utakmica u bazi
	 */
    private ArrayList<Utakmica> lista;
    /**
     * Vrsi se validacija za instancu objekta
     * @throws Exception ukoliko prosledjeni objekat nije instanca klase Utakmica
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Utakmica)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Utakmica!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi SELECT upit i rezultat smjesta u
     * listu koja sadrzi sve utakmice.
     */    
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> utakmice = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Utakmica>) (ArrayList<?>) utakmice;
    }
    /**
     * Vraca listu sa postojecim utakmicama.
     * @return lista sa postojecim utakmicama.
     */
    public ArrayList<Utakmica> getLista() {
        return lista;
    }

}
