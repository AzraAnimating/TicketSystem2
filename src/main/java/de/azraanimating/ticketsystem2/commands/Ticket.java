package de.azraanimating.ticketsystem2.commands;

import de.azraanimating.customprefixapi.command.Command;
import de.azraanimating.customprefixapi.command.CommandEvent;
import de.azraanimating.ticketsystem2.TicketSystem;
import de.azraanimating.ticketsystem2.notify.ChannelNotifier;
import de.azraanimating.ticketsystem2.notify.PrivateNotifier;
import de.azraanimating.ticketsystem2.ticketmanager.Manager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;

import java.awt.*;

public class Ticket extends Command {

    public Ticket(){
        this.name = TicketSystem.runner;
    }

    @Override
    protected void excecute(CommandEvent event) {
        //Action, Create, Delete / help  wird ausgewählt
        try {
            if (event.getArgs().size() > 0) {
                String action = event.getArgs().get(0);
                Manager manager = new Manager();
                PrivateNotifier privateNotifier = new PrivateNotifier();
                ChannelNotifier channelNotifier = new ChannelNotifier();
                if (event.getArgs().size() > 1) {
                    //Name des Tickets wird angegeben
                    if (action.equalsIgnoreCase("create")) {
                        if(event.getChannel().getId().equals(TicketSystem.activationChannelID)) {
                            StringBuilder ticketName = new StringBuilder();
                            if (event.getArgs().size() > 2) {
                                //Name des Tickets wird gebaut (Mit Unterstrichen als Leerzeichen)
                                for (int i = 1; i < event.getArgs().size(); i++) {
                                    ticketName.append(event.getArgs().get(i));
                                    if (i < event.getArgs().size() - 1) {
                                        ticketName.append("_");
                                    }
                                }
                            } else {
                                ticketName.append(event.getArgs().get(1));
                            }
                            if(!event.getMember().getRoles().contains(event.getGuild().getRoleById(TicketSystem.hasTicketRoleID))) {
                                if (TicketSystem.privateNotify) {
                                    privateNotifier.notify(event, ticketName.toString());
                                    channelNotifier.notifyChannel(event, ticketName.toString());
                                } else {
                                    event.reply("Du kannst maximal **ein** Ticket erstellen");
                                }
                            }
                            manager.create(ticketName.toString().replace("-", "_"), event.getGuild().getCategoryById(TicketSystem.ticketCategoryID), event);
                            event.getMessage().delete().queue();
                        } else {
                            event.getMessage().delete().queue();
                        }
                    }
                } else {
                    if (!event.getArgs().get(0).equalsIgnoreCase("close") && !event.getArgs().get(0).equalsIgnoreCase("help") && event.getChannel().getId().equals(TicketSystem.activationChannelID)) {
                        event.reply("Bitte gebe einen Namen für dein Ticket ein ``" + TicketSystem.prefix + TicketSystem.runner + " create 'Name'``");
                    }
                }
                /**
                 * Ticket wird sofern die Rechte dazu vorhanden & der Channel ein Ticket ist geschlossen
                 */
                if (action.equalsIgnoreCase("close") && event.getChannel().getName().startsWith("ticket-")) {
                    if (event.getChannel().getName().startsWith("ticket-")) {
                        if (event.getMember().hasPermission(Permission.MESSAGE_HISTORY)) {
                            try {
                                if (event.getChannel().getTopic().contains("Ticket Owner: " + event.getMember().getId()) || event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                                    manager.delete(event.getTextChannel(), event);
                                } else {
                                    event.reply("Da du kein Administrator oder der Besitzer des Tickets bist, kannst du dieses nicht schliessen");
                                }
                            } catch (Exception e) {
                                //e.printStackTrace();
                                event.reply("Dies ist kein Ticket welches von mir erstellt wurde");
                            }
                        } else {
                            event.reply("Du bist nicht dazu berechtigt dieses Ticket zu schliessen");
                        }
                    } else {
                        event.reply("Dies ist leider kein Ticket");
                    }
                }

                /**
                 * Hilfe: Wird anhand der Permissions ausgebgeben, d.H. wen jemand Admin hat, werden Usages usw ausgegeben
                 */
                if (action.equalsIgnoreCase("help")) {

                    if (event.getMember().getRoles().contains(TicketSystem.ticketSupportRoleID)) {
                        event.sendEmbed(new EmbedBuilder()
                                .setColor(Color.CYAN)
                                .setTitle("Administrator - Hilfe")
                                .addField("Verwaltungscommands", "Jeder Supporter kann ein Ticket forceclosen, das heisst, dass ein Supporter ohne Zustimmung des Ticketautors das Ticket schliessen kann", false));
                    }

                    event.sendEmbed(new EmbedBuilder()
                            .setColor(Color.GREEN)
                            .setTitle(TicketSystem.runner + " Hilfe")
                            .addField("Commands", "**" + TicketSystem.runner + " Erstellen**: \n" + "Ein " + TicketSystem.runner + " wird erstellt indem du ``" + TicketSystem.prefix + TicketSystem.runner + " create 'Name'`` ausführst. \n \n**" + TicketSystem.runner + " löschen:** \n Ein " + TicketSystem.runner + " wird gelöscht indem du im Channel des " + TicketSystem.runner + "'s ``" + TicketSystem.prefix + TicketSystem.runner + " close`` ausführst", false));
                }

            }
        } catch (Exception e){
            event.getMessage().delete().queue();
        }
    }
}
