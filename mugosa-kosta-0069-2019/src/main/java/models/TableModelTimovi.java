/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.Tim;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllTim;

/**
 *
 * @author Kosta
 */
public class TableModelTimovi extends AbstractTableModel implements Runnable {

    private ArrayList<Tim> lista;
    private String[] kolone = {"ID", "Naziv"};
    private String parametar = "";

    public TableModelTimovi() {
        try {
            SOGetAllTim so=new SOGetAllTim();
            so.templateExecute(new Tim());
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTimovi.class.getName()).log(Level.SEVERE, null, ex);
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
        Tim t = lista.get(row);

        switch (column) {
            case 0:
                return t.getTimID();
            case 1:
                return t.getNazivTima();

            default:
                return null;
        }
    }

    public Tim getSelectedTim(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTimovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            SOGetAllTim so=new SOGetAllTim();
            so.templateExecute(new Tim());
            lista = so.getLista();
            if (!parametar.equals("")) {
                ArrayList<Tim> novaLista = new ArrayList<>();
                for (Tim t : lista) {
                    if (t.getNazivTima().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
