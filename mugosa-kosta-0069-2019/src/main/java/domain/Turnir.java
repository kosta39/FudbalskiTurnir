/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kosta
 */
public class Turnir extends AbstractDomainObject {

    private Long turnirID;
    private String nazivTurnira;
    private Date datumOd;
    private Date datumDo;
    private String grad;
    private Administrator administrator;
    private ArrayList<Utakmica> utakmice;

    public Turnir(Long turnirID, String nazivTurnira, Date datumOd, Date datumDo, String grad, Administrator administrator, ArrayList<Utakmica> utakmice) {
        this.turnirID = turnirID;
        this.nazivTurnira = nazivTurnira;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.grad = grad;
        this.administrator = administrator;
        this.utakmice = utakmice;
    }

    public Turnir() {
    }

    @Override
    public String nazivTabele() {
        return " Turnir ";
    }

    @Override
    public String alijas() {
        return " tur ";
    }

    @Override
    public String join() {
        return " JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = TUR.ADMINISTRATORID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Turnir t = new Turnir(rs.getLong("turnirID"), rs.getString("nazivTurnira"),
                    rs.getDate("datumOd"), rs.getDate("datumDo"), rs.getString("grad"), a, null);

            lista.add(t);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivTurnira, datumOd, datumDo, grad, administratorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " turnirID = " + turnirID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivTurnira + "', '" + new java.sql.Date(datumOd.getTime()) + "', "
                + "'" + new java.sql.Date(datumDo.getTime()) + "', '" + grad + "', "
                + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getTurnirID() {
        return turnirID;
    }

    public void setTurnirID(Long turnirID) {
        this.turnirID = turnirID;
    }

    public String getNazivTurnira() {
        return nazivTurnira;
    }

    public void setNazivTurnira(String nazivTurnira) {
        this.nazivTurnira = nazivTurnira;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice(ArrayList<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

}
