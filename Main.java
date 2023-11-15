import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Creazione di un'istanza della classe CreazioneAccount
        CreazioneAccount creazioneAccount = new CreazioneAccount();

         // Esempio di registrazione di un nuovo utente
        creazioneAccount.registraUtente("John", "Doe", "john.doe@example.com", "jon", "password123");
/* 
        // Esempio di tentativo di registrazione con username già esistente
        creazioneAccount.registraUtente("Jane", "Doe", "jane.doe@example.com", "john_doe", "anotherpassword");

        // Esempio di registrazione di un altro utente
        creazioneAccount.registraUtente("Alice", "Smith", "alice.smith@example.com", "alice", "securepassword");

        creazioneAccount.registraUtente("", "Smith", "alice.smith@example.com", "alice", "securepassword");
        creazioneAccount.registraUtente("Alice", "Smith", "alice.smith@example.com", "alice", "secur");

        System.out.println((Login.effettuaLogin("jon", "password123")) ? "Login Effettuato" : "Login Non effettuato");

        //UserManager.stampaUtenti();*/

        stampaMenu1();
        System.out.println("Inserire una scelta");
        int scelta1 = scanner.nextInt();

        switch (scelta1) {
            case 1:
                System.out.println("Creazione account");
                System.out.println("Inserire nome");
                String nome = scanner.next();
                System.out.println("cognome");
                String cognome = scanner.next();
                System.out.println("email");
                String email = scanner.next();
                System.out.println("nome utente");
                String nomeUtente = scanner.next();
                System.out.println("password");
                String password = scanner.next();
                scanner.nextLine();
                creazioneAccount.registraUtente(nome, cognome, email, nomeUtente, password);
                break;
            case 2:
                System.out.println("Login in corso");
                System.out.println("Inserire username");
                String user = scanner.next();
                System.out.println("password");
                String pw = scanner.next();
                System.out.println((Login.effettuaLogin(user, pw)) ? "Login Effettuato" : "Login Non effettuato");

                if(Login.effettuaLogin(user, pw)==true){

                    stampaMenu2();

                    System.out.println("Inserire una scelta");
                    int scelta2 = scanner.nextInt();
                    switch (scelta2) {
                        case 1:
                        System.out.println("Crud read. ");
                        Sessione.operation(Options.READ);
                            break;

                        case 2:
                         System.out.println("Crud update. ");
                         Sessione.operation(Options.UPDATE);
                            break;

                        case 3:
                        System.out.println("Cambio password. ");
                        Sessione.operation(Options.CHANGE_PSW);
                            break;
                        
                        case 4:
                        System.out.println("Crud delete. ");
                        Sessione.operation(Options.DELETE);
                            break;
                            
                        default:
                            break;
                    }



                }

                break;

            default:
                System.out.println("Inserire una scelta valida");
                break;
        }

    
/*
        System.out.println("Cambio password. ");
        Sessione.operation(Options.CHANGE_PSW);

        System.out.println((Login.effettuaLogin("jon", "password123")) ? "Login Effettuato" : "Login Non effettuato");

        System.out.println("Crud create. ");
        Sessione.operation(Options.CREATE);

        UserManager.stampaUtenti();

        System.out.println("Crud read. ");
        Sessione.operation(Options.READ);

        System.out.println("Crud update. ");
        Sessione.operation(Options.UPDATE);

        System.out.println("Crud delete. ");
        Sessione.operation(Options.DELETE);

        UserManager.stampaUtenti(); */


    }

    public static void stampaMenu1(){

    System.out.println("Menu:");
    System.out.println("-1: Crea account");
    System.out.println("-2: Effettua login");


}
    public static void stampaMenu2(){
        System.out.println("Menu:");
        System.out.println("-1: Visualizza informazioni");
        System.out.println("-2: Modifica informazioni");
        System.out.println("-3: Modifica password");
        System.out.println("-4: Elimina profilo");

    }

}

