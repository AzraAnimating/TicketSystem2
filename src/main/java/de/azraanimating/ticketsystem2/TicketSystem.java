package de.azraanimating.ticketsystem2;

import de.azraanimating.customprefixapi.command.CommandHandler;
import de.azraanimating.ticketsystem2.commands.Ticket;
import de.azraanimating.ticketsystem2.listener.GuildMessageListener;
import de.azraanimating.ticketsystem2.yml.Interpreter;
import de.azraanimating.ticketsystem2.yml.Loader;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class TicketSystem {

    private static String token = "NjI4NjU3MDc3MDMxNjY1Njcz.Xj14_g.f80dk2n0j4zKNzW05GZWXqKBqq8"; //Bot-Token
    public static CommandHandler commandHandler;
    public static String ticketCategoryID = "608341490359599125"; //Katrgorie in der die Tickets erstellt werden sollen
    public static String prefix = "!"; //Command Prefix
    public static String ticketSupportRoleID = "609088404424097817"; //Rolle der Supporter
    public static String hasTicketRoleID = "645081317393956866"; //Rolle die das erstellen eines 2. Tickets verhindert
    public static String runner = "ticket"; //Legt fest welches wort den Command auslößt


    public static void main(String[] args) throws Exception {
            /**
             * Startet den Bot & Initialisiert die Events
             */

            prefix = "!";

            new DefaultShardManagerBuilder()
                    .setToken(token)
                    .addEventListeners(new GuildMessageListener())
                    .setActivity(Activity.playing("alpha"))
                    .build();

            /**
             * Eigene Library, https://github.com/azraanimating/customprefixapi/ - Commandhandler
             *
             * Filtert Command & Argumente aus der der Nachricht raus, Commands mit .addCommand angegeben
             */
            commandHandler = new CommandHandler();

            commandHandler.addCommand(new Ticket());
    }
}
