package de.azraanimating.ticketsystem2.listener;

import de.azraanimating.ticketsystem2.TicketSystem;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){


        /**
         * Command handling
         *
         * Prefix, wird in Config gesetzt
         */
        TicketSystem.commandHandler.handle(event, TicketSystem.prefix);
    }

}
