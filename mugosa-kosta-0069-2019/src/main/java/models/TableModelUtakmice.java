/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.Turnir;
import domain.Utakmica;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllUtakmica;

/**
 *
 * @author Kosta
 */
public class TableModelUtakmice extends AbstractTableModel {

    private ArrayList<Utakmica> lista;
    private String[] kolone = {"Prvi tim", "Drugi tim", "Broj golova prvog", "Broj golova drugog",
        "Pobednik"};
    private int rb = 0;

    public TableModelUtakmice() {
        lista = new ArrayList<>();
    }

    public TableModelUtakmice(Turnir t) {
        try {
            SOGetAllUtakmica so=new SOGetAllUtakmica();
            Utakmica u=new Utakmica();
            u.setTurnir(t);
            so.templateExecute(u);
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelUtakmice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Utakmica u = lista.get(row);

        switch (column) {
            case 0:
                return u.getPrviTim();
            case 1:
                return u.getDrugiTim();
            case 2:
                return u.getBrojGolovaPrvi();
            case 3:
                return u.getBrojGolovaDrugi();
            case 4:
                return u.getPobednik();

            default:
                return null;
        }
    }

    public void dodajUtakmicu(Utakmica u) {
        rb = lista.size();
        u.setRbUtakmice(++rb);
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisiUtakmicu(int row) {
        lista.remove(row);

        rb = 0;
        for (Utakmica utakmica : lista) {
            utakmica.setRbUtakmice(++rb);
        }

        fireTableDataChanged();
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

}
