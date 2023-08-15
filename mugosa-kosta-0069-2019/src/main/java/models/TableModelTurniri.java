/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.Turnir;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllTurnir;

/**
 *
 * @author Kosta
 */
public class TableModelTurniri extends AbstractTableModel implements Runnable {

    private ArrayList<Turnir> lista;
    private String[] kolone = {"ID", "Naziv", "Grad", "Datum od", "Datum do"};
    private String parametar = "";

    public TableModelTurniri() {
        try {
            SOGetAllTurnir so=new SOGetAllTurnir();
            so.templateExecute(new Turnir());
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTurniri.class.getName()).log(Level.SEVERE, null, ex);
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
        Turnir t = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return t.getTurnirID();
            case 1:
                return t.getNazivTurnira();
            case 2:
                return t.getGrad();
            case 3:
                return sdf.format(t.getDatumOd());
            case 4:
                return sdf.format(t.getDatumDo());

            default:
                return null;
        }
    }

    public Turnir getSelectedTurnir(int row) {
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
            Logger.getLogger(TableModelTurniri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            SOGetAllTurnir so=new SOGetAllTurnir();
            so.templateExecute(new Turnir());
            lista = so.getLista();
            if (!parametar.equals("")) {
                ArrayList<Turnir> novaLista = new ArrayList<>();
                for (Turnir t : lista) {
                    if (t.getNazivTurnira().toLowerCase().contains(parametar.toLowerCase())) {
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
