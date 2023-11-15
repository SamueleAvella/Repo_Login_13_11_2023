import java.util.Map;

class Sessione{

    private static Sessione istanza;
    private static Map userLogged=null;
    
    private Sessione(){}

    //SINGLETON PER LA SESSIONE
    public static Sessione getInstance() {

        if (istanza == null){
            istanza = new Sessione();
        }

        return istanza;
    }

    public static Map getUserLogged() {
        return userLogged;
    }

    //SETTING PER DEFINIRE L'UTENTE LOGGATO
    public static void setUserLogged(Map user) {
        userLogged = user;
    }

    public static void operation(Options opzione){
        switch (opzione) {
            case CREATE:
                Crud.create();
                break;
            case READ:
                Crud.read();
                break;
            case UPDATE:
                Crud.update();
                break;
            case DELETE:
                Crud.delete();
                break;
            case CHANGE_PSW:
                AddFunctions.changePassword();
                break;
            default:
                break;
        }
    }
}
