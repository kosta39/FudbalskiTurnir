/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kosta
 */
public class Tim extends AbstractDomainObject {
    
    private Long timID;
    private String nazivTima;
    private ArrayList<Igrac> igraci;

    @Override
    public String toString() {
        return nazivTima;
    }

    public Tim(Long timID, String nazivTima, ArrayList<Igrac> igraci) {
        this.timID = timID;
        this.nazivTima = nazivTima;
        this.igraci = igraci;
    }

    public Tim() {
    }
    
    @Override
    public String nazivTabele() {
        return " Tim ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Tim t = new Tim(rs.getLong("TimID"), rs.getString("NazivTima"), null);

            lista.add(t);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivTima) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TimID = " + timID;
    }

    @Override
    public String vrednostiZaInsert() {
        return " '" + nazivTima + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivTima = '" + nazivTima + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getTimID() {
        return timID;
    }

    public void setTimID(Long timID) {
        this.timID = timID;
    }

    public String getNazivTima() {
        return nazivTima;
    }

    public void setNazivTima(String nazivTima) {
        this.nazivTima = nazivTima;
    }

    public ArrayList<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(ArrayList<Igrac> igraci) {
        this.igraci = igraci;
    }
    
}
