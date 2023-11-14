import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        //INIZIALIZZAZIONI VARIABILI D'APPOGGIO
        String  user="", 
                psw="", 
                nome="", 
                cognome="", 
                email="";
        LocalDate dataNascita;

        Sessione.getInstance(); //CREA UNA SESSIONE

        if (Sessione.getUserLogged()==null) {

            //REGISTRAZIONE
            CreazioneAccount.registraUtente(user,  psw,  email);
    
            //TORNA ALL'HOMPAGE
            //ACCEDI

            Login.effettuaLogin(user, psw);
        }
        else{
            Options opzione=Options.CHANGE_PSW;

            Sessione.operation(opzione);
        }

        

        



    }
}
