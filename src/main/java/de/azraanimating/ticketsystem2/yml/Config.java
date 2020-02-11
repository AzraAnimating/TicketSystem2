package de.azraanimating.ticketsystem2.yml;


public class Config {

    /**
     * private static String token = "NjI4NjU3MDc3MDMxNjY1Njcz.Xj14_g.f80dk2n0j4zKNzW05GZWXqKBqq8"; //Bot-Token
     *     public static String ticketCategoryID = "608341490359599125"; //Katrgorie in der die Tickets erstellt werden sollen
     *     public static String prefix = "!"; //Command Prefix
     *     public static String ticketSupportRoleID = "609088404424097817"; //Rolle der Supporter
     *     public static String hasTicketRoleID = "645081317393956866"; //Rolle die das erstellen eines 2. Tickets verhindert
     *     public static String runner = "Ticket"; //Legt fest welches wort den Command auslößt
     *     public static boolean privateNotify = true; //Legt fest ob alle Träger der Supportrolle Privat angeschrieben werden sollen
     *     public static String notifyChannelID = ""; //Legt den Channel in den benachrichtigungen gesendet werden sollen
     *     public static boolean notifyWithMention = true;
     *     public static String ticketEntry = "Hallo <user> willkommen im support"; //Legt den Text fest, welcher beim erstellen eines Tickets geschrieben wird '<user>' lässt den User erwähnen
     *     public static String activationChannelID = "608341490359599126"; //Der Channel in dem der Command akzeptiert wird
     */

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
}