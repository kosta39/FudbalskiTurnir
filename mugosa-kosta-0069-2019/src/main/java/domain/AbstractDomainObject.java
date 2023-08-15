package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cini apstraktnu domensku klasu koju nasledjuju domenske klase.
 * 
 * Sastoji se od devet apstraktnih metoda koje su implementirane od strane domenskih klasa.
 * @author Kosta
 */
public abstract class AbstractDomainObject {
	/**
	 * Vraca String sa nazivom tabele.
	 * 
	 * Ovo se koristi prilikom poziva bilo koje od CRUD operacija iz razloga sto
	 * tabele iz baze odgovaraju domenskim klasama koje implementiraju ovu metodu.
	 * 
	 * @return naziv tabele kao String
	 */
    public abstract String nazivTabele();
    /**
     * Vraca String sa alijasom neke tabele
     * 
     * Alijas koristimo kada pozivamo SELECT upit nad tabelom u bazi koja
     * odgovara domenskoj klasi koja implementira metodu.
     * 
     * @return alijas tabele kao String
     */
    public abstract String alijas();
    /**
     * Vraca String sa JOIN klauzulom.
     * 
     * Ovdje primjenjujemo koncept primarnog ili spoljnog kljuca gdje se JOIN klauzulom
     * tabela koja odgovara domenskoj klasi koja implementira metodu povezuje sa jednom ili
     * vise drugih tabela u bazi preko kljuceva.
     * 
     * Moze se desiti da je String prazan ukoliko nam nije potrebno povezivanje tabela.
     *
     * @return JOIN klauzula kao String
     */
    public abstract String join();
    /**
     * Vraca Array listu koja sadrzi elemente apstraktne domenske klase.
     * 
     * Lista sadrzi elemente tabele koja odgovara domenskoj klasi koja implementira
     * metodu i koji su vraceni SELECT upitom kao Result Set.
     * 
     * @param rs set rezultat koji vraca SELECT upit
     * @return Array lista koja sadrzi elemente apstraktne domenske klase.
     * @throws SQLException ukoliko dodje do greske prilikom izvrsavanja SELECT upita.
     */
    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;
    /**
     * Vraca String koji sadrzi imena kolona za INSERT.
     * 
     * Pozivamo je kada ubacujemo novi red u tabelu koja odgovara domenkoj klasi
     * koja implementira metodu.
     * 
     * Moze da se desi da je prazan String ukoliko ne vrsimo ubacivanje redova u tabelu.
     * @return nazivi kolona za INSERT upit predstavljeni kao String.
     */
    public abstract String koloneZaInsert();
    /**
     * Vraca String sa vrijednostima za primarni kljuc.
     * 
     * To predstavlja primarni kljuc tabele u bazi koja odgovara domenskoj klasi
     * koja implementira datu metodu.
     * 
     * Koristi se ako zelimo da izmenimo ili obrisemo odredjeni red iz tabele, tj.
     * ukoliko se izvrsavaju UPDATE ili DELETE upiti.
     * 
     * Moze da se desi da je prazan String ukoliko ne vrsimo izmjenu ili izbacivanje 
     * redova tabele.
     * @return vrijednost primarnog kljuca kao String.
     */
    public abstract String vrednostZaPrimarniKljuc();
    /**
     * Vraca String koji sadrzi kolone za INSERT upit.
     * 
     * Koristi se kada zelimo da ubacimo novi red u tabelu koja odgovara domenskoj
     * klasi koja implementira metodu.
     * 
     * Moze da se desi da je prazan String ukoliko ne vrsimo ubacivanje redova u tabelu.
     * @return nazivi kolona za INSERT upit predstavljeni kao String.
     */
    public abstract String vrednostiZaInsert();
    /**
     * Vraca String koji sadrzi kolone za UPDATE upit.
     * 
     * Koristi se kada zelimo da izmijenimo postojeci red u tabelu koja odgovara domenskoj
     * klasi koja implementira metodu.
     * 
     * Moze da se desi da je prazan String ukoliko ne vrsimo izmjenu redova tabele.
     * @return nazivi kolona za UPDATE upit predstavljeni kao String.
     */
    public abstract String vrednostiZaUpdate();
    /**
     * Vraca WHERE klauzulu kao String.
     * 
     * Kada prilikom poziva SELECT upita zelimo da vratimo samo odredjene redove
     * tabele iz baze koje odgovaraju domenskoj klasi koja implementira metodu 
     * koristimo WHERE klauzulu.
     * 
     * Moze da se desi da je prazan String ukoliko nema potrebe da pisemo WHERE klauzulu
     * u SELECT upitu.
     * @return WHERE klauzula predstavljena kao String.
     */
    public abstract String uslov();
    
}
