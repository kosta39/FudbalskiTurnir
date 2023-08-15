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
import so.AbstractSO;

/**
 *
 * @author Kosta
 */
public class SOGetAllFudbaler extends AbstractSO {

    private ArrayList<Fudbaler> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Fudbaler)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Fudbaler!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> fudbaleri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Fudbaler>) (ArrayList<?>) fudbaleri;
    }

    public ArrayList<Fudbaler> getLista() {
        return lista;
    }

}
