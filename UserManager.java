import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class UserManager{

    private static UserManager istanza;
    private static List<Map> listaUtenti = new ArrayList<>();
    
    private UserManager(){}

    public static UserManager getInstance() {

        if (istanza == null){
            istanza = new UserManager();
        }

        return istanza;
    }

    public static void addUser(Map mappa){
        listaUtenti.add(mappa);
    }

    public static void removeUser(Map mappa){
        listaUtenti.remove(mappa);
    }

    public static boolean isContainedByUser(String user){
        for (Map map : listaUtenti) {
            if(map.containsValue(user))
                return true;
        }
        return false;
    }

    public static Map getMapByUser(String user){
        for (Map map : listaUtenti) {
            if(map.containsValue(user))
                return map;
        }
        return null;
    }

    /*public static void setMapByUser(String user){
        for (Map map : listaUtenti) {
            if(map.containsValue(user))
                map
        }
    }*/

    /*public static String getValueMapByKey(String key){
        for (Map map : listaUtenti) {
            if(map.containsKey(key))
                return (String) map.get(key);
        }
        return null;
    }*/


    public static void stampaUtenti(){
        
        for (Map<String, String> mappa : listaUtenti) {
        System.out.println("Mappa:");

        // Scorrimento della mappa corrente
        for (Map.Entry<String, String> entry : mappa.entrySet()) {
            String chiave = entry.getKey();
            String valore = entry.getValue();
            System.out.println(chiave + ":" + valore);
        }
    }
    }

    

    /*public static void stampaUtenti(){
        for(int i=0; i<listaUtenti.size(); i++){
            System.out.println(i);
            System.out.println(listaUtenti);
            System.out.println(listaUtenti.get(i));
        }
    }*/

    /*public void removeUser(Utente utente){
        listaUtenti.remove(utente);
    }*/



}


