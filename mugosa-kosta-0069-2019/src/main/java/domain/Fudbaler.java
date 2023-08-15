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
public class Fudbaler extends AbstractDomainObject {

    private Long fudbalerID;
    private String imeFudbalera;
    private String prezimeFudbalera;
    private int godine;

    @Override
    public String toString() {
        return imeFudbalera + " " + prezimeFudbalera;
    }

    public Fudbaler(Long fudbalerID, String imeFudbalera, String prezimeFudbalera, int godine) {
        this.fudbalerID = fudbalerID;
        this.imeFudbalera = imeFudbalera;
        this.prezimeFudbalera = prezimeFudbalera;
        this.godine = godine;
    }

    public Fudbaler() {
    }

    @Override
    public String nazivTabele() {
        return " Fudbaler ";
    }

    @Override
    public String alijas() {
        return " f ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Fudbaler f = new Fudbaler(rs.getLong("FudbalerID"),
                    rs.getString("ImeFudbalera"), rs.getString("PrezimeFudbalera"),
                    rs.getInt("godine"));

            lista.add(f);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "  ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " FudbalerID = " + fudbalerID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "  ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getFudbalerID() {
        return fudbalerID;
    }

    public void setFudbalerID(Long fudbalerID) {
        this.fudbalerID = fudbalerID;
    }

    public String getImeFudbalera() {
        return imeFudbalera;
    }

    public void setImeFudbalera(String imeFudbalera) {
        this.imeFudbalera = imeFudbalera;
    }

    public String getPrezimeFudbalera() {
        return prezimeFudbalera;
    }

    public void setPrezimeFudbalera(String prezimeFudbalera) {
        this.prezimeFudbalera = prezimeFudbalera;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

}
