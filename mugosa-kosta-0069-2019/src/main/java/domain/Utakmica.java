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
public class Utakmica extends AbstractDomainObject {

    private Turnir turnir;
    private int rbUtakmice;
    private int brojGolovaPrvi;
    private int brojGolovaDrugi;
    private String pobednik;
    private Tim prviTim;
    private Tim drugiTim;

    public Utakmica(Turnir turnir, int rbUtakmice, int brojGolovaPrvi, int brojGolovaDrugi, String pobednik, Tim prviTim, Tim drugiTim) {
        this.turnir = turnir;
        this.rbUtakmice = rbUtakmice;
        this.brojGolovaPrvi = brojGolovaPrvi;
        this.brojGolovaDrugi = brojGolovaDrugi;
        this.pobednik = pobednik;
        this.prviTim = prviTim;
        this.drugiTim = drugiTim;
    }

    public Utakmica() {
    }

    @Override
    public String nazivTabele() {
        return " Utakmica ";
    }

    @Override
    public String alijas() {
        return " u ";
    }

    @Override
    public String join() {
        return " JOIN TURNIR TUR USING (TURNIRID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = TUR.ADMINISTRATORID) "
                + "JOIN TIM PRVITIM ON (PRVITIM.TIMID = U.PRVITIMID) "
                + "JOIN TIM DRUGITIM ON (DRUGITIM.TIMID = U.DRUGITIMID)";
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

            Tim prviTim = new Tim(rs.getLong("prviTim.TimID"), rs.getString("prviTim.NazivTima"), null);

            Tim drugiTim = new Tim(rs.getLong("drugiTim.TimID"), rs.getString("drugiTim.NazivTima"), null);

            Utakmica u = new Utakmica(t, rs.getInt("rbUtakmice"),
                    rs.getInt("brojGolovaPrvi"), rs.getInt("brojGolovaDrugi"),
                    rs.getString("pobednik"), prviTim, drugiTim);

            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (turnirID, rbUtakmice, brojGolovaPrvi, brojGolovaDrugi, pobednik, "
                + "prviTimID, drugiTimID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " turnirID = " + turnir.getTurnirID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + turnir.getTurnirID() + ", " + rbUtakmice + ", "
                + brojGolovaPrvi + ", " + brojGolovaDrugi + ", '" + pobednik
                + "', " + prviTim.getTimID() + ", " + drugiTim.getTimID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE TUR.TURNIRID = " + turnir.getTurnirID();
    }

    public Turnir getTurnir() {
        return turnir;
    }

    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }

    public int getRbUtakmice() {
        return rbUtakmice;
    }

    public void setRbUtakmice(int rbUtakmice) {
        this.rbUtakmice = rbUtakmice;
    }

    public int getBrojGolovaPrvi() {
        return brojGolovaPrvi;
    }

    public void setBrojGolovaPrvi(int brojGolovaPrvi) {
        this.brojGolovaPrvi = brojGolovaPrvi;
    }

    public int getBrojGolovaDrugi() {
        return brojGolovaDrugi;
    }

    public void setBrojGolovaDrugi(int brojGolovaDrugi) {
        this.brojGolovaDrugi = brojGolovaDrugi;
    }

    public String getPobednik() {
        return pobednik;
    }

    public void setPobednik(String pobednik) {
        this.pobednik = pobednik;
    }

    public Tim getPrviTim() {
        return prviTim;
    }

    public void setPrviTim(Tim prviTim) {
        this.prviTim = prviTim;
    }

    public Tim getDrugiTim() {
        return drugiTim;
    }

    public void setDrugiTim(Tim drugiTim) {
        this.drugiTim = drugiTim;
    }

}
