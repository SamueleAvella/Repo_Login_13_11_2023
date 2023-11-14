
class Sessione{

    private static Sessione istanza;
    private static Utente userLogged=null;
    
    private Sessione(){}

    //SINGLETON PER LA SESSIONE
    public static Sessione getInstance() {

        if (istanza == null){
            istanza = new Sessione();
        }

        return istanza;
    }

    public static Utente getUserLogged() {
        return userLogged;
    }

    //SETTING PER DEFINIRE L'UTENTE LOGGATO
    public static void setUserLogged(Utente user) {
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
