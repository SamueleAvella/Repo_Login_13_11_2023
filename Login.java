import java.util.Map;

public class Login{
    
    static int tentativi = 3;
    
    public static boolean effettuaLogin(String user, String psw){
        if(UserManager.isContainedByUser(user)){
            System.out.println("L'utente esiste");
            Map tempMap = UserManager.getMapByUser(user);
            System.out.println(tempMap);
                if(Login.checkPassword((String)tempMap.get("hashpasword"),CreazioneAccount.generaHashPassword(psw, "salt-casuale"))){
                    System.out.println("Psw combaciano");
                    Sessione.setUserLogged(UserManager.getMapByUser(user));
                    return true;
                }else{
                    return false;
                }
        }

        System.out.println("L'utente non esiste");
        Sessione.setUserLogged(null);
        return false;
        //Sessione.setUserLogged(userLogged);
}
                                                                     
    
           
    
    public int getTentativi() {
        return tentativi;
    }
    

    public static boolean checkPassword(String psw, String hashPsw){
        if (psw.equals(hashPsw)){
            return true;
        }
        return false;
    }

}