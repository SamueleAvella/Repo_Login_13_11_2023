

public class Login{
    
    
      static int tentativi = 3;

     public boolean effettuaLogin(String user, String psw, String hashPsw){

         
        
     if(UserManager.isConteinedByUser(user)){

      while(tentativi>0){
        if(Login.checkPassword(psw, hashPsw)){
            return true;
        }else{
            Login.decTentativi();
            return false;
        }
       
    }
  }
             Utente userLogged=null;
            Sessione.setUserLogged(userLogged);


}
                                                                     
    
           
    
    public int getTentativi() {
        return tentativi;
    }
    public static void decTentativi() {
        tentativi--;
    }

    public static boolean checkPassword(String psw, String hashPsw){

        
        psw = CreazioneAccount.generaHashPassword(psw);
        if (psw.equals(hashPsw)){
            return true;
        }else{

        return false;
    
    }

  
}
}