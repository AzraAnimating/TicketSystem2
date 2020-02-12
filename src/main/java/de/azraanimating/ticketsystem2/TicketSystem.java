package de.azraanimating.ticketsystem2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import de.azraanimating.customprefixapi.command.CommandHandler;
import de.azraanimating.ticketsystem2.commands.Rang;
import de.azraanimating.ticketsystem2.commands.Speichern;
import de.azraanimating.ticketsystem2.commands.Ticket;
import de.azraanimating.ticketsystem2.listener.GuildMessageListener;
import de.azraanimating.ticketsystem2.yml.Config;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

import java.io.File;

public class TicketSystem {


    private static String token; //Bot-Token
    public static CommandHandler commandHandler;
    public static String ticketCategoryID; //Katrgorie in der die Tickets erstellt werden sollen
    public static String prefix; //Command Prefix
    public static String ticketSupportRoleID; //Rolle der Supporter
    public static String hasTicketRoleID; //Rolle die das erstellen eines 2. Tickets verhindert
    public static String runner; //Legt fest welches wort den Command auslößt
    public static boolean privateNotify; //Legt fest ob alle Träger der Supportrolle Privat angeschrieben werden sollen
    public static String notifyChannelID; //Legt den Channel in den benachrichtigungen gesendet werden sollen
    public static boolean notifyWithMention;
    public static String ticketEntry; //Legt den Text fest, welcher beim erstellen eines Tickets geschrieben wird '<user>' lässt den User erwähnen
    public static String activationChannelID; //Der Channel in dem der Command akzeptiert wird
    public static String saveCategoryID;


    public static void main(String[] args) throws Exception {
            /**
             * Startet den Bot & Initialisiert die Events
             */

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try{
            Config config = mapper.readValue(new File("config.yml"), Config.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        token = Config.getToken(); //Bot-Token
        ticketCategoryID = Config.getTicketCategoryID(); //Katrgorie in der die Tickets erstellt werden sollen
        prefix = Config.getPrefix(); //Command Prefix
        ticketSupportRoleID = Config.getTicketSupportRoleID(); //Rolle der Supporter
        hasTicketRoleID = Config.getHasTicketRoleID(); //Rolle die das erstellen eines 2. Tickets verhindert
        runner = Config.getRunner(); //Legt fest welches wort den Command auslößt
        privateNotify = Config.isPrivateNotify(); //Legt fest ob alle Träger der Supportrolle Privat angeschrieben werden sollen
        notifyChannelID = Config.getNotifyChannelID(); //Legt den Channel in den benachrichtigungen gesendet werden sollen
        notifyWithMention = Config.isNotifyWithMention();
        ticketEntry = Config.getTicketEntry(); //Legt den Text fest, welcher beim erstellen eines Tickets geschrieben wird '<user>' lässt den User erwähnen
        activationChannelID = Config.getActivationChannelID();
        saveCategoryID = Config.getSaveCategoryID();

        System.out.println("Loaded: " +
                "\n Token: " + token +
                "\n Prefix: " + prefix +
                "\n Auslöser: " + runner);

            new DefaultShardManagerBuilder()
                    .setToken(token)
                    .addEventListeners(new GuildMessageListener())
                    .setActivity(Activity.playing(Config.getActivity()))
                    .build();

            /**
             * Eigene Library, https://github.com/azraanimating/customprefixapi/ - Commandhandler
             *
             * Filtert Command & Argumente aus der der Nachricht raus, Commands mit .addCommand angegeben
             */
            commandHandler = new CommandHandler();

            commandHandler.addCommand(new Ticket());
            commandHandler.addCommand(new Speichern());
            commandHandler.addCommand(new Rang());
    }
}




































































































//Jaja ich weiss, Static nich so geil. aber für 5€, Was erwartet man ala