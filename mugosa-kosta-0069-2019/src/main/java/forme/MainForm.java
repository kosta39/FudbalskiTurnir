package forme;

import formTim.FormNoviTim;
import formTim.FormPretragaTima;
import formTurnir.FormPretragaTurnira;
import domain.Administrator;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import models.TableModelUtakmice;
import so.SOAddTurnir;
import so.SOGetAllTim;

/**
 * Ovo je glavna forma koja se automatski otvara nakon administratorove prijave na sistem.
 * Sastoji se od opcija pomocu kojih se dodaje novi turnir, ali takodje i od menija kojim se
 * prelazi na druge forme za rad sa timovima ili ostalim opcijama za turnir.
 * 
 * @author Kosta
 */
public class MainForm extends javax.swing.JFrame {
	/**
	 * Administrator koji je ulogovan i njegovo ime se prikazuje u gornjem dijelu forme.
	 */
    Administrator ulogovani;

    /**
     * Konstruktor koji sluzi za kreiranje same forme. Postavlja lokaciju same forme
     * na ekranu, postavlja naslov i inicijalizuje njene osnovne komponente.
     * 
     * @param ulogovani odnosi se na administratora koji upravlja sistemom dok je ulogovan.
     */
    public MainForm(Administrator ulogovani) {
        initComponents();
        setLocationRelativeTo(null);
        this.ulogovani = ulogovani;
        lblUlogovani.setText("Ulogovani administrator: " + ulogovani);
        setTitle("Klijentska forma");
        popuniTimove();
        tblUtakmice.setModel(new TableModelUtakmice());
    }

