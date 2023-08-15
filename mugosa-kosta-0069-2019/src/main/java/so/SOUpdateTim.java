/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Igrac;
import domain.Tim;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Kosta
 */
public class SOUpdateTim extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }

        Tim t = (Tim) ado;

        ArrayList<Tim> timovi = (ArrayList<Tim>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Tim postojeciTim : timovi) {
            if (!postojeciTim.getTimID().equals(t.getTimID())) {
                if (postojeciTim.getNazivTima().equals(t.getNazivTima())) {
                    throw new Exception("Vec postoji tim s tim nazivom!");
                }
            }
        }
        
        if (t.getIgraci().size() < 5 || t.getIgraci().size() > 10) {
            throw new Exception("Tim mora da ima izmedju 5 i 10 igraca!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        DBBroker.getInstance().update(ado);
        
        Tim t = (Tim) ado;
        Igrac i = t.getIgraci().get(0);
        DBBroker.getInstance().delete(i);
        
        for (Igrac igrac : t.getIgraci()) {
            DBBroker.getInstance().insert(igrac);
        }
        
    }

}
