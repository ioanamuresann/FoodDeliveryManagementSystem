package BusinessLogicLayer;

import java.util.ArrayList;

public class Login {
    private String parolaAdmin;
    private String userAdmin;
    private String parolaClient;
    private String userClient;
    private ArrayList<String> listaClienti=new ArrayList<>();
    private ArrayList<String> listaAdmin=new ArrayList<>();

    public String getParolaAdmin() {
        return parolaAdmin;
    }

    public void setParolaAdmin(String parolaAdmin) {
        this.parolaAdmin = parolaAdmin;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getParolaClient() {
        return parolaClient;
    }

    public void setParolaClient(String parolaClient) {
        this.parolaClient = parolaClient;
    }

    public String getUserClient() {
        return userClient;
    }

    public void setUserClient(String userClient) {
        this.userClient = userClient;
    }

    public ArrayList<String> getListaClienti() {
        return listaClienti;
    }

    public void setListaClienti(ArrayList<String> listaClienti) {
        this.listaClienti = listaClienti;
    }

    public ArrayList<String> getListaAdmin() {
        return listaAdmin;
    }

    public void setListaAdmin(ArrayList<String> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }
    public void adaugaClient()
    {
        listaClienti.add(userClient + parolaClient);
    }
    public void adaugaAdmin()
    {
        listaAdmin.add(userAdmin + parolaAdmin);
    }

}
