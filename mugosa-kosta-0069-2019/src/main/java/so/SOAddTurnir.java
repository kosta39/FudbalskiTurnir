/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Turnir;
import domain.Utakmica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author Kosta
 */
public class SOAddTurnir extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Turnir!");
        }

        Turnir t = (Turnir) ado;

        if (t.getUtakmice().size() < 2 || t.getUtakmice().size() > 10) {
            throw new Exception("Turnir mora imati izmedju 2 i 10 utakmica!");
        }

        if (!t.getDatumOd().before(new Date())) {
            throw new Exception("Datum od mora biti pre danasnjeg datuma!");
        }

        if (!t.getDatumOd().before(t.getDatumDo())) {
            throw new Exception("Datum od mora biti pre datuma do!");
        }

        if (!t.getDatumDo().before(new Date())) {
            throw new Exception("Datum do mora biti pre danasnjeg datuma!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long turnirID = tableKeys.getLong(1);

        Turnir t = (Turnir) ado;
        t.setTurnirID(turnirID);

        for (Utakmica utakmica : t.getUtakmice()) {
            utakmica.setTurnir(t);
            DBBroker.getInstance().insert(utakmica);
        }

    }

}
