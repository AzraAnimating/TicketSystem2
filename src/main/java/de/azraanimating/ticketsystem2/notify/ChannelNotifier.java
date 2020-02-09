package de.azraanimating.ticketsystem2.notify;

import de.azraanimating.customprefixapi.command.CommandEvent;
import de.azraanimating.ticketsystem2.TicketSystem;
import net.dv8tion.jda.api.entities.TextChannel;

public class ChannelNotifier {

    public void notifyChannel(CommandEvent event, String ticketName){
        if(!TicketSystem.notifyChannelID.equalsIgnoreCase("")){
            TextChannel notifyChannel = event.getGuild().getTextChannelById(TicketSystem.notifyChannelID);

            StringBuilder notifyMessage = new StringBuilder();

            notifyMessage.append("Der Benutzer " + event.getMember().getEffectiveName() + " hat ein Supportticket mit dem Namen '" + ticketName + "' erstellt.");
            if(TicketSystem.notifyWithMention){
                notifyMessage.append(" ").append(event.getGuild().getRoleById(TicketSystem.ticketSupportRoleID).getAsMention());
            }

            notifyChannel.sendMessage(notifyMessage.toString()).queue();
        }
    }

}
