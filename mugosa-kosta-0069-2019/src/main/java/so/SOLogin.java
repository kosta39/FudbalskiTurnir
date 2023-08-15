package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * Ovo je sistemska operacija pomocu koje se administrator loguje na sistem. Implementira
 * neke apstraktne metode klase AbstractSO koju nasledjuje.
 * 
 * @author Kosta
 */
public class SOLogin extends AbstractSO {
    /**
     * Instanca klase Administrator koja predstavlja ulogovanog administratora.
     */
    Administrator ulogovani;
    /**
     * @throws Exception ukoliko prosledjeni objekat nije instanca klase Administrator
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
    }
    /**
     * Poziva se broker baze podataka koji vrsi SELECT upit kojim se vracaju svi administratori iz baze
     * nakon cega se provjerava da li administrator sa datim kredencijalima postoji u bazi
     * 
     * @throws Exception ukoliko u bazi ne postoji administrator sa datim kredencijalima
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        Administrator a = (Administrator) ado;

        ArrayList<Administrator> administratori
                = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Administrator administrator : administratori) {
            if (administrator.getUsername().equals(a.getUsername())
                    && administrator.getPassword().equals(a.getPassword())) {
                ulogovani = administrator;
                return;
            }
        }

        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
        
    }
    /**
     * Vraca administratora koji je ulogovan.
     * @return ulogovani administrator
     */
    public Administrator getUlogovani() {
        return ulogovani;
    }
    
    

}
