
import java.util.Scanner;             // importo lo scanner

public class Login{

    //creo il metodo per il login
    public boolean login() throws AccessoNegatoException{   
        
         boolean accesso = false;
         final int TENTATIVI=3;

        Scanner sc = new Scanner(System.in);                             // creo lo scanner

        System.out.println("inserisci l'username:");

        String usarnameTenativo= sc.nextLine();                          // creo una stringa che contiene l'username preso dallo scanner 

        System.out.println("inserisci la password: ");

        String passwordTentativo = sc.nextLine();                       // creo la stringa che contine la password presa dallo scanner
        
        
        for (int i=0; i< TENTATIVI; i++){
             //controllo se le stringhe non siano vuote e che siano uguali a quelle della registrazione
                if((usarnameTenativo != null) && (passwordTentativo != null) /* && 
                    (.equals(usarnameTenativo))&&(.equals(passwordTentativo))*/){                          

                    System.out.println("benvenuto ");

                    accesso = true;
                } else {

                    System.out.println("credenziali non valide");
                }
        }

        if(!accesso){
            throw  new  AccessoNegatoException(" tentativi finiti, le credenziali che hai inserito non sono valide ");
        }
        return accesso;
    }
}