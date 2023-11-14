class AddFunctions {
    
    private static AddFunctions istanza;
    
    private AddFunctions(){
        
    }

    //SINGLETON PER LA SESSIONE
    public static AddFunctions getInstance() {

        if (istanza == null){
            istanza = new AddFunctions();
        }

        return istanza;
    }

    public static void changePassword(){
        
    }
}
