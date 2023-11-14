import java.time.LocalDate;
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
}

