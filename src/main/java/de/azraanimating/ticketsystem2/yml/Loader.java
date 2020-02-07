package de.azraanimating.ticketsystem2.yml;

public class Loader {

    private String token = "";
    private String ownerID = "";
    private int instances = 0;
    private String prefix = "";

    public String getToken(){
        return token;
    }

    public String getOwnerID(){
        return ownerID;
    }

    public int getInstances(){
        return instances;
    }

    public String getPrefix(){
        return prefix;
    }

    public void setToken(String receivedToken){
        token = receivedToken;
    }

    public void setOwnerID(String receivedOwnerID){
        ownerID = receivedOwnerID;
    }

    public void setInstances(int receivedInstanceAmount){
        instances = receivedInstanceAmount;
    }

    public void setPrefix(String receivedPrefix){
        prefix = receivedPrefix;
    }

}
