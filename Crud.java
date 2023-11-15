/*import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class Crud {
    
    public static void create(){
        Scanner scan = new Scanner(System.in);
        int input;
        String inputS, nome="ADMIN", cognome="ADMIN", email="ADMIN", username="ADMIN", hashpsw;
        LocalDate dataNascita = LocalDate.of(2023, 12, 12);


        hashpsw = CreazioneAccount.generaHashPassword(hashpsw, "salt-casuale");

        CreazioneAccount.registraUtente(nome, cognome, email, username, hashpsw);
    }

    public static void read(){
        System.out.println(Sessione.getUserLogged());
    }

    public static void update(){
        Scanner scan = new Scanner(System.in);
        int input;
        String inputS;

        System.out.println("Inserisci che informazione vuoi modificare :");
        System.out.println("1) Nome");
        System.out.println("2) Cognome");
        System.out.println("3) Data di nascita");

        input = scan.nextInt();

        switch (input) {
            case 1:
                inputS = scan.nextLine(); 
                Sessione.getUserLogged().setNome(inputS);
                break;
            case 2:
                inputS = scan.nextLine(); 
                Sessione.getUserLogged().setCognome(inputS);
                break;
            case 3:
                inputS = scan.nextLine();
                DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                try {
                    // Converte la stringa in un oggetto LocalDate
                    LocalDate data = LocalDate.parse(inputS, formatoData);
                    Sessione.getUserLogged().setDataNascita(data);
                } catch (Exception e) {
                    System.out.println("Errore durante la conversione della data: " + e.getMessage());
                }
                break;
            default:
                break;
        }


    }

    public static void delete(){
        Scanner scan = new Scanner(System.in);
        String inputS;

        System.out.println("Inserisci password: ");
        inputS = scan.nextLine();

        if(Login.checkPassword(inputS,Sessione.getUserLogged().getPassword())){
            UserManager.removeUser(Sessione.getUserLogged());
            Sessione.setUserLogged(null);
            System.gc();
        }
    }
}*/

import java.util.Map;
import java.util.Scanner;

public class Crud{

    private static UserManager userManager = UserManager.getInstance();
    static CreazioneAccount account = new CreazioneAccount();

    // Metodo per creare un nuovo utente
    public static void create() {

        Scanner scanner = new Scanner(System.in);

        // Acquisizione del nome
        System.out.print("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();

        // Acquisizione del cognome
        System.out.print("Inserisci il tuo cognome: ");
        String cognome = scanner.nextLine();

        // Acquisizione dell'email
        System.out.print("Inserisci la tua email: ");
        String email = scanner.nextLine();

        // Acquisizione del nome utente
        System.out.print("Inserisci il tuo nome utente: ");
        String nomeUtente = scanner.nextLine();

        // Acquisizione della password
        System.out.print("Inserisci la tua password: ");
        String password = scanner.nextLine();

        // Chiusura dello scanner
        scanner.close();

        account.registraUtente(nome, cognome, email, nomeUtente, password);
        // Implementa la logica di creazione dell'utente
        // Puoi utilizzare il metodo registraUtente della classe CreazioneAccount o aggiungere qui la logica necessaria
    }

    // Metodo per leggere un utente in base all'username
    public static void read() {
        Map user = Sessione.getUserLogged();
        if (user != null) {
            System.out.println("Informazioni sull'utente: " + user);
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    // Metodo per aggiornare le informazioni di un utente
    public static void update() {
        Map user = Sessione.getUserLogged();
        if (user != null) {
            // Aggiorna le informazioni dell'utente con nuoveInformazioni
            //user.putAll(nuoveInformazioni);
            //chiama il metodo di katia e apriamo uno switch per capire cosa vuole modificare
            //poi cosi mettiamo user.put("specifica", valore)
            System.out.println("Informazioni utente aggiornate con successo.");
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    // Metodo per eliminare un utente
    public static void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome utente: ");
        String nomeUtente = scanner.next();
        
        
        // Acquisizione della password
        System.out.print("Inserisci la tua password: ");
        String password = scanner.next();

        scanner.close();
        Map user = Sessione.getUserLogged();
        if (UserManager.isContainedByUser(nomeUtente) && Login.checkPassword( (String)user.get("hashpasword"),CreazioneAccount.generaHashPassword(password, "salt-casuale"))) {
            UserManager.removeUser(user);
            System.out.println("Utente eliminato con successo.");
        }
        else {
            System.out.println("Utente non trovato.");
        }
        
    }
}

