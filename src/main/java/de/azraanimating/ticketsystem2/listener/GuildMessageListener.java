package de.azraanimating.ticketsystem2.listener;

import de.azraanimating.ticketsystem2.TicketSystem;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.text.Format;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class GuildMessageListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        if(event.getMessage().getAuthor().equals(event.getJDA().getSelfUser())){
            return;
        }

        /**
         * Command handling
         *
         * Prefix, wird in Config gesetzt
         */

        TicketSystem.commandHandler.handle(event, TicketSystem.prefix);
        if(event.getMessage().getContentRaw().startsWith(TicketSystem.prefix + "ticket") || event.getMessage().getContentRaw().startsWith(TicketSystem.prefix + "speichern")) {
            System.out.println("[" + event.getMember().getUser().getAsTag() + " | " + event.getChannel().getName() + " | " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + " | " + event.getMessage().getTimeCreated().getHour() + ":" + event.getMessage().getTimeCreated().getMinute() + ":" + event.getMessage().getTimeCreated().getSecond() + "] " + event.getMessage().getContentRaw());
        }
    }

}
