package de.azraanimating.ticketsystem2.yml;


public class Config {

    private static String token; //Bot-Token
    private static String ticketCategoryID; //Katrgorie in der die Tickets erstellt werden sollen
    private static String prefix; //Command Prefix
    private static String ticketSupportRoleID; //Rolle der Supporter
    private static String hasTicketRoleID; //Rolle die das erstellen eines 2. Tickets verhindert
    private static String runner; //Legt fest welches wort den Command auslößt
    private static boolean privateNotify; //Legt fest ob alle Träger der Supportrolle Privat angeschrieben werden sollen
    private static String notifyChannelID; //Legt den Channel in den benachrichtigungen gesendet werden sollen
    private static boolean notifyWithMention;
    private static String ticketEntry; //Legt den Text fest, welcher beim erstellen eines Tickets geschrieben wird '<user>' lässt den User erwähnen
    private static String activationChannelID; //Der Channel in dem der Command akzeptiert wird
    private static String activity; //Aktivität
    private static String saveCategoryID;//Kategorie für backups
    private static String rankID;
    private static String requiredRankID;

    public void setToken(String ptoken){
        token = ptoken;
    }

    public void setTicketCategoryID(String pticketCategoryID){
        ticketCategoryID = pticketCategoryID;
    }

    public void setPrefix(String pPrefix){
        prefix = pPrefix;
    }

    public void setTicketSupportRoleID(String pTicketSupportRoleID){
        ticketSupportRoleID = pTicketSupportRoleID;
    }

    public void setHasTicketRoleID(String pHasTicketRole){
        hasTicketRoleID = pHasTicketRole;
    }

    public void setRunner(String pRunner){
        runner = pRunner;
    }

    public void setPrivateNotify(boolean pPrivateNotify){
        privateNotify = pPrivateNotify;
    }

    public void setNotifyChannelID(String pNotifyChannelID){
        notifyChannelID = pNotifyChannelID;
    }

    public void setNotifyWithMention(boolean pNotifyWithMention){
        notifyWithMention = pNotifyWithMention;
    }

    public void setTicketEntry(String pTicketEntry){
        ticketEntry = pTicketEntry;
    }

    public void setActivationChannelID(String pActivationChannelID){
        activationChannelID = pActivationChannelID;
    }

    public void setActivity(String pActivity){
        activity = pActivity;
    }

    public void setSaveCategoryID(String pSaveCategoryID){
        saveCategoryID = pSaveCategoryID;
    }

    public void setRankID(String pRankID){
        rankID = pRankID;
    }

    public void setRequiredRankID(String pRequiredRankID){
        requiredRankID = pRequiredRankID;
    }

    //Get-Methods
    public static String getToken() {
        return token;
    }

    public static String getTicketCategoryID() {
        return ticketCategoryID;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getTicketSupportRoleID() {
        return ticketSupportRoleID;
    }

    public static String getHasTicketRoleID() {
        return hasTicketRoleID;
    }

    public static String getRunner() {
        return runner;
    }

    public static boolean isPrivateNotify() {
        return privateNotify;
    }

    public static String getNotifyChannelID() {
        return notifyChannelID;
    }

    public static boolean isNotifyWithMention() {
        return notifyWithMention;
    }

    public static String getTicketEntry() {
        return ticketEntry;
    }

    public static String getActivationChannelID() {
        return activationChannelID;
    }

    public static String getActivity(){
        return activity;
    }

    public static String getSaveCategoryID(){
        return saveCategoryID;
    }

    public static String getRankID(){
        return rankID;
    }

    public static String getRequiredRankID() {
        return requiredRankID;
    }
}