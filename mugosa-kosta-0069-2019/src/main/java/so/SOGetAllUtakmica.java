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
 *
 * @author Kosta
 */
public class SOGetAllUtakmica extends AbstractSO {

    private ArrayList<Utakmica> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Utakmica)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Utakmica!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> utakmice = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Utakmica>) (ArrayList<?>) utakmice;
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

}