    /**
     * Metoda koja je napravljena od strane Form Editora sa osnovnim podesavanjima
     * i ne smije se mijenjati(inace je onemoguceno)
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblUlogovani = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNazivTurnira = new javax.swing.JTextField();
        txtDatumOd = new javax.swing.JFormattedTextField();
        txtDatumDo = new javax.swing.JFormattedTextField();
        cmbGrad = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbPrviTim = new javax.swing.JComboBox();
        cmbDrugiTim = new javax.swing.JComboBox();
        txtGoloviPrvi = new javax.swing.JFormattedTextField();
        txtGoloviDrugi = new javax.swing.JFormattedTextField();
        btnDodajTekmu = new javax.swing.JButton();
        btnObrisiTekmu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUtakmice = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        btnSerijalizuj = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        miNoviTim = new javax.swing.JMenuItem();
        miPretragaTima = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miPretragaTurnira = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miOdjava = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setText("Ulogovani");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos turnira"));

        jLabel1.setText("Naziv turnira:");

        jLabel2.setText("Datum od:");

        jLabel3.setText("Datum do:");

        jLabel4.setText("Grad:");

        txtNazivTurnira.setText("Turnir 1");

        txtDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumOd.setText("10.05.2023");

        txtDatumDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumDo.setText("19.05.2023");

        cmbGrad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Podgorica", "Beograd", "Niksic", "Budva", "Novi Sad" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos utakmica"));

        jLabel5.setText("Prvi tim:");

        jLabel6.setText("Drugi tim:");

        jLabel7.setText("Broj golova prvog tima:");

        jLabel8.setText("Broj golova drugog tima:");

        txtGoloviPrvi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtGoloviPrvi.setText("3");

        txtGoloviDrugi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtGoloviDrugi.setText("1");

        btnDodajTekmu.setText("Dodaj utakmicu");
        btnDodajTekmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajTekmuActionPerformed(evt);
            }
        });

        btnObrisiTekmu.setText("Obrisi utakmicu");
        btnObrisiTekmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiTekmuActionPerformed(evt);
            }
        });

        tblUtakmice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUtakmice);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbPrviTim, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDrugiTim, 0, 712, Short.MAX_VALUE)
                            .addComponent(txtGoloviPrvi)
                            .addComponent(txtGoloviDrugi))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDodajTekmu, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiTekmu, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbPrviTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDrugiTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGoloviPrvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGoloviDrugi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajTekmu)
                    .addComponent(btnObrisiTekmu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnSerijalizuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerijalizujActionPerformed(evt);
            }
        });

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSacuvaj.setText("Sacuvaj turnir");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnSerijalizuj.setText("Serijalizuj");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNazivTurnira)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDatumOd)
                                    .addComponent(txtDatumDo)
                                    .addComponent(cmbGrad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnSerijalizuj)
                .addGap(170, 170, 170)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNazivTurnira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnSerijalizuj))
                .addGap(12, 12, 12))
        );

        jMenu6.setText("Tim");

        miNoviTim.setText("Novi tim");
        miNoviTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviTimActionPerformed(evt);
            }
        });
        jMenu6.add(miNoviTim);

        miPretragaTima.setText("Pretraga tima");
        miPretragaTima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaTimaActionPerformed(evt);
            }
        });
        jMenu6.add(miPretragaTima);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Turnir");

        miPretragaTurnira.setText("Pretraga turnira");
        miPretragaTurnira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaTurniraActionPerformed(evt);
            }
        });
        jMenu7.add(miPretragaTurnira);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Odjava");

        miOdjava.setText("Odjavi se sa sistema");
        miOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOdjavaActionPerformed(evt);
            }
        });
        jMenu8.add(miOdjava);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUlogovani))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
    /**
     * Odnosi se na meni item u koji kada se udje ulazi se u formu za dodavanje novog tima.
     * 
     * @param evt event listener
     */
    private void miNoviTimActionPerformed(java.awt.event.ActionEvent evt) {                                          
        new FormNoviTim(this, true).setVisible(true);
    }                                         
    /**
     * Odnosi se na meni item u koji kada se udje ulazi se u formu za pretragu tima.
     * 
     * @param evt event listener
     */
    private void miPretragaTimaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        new FormPretragaTima(this, true).setVisible(true);
    }                                              
    /**
     * Odnosi se na meni item u koji kada se udje ulazi se u formu za pretragu turnira.
     * 
     * @param evt event listener
     */
    private void miPretragaTurniraActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        new FormPretragaTurnira(this, true).setVisible(true);
    }                                                 
    /**
     * Odnosi se na meni item u koji kada se udje ulazi se u dijalog za odjavu sa sistema.
     * Postavlja se pitanje da li je korisnik siguran da zeli da se odjavi i ako jeste vraca
     * se na login formu dok se main forma zatvara a ukoliko odluci da odustane od odjave vraca
     * se na main formu
     * 
     * @param evt event listener
     */
    private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {                                         

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se odjavite sa sistema?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            new LoginForma().setVisible(true);
            this.dispose();
        }

    }                                        
    /**
     * Dugme koje sluzi za dodavanje utakmice u okviru turnira. Postoje uslovi da domacin i gost
     * ne smiju da budu isti tim i ogranicenje da broj golova mora biti neki broj od 0 do 100.
     * Pobjednik se odredjuje na osnovu broja golova domacina i gosta automatski. Nakon svega ovoga
     * pravi se objekat tipa Utakmica i smjesta u tabelu za utakmice turnira.
     * 
     * @param evt event listener
     */
    private void btnDodajTekmuActionPerformed(java.awt.event.ActionEvent evt) {                                              

        Tim prviTim = (Tim) cmbPrviTim.getSelectedItem();
        Tim drugiTim = (Tim) cmbDrugiTim.getSelectedItem();
        int brojGolovaPrvi = Integer.parseInt(txtGoloviPrvi.getText());
        int brojGolovaDrugi = Integer.parseInt(txtGoloviDrugi.getText());
        String pobednik = "Nereseno";

        if (prviTim.getTimID().equals(drugiTim.getTimID())) {
            JOptionPane.showMessageDialog(this, "Prvi i drugi tim moraju biti razliciti!");
            return;
        }

        if (brojGolovaPrvi < 0 || brojGolovaDrugi < 0 || brojGolovaPrvi > 100
                || brojGolovaDrugi > 100) {
            JOptionPane.showMessageDialog(this, "Broj golova mora biti izmedju 0 i 100!");
            return;
        }

        if (brojGolovaPrvi > brojGolovaDrugi) {
            pobednik = prviTim.getNazivTima();
        }

        if (brojGolovaPrvi < brojGolovaDrugi) {
            pobednik = drugiTim.getNazivTima();
        }

        Utakmica u = new Utakmica(null, -1, brojGolovaPrvi, brojGolovaDrugi, pobednik, prviTim, drugiTim);

        TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();

        tm.dodajUtakmicu(u);


    }                                             
    /**
     * Dugme koje sluzi za brisanje utakmice iz tabele utakmica turnira. To se radi na osnovu
     * reda izabranog u tabeli.
     * 
     * @param evt event listener
     */
    private void btnObrisiTekmuActionPerformed(java.awt.event.ActionEvent evt) {                                               

        int row = tblUtakmice.getSelectedRow();
        
        if(row >= 0){
            TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
            tm.obrisiUtakmicu(row);
        }

    }                                              
    /**
     * Dugme koje sluzi za cuvanje samog turnira u bazi. Uslov koji mora biti zadovoljen je da datumi
     * pocetka i zavrsetka kao i naziv turnira budu popunjeni. Nakon toga se pravi objekat tipa Turnir
     * i puni se podacima sa forme nakon cega se zove sistemska operacija za dodavanje turnira i poruka
     * o uspjesnosti cuvanja turnira u bazi.
     * 
     * @param evt event listener
     */
    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        try {
            if(txtDatumOd.getText().isEmpty() || txtDatumDo.getText().isEmpty()
                    || txtNazivTurnira.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Datum od i datum do moraju biti popunjeni!");
                return;
            }
            
            String nazivTurnira = txtNazivTurnira.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumOd = sdf.parse(txtDatumOd.getText());
            Date datumDo = sdf.parse(txtDatumDo.getText());
            String grad = (String) cmbGrad.getSelectedItem();
            TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
            
            Turnir t = new Turnir(null, nazivTurnira, datumOd, datumDo, grad, ulogovani, tm.getLista());
            
            (new SOAddTurnir()).templateExecute(t);
            resetujFormu();
            JOptionPane.showMessageDialog(this, "Uspesno sacuvan turnir!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    /**
     * Dugme koje sluzi za serijalizaciju novog turnira u json dokument, gdje se u njoj
     * provjeravaju odredjena granicenja i kreira sam objekat turnira sa forme koji se 
     * serijalizuje.
     * @param evt event listener.
     */
    private void btnSerijalizujActionPerformed(java.awt.event.ActionEvent evt) {
		if (txtNazivTurnira.getText().isEmpty() || txtDatumOd.getText().isEmpty()
                || txtDatumDo.getText().isEmpty()
                || txtGoloviPrvi.getText().isEmpty()
                || txtGoloviDrugi.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String naziv = txtNazivTurnira.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date datumPocetka = null;
        Date datumZavrsteka=null;
		try {
			datumPocetka=sdf.parse(txtDatumOd.getText());
			datumZavrsteka=sdf.parse(txtDatumDo.getText());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
       
        String grad = (String) cmbGrad.getSelectedItem();
        ArrayList<Utakmica> utakmice=new ArrayList<>();
        Turnir t=new Turnir(null, naziv, datumPocetka, datumZavrsteka, grad, ulogovani, utakmice);
        //System.out.println(t.getNazivTurnira());
        (new SOAddTurnir()).serijalizujJSON(t);
        System.out.println("Turnir serijalizovan.");
	}

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDodajTekmu;
    private javax.swing.JButton btnObrisiTekmu;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Tim> cmbDrugiTim;
    private javax.swing.JComboBox cmbGrad;
    private javax.swing.JComboBox<Tim> cmbPrviTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNoviTim;
    private javax.swing.JMenuItem miOdjava;
    private javax.swing.JMenuItem miPretragaTima;
    private javax.swing.JMenuItem miPretragaTurnira;
    private javax.swing.JTable tblUtakmice;
    private javax.swing.JFormattedTextField txtDatumDo;
    private javax.swing.JFormattedTextField txtDatumOd;
    private javax.swing.JFormattedTextField txtGoloviDrugi;
    private javax.swing.JFormattedTextField txtGoloviPrvi;
    private javax.swing.JTextField txtNazivTurnira;
    private JButton btnSerijalizuj;
    // End of variables declaration                   
    /**
     * Vrsi se pozivanje sistemske operacije za ucitavanje svih timova iz baze u
     * namjeri da se popuni combo box timovima sa ucitanim vrijednostima radi 
     * dodavanja novih timova koji igraju utakmice na turniru.
     */
    public void popuniTimove() {

        try {
            SOGetAllTim so=new SOGetAllTim();
            so.templateExecute(new Tim());
            ArrayList<Tim> timovi = so.getLista();

            cmbPrviTim.removeAllItems();
            cmbDrugiTim.removeAllItems();

            for (Tim tim : timovi) {
                cmbPrviTim.addItem(tim);
                cmbDrugiTim.addItem(tim);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Resetuje formu na pocetne vrijednosti.
     */
    private void resetujFormu() {
        txtNazivTurnira.setText("");
        txtDatumOd.setText("");
        txtDatumDo.setText("");
        tblUtakmice.setModel(new TableModelUtakmice());
    }
}
