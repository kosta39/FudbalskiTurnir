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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Kosta
 */
public class SOAddTim extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }

        Tim t = (Tim) ado;

        ArrayList<Tim> timovi = (ArrayList<Tim>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Tim postojeciTim : timovi) {
            if (postojeciTim.getNazivTima().equals(t.getNazivTima())) {
                throw new Exception("Vec postoji tim s tim nazivom!");
            }
        }

        if (t.getIgraci().size() < 5 || t.getIgraci().size() > 10) {
            throw new Exception("Tim mora da ima izmedju 5 i 10 igraca!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long timID = tableKeys.getLong(1);

        Tim t = (Tim) ado;
        t.setTimID(timID);

        for (Igrac igrac : t.getIgraci()) {
            igrac.setTim(t);
            DBBroker.getInstance().insert(igrac);
        }

    }

}
