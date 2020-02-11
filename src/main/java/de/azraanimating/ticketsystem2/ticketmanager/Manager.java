package de.azraanimating.ticketsystem2.ticketmanager;

import de.azraanimating.customprefixapi.command.CommandEvent;
import de.azraanimating.ticketsystem2.TicketSystem;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Arrays;

public class Manager {

    public void create(String name, Category category, CommandEvent event) {
        if (!event.getMember().getRoles().contains(event.getGuild().getRoleById(TicketSystem.hasTicketRoleID))) {
            //Overhead
            TextChannel ticketChannel = category.createTextChannel("Ticket-" + name + "-" + event.getMember().getId()).complete();
            Role ticketRole = ticketChannel.getGuild().createRole().setName("ticket-" + name).complete();
            Role supportRole = event.getGuild().getRoleById(TicketSystem.ticketSupportRoleID);
            Role everyone = event.getGuild().getPublicRole();
            ticketChannel.getManager().setTopic("Ticket Owner: " + event.getMember().getId() + " (" + event.getMember().getUser().getName() + ")").queue();

            //Rechtezuweisung

            ticketChannel.createPermissionOverride(everyone).setDeny(
                    Permission.VIEW_CHANNEL,
                    Permission.MESSAGE_HISTORY,
                    Permission.MESSAGE_READ
            ).queue();

            //Rolle zur Kenntlichkeit & Für Extrarechte
            event.getGuild().addRoleToMember(event.getMember(), ticketRole).queue();

            ticketChannel.upsertPermissionOverride(ticketRole).grant(
                    Permission.VIEW_CHANNEL,
                    Permission.MESSAGE_ATTACH_FILES,
                    Permission.MESSAGE_READ,
                    Permission.MESSAGE_WRITE,
                    Permission.MESSAGE_HISTORY,
                    Permission.MESSAGE_ADD_REACTION,
                    Permission.MESSAGE_EMBED_LINKS,
                    Permission.MANAGE_CHANNEL
            ).queue();

            try {
                ticketChannel.upsertPermissionOverride(supportRole).grant(
                        Permission.VIEW_CHANNEL,
                        Permission.MESSAGE_ATTACH_FILES,
                        Permission.MESSAGE_READ,
                        Permission.MESSAGE_WRITE,
                        Permission.MESSAGE_HISTORY,
                        Permission.MESSAGE_ADD_REACTION,
                        Permission.MESSAGE_EMBED_LINKS,
                        Permission.MANAGE_CHANNEL
                ).queue();
            } catch (Exception e) {
            }

            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(TicketSystem.hasTicketRoleID)).queue();

            if(!TicketSystem.ticketEntry.equalsIgnoreCase("")){
                ticketChannel.sendMessage(TicketSystem.ticketEntry.replace("<user>", event.getMember().getAsMention())).queue();
            }
        }
    }

    public void delete(TextChannel ticketChannel, CommandEvent event){
        String[] channelInfos = ticketChannel.getName().split("-");
        String userID = channelInfos[2];
        if (event.getMember().getId().equalsIgnoreCase(userID)) {
            String userIdPart = "-" + userID;

            event.getGuild().removeRoleFromMember(event.getGuild().getMemberById(userID), event.getGuild().getRolesByName(event.getChannel().getName().replace(userIdPart, ""), true).get(0)).queue();
            event.getGuild().removeRoleFromMember(event.getGuild().getMemberById(userID), event.getGuild().getRoleById(TicketSystem.hasTicketRoleID)).queue();
            event.getGuild().getRolesByName(channelInfos[0] + "-" + channelInfos[1], true).get(0).delete().queue();
        }
        ticketChannel.delete().queue();
    }

}
