/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.Igrac;
import domain.Tim;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllIgrac;

/**
 *
 * @author Kosta
 */
public class TableModelIgraci extends AbstractTableModel {

    private ArrayList<Igrac> lista;
    private String[] kolone = {"Broj na dresu", "Fudbaler", "Pozicija"};

    public TableModelIgraci() {
        lista = new ArrayList<>();
    }

    public TableModelIgraci(Tim t) {
        try {
            SOGetAllIgrac so=new SOGetAllIgrac();
            so.templateExecute(new Igrac());
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelIgraci.class.getName()).log(Level.SEVERE, null, ex);
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
        Igrac i = lista.get(row);

        switch (column) {
            case 0:
                return i.getBrojNaDresu();
            case 1:
                return i.getFudbaler();
            case 2:
                return i.getPozicija();

            default:
                return null;
        }
    }

    public void dodajIgraca(Igrac i) {
        lista.add(i);
        fireTableDataChanged();
    }

    public void obrisiIgraca(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    public boolean postojiBrojDresa(int brojNaDresu) {
        for (Igrac igrac : lista) {
            if (igrac.getBrojNaDresu() == brojNaDresu) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Igrac> getLista() {
        return lista;
    }

}
