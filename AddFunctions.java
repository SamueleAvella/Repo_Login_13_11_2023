import java.util.Map;
import java.util.Scanner;

import javax.security.sasl.SaslException;

class AddFunctions {
    
    private static AddFunctions istanza;
    
    private AddFunctions(){}

    //SINGLETON PER LA SESSIONE
    public static AddFunctions getInstance() {

        if (istanza == null){
            istanza = new AddFunctions();
        }

        return istanza;
    }

    public static void changePassword(){
        Scanner scan = new Scanner(System.in);
        String user, psw, newPsw, inputS;

        System.out.println("Inserire user: ");
        user = scan.nextLine();
        System.out.println("Inserire password vecchia: ");
        psw = scan.nextLine();
        System.out.println("Inserire nuova password: ");
        newPsw = scan.nextLine();


        if(UserManager.isContainedByUser(user)){
            System.out.println("L'utente esiste");
            Map tempMap = UserManager.getMapByUser(user);
            System.out.println(tempMap);
                if(Login.checkPassword( (String)tempMap.get("hashpasword"),CreazioneAccount.generaHashPassword(psw, "salt-casuale"))){
                    System.out.println("Psw combaciano");
                    tempMap.put("hashpasword" , CreazioneAccount.generaHashPassword(newPsw, "salt-casuale"));
                    System.out.println("MOdifica effettuata");
                }
                else{
                    System.out.println("Modifica non effettuata");
                }
                
        }
    }
}
