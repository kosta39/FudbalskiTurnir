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
public class Igrac extends AbstractDomainObject {

    private Tim tim;
    private int brojNaDresu;
    private String pozicija;
    private Fudbaler fudbaler;

    public Igrac(Tim tim, int brojNaDresu, String pozicija, Fudbaler fudbaler) {
        this.tim = tim;
        this.brojNaDresu = brojNaDresu;
        this.pozicija = pozicija;
        this.fudbaler = fudbaler;
    }

    public Igrac() {
    }

    @Override
    public String nazivTabele() {
        return " Igrac ";
    }

    @Override
    public String alijas() {
        return " i ";
    }

    @Override
    public String join() {
        return "JOIN TIM T ON (T.TIMID = I.TIMID) "
                + "JOIN FUDBALER F ON (F.FUDBALERID = I.FUDBALERID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Tim t = new Tim(rs.getLong("TimID"),
                    rs.getString("NazivTima"), null);

            Fudbaler f = new Fudbaler(rs.getLong("FudbalerID"),
                    rs.getString("ImeFudbalera"), rs.getString("PrezimeFudbalera"),
                    rs.getInt("godine"));

            Igrac i = new Igrac(t, rs.getInt("brojNaDresu"), rs.getString("pozicija"), f);

            lista.add(i);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (TimID, brojNaDresu, pozicija, FudbalerID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TimID = " + tim.getTimID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + tim.getTimID() + ", " + brojNaDresu + ", "
                + "'" + pozicija + "', " + fudbaler.getFudbalerID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE T.TIMID = " + tim.getTimID();
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public int getBrojNaDresu() {
        return brojNaDresu;
    }

    public void setBrojNaDresu(int brojNaDresu) {
        this.brojNaDresu = brojNaDresu;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public Fudbaler getFudbaler() {
        return fudbaler;
    }

    public void setFudbaler(Fudbaler fudbaler) {
        this.fudbaler = fudbaler;
    }

}
