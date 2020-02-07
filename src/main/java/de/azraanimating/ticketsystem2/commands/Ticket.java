package de.azraanimating.ticketsystem2.commands;

import de.azraanimating.customprefixapi.command.Command;
import de.azraanimating.customprefixapi.command.CommandEvent;
import de.azraanimating.ticketsystem2.TicketSystem;
import de.azraanimating.ticketsystem2.ticketmanager.Manager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;

public class Ticket extends Command {

    public Ticket(){
        this.name = "ticket";
    }

    @Override
    protected void excecute(CommandEvent event) {
        //Action, Create, Delete / help  wird ausgewählt

        if(event.getArgs().size() > 0){
            String action = event.getArgs().get(0);
            Manager manager = new Manager();
            if(event.getArgs().size() > 1) {
                //Name des Tickets wird angegeben
                if (action.equalsIgnoreCase("create")) {
                    StringBuilder ticketName = new StringBuilder();
                    if(event.getArgs().size() > 2){
                        //Name des Tickets wird gebaut
                        for(int i = 1; i < event.getArgs().size(); i++){
                            ticketName.append(event.getArgs().get(i));
                            ticketName.append("_");
                        }
                    } else {
                        ticketName.append(event.getArgs().get(1));
                    }
                    manager.create(ticketName.toString(), event.getGuild().getCategoryById(TicketSystem.ticketCategoryID), event);
                }
            }
            /**
             * Ticket wird sofern die Rechte dazu vorhanden & der Channel ein Ticket ist geschlossen
             */
            if(action.equalsIgnoreCase("close")){
                if(event.getChannel().getName().startsWith("ticket-")){
                    if(event.getMember().hasPermission(Permission.MANAGE_CHANNEL)){
                        if(event.getChannel().getTopic().contains("Ticket Owner: " + event.getMember().getId()) || event.getMember().hasPermission(Permission.ADMINISTRATOR)){
                            manager.delete(event.getTextChannel(), event);
                        } else {
                            event.reply("Da du kein Administrator oder der Besitzer des Tickets bist, kannst du dieses nicht schliessen");
                        }
                    } else {
                        event.reply("Du bist nicht dazu berechtigt dieses Ticket zu schliessen");
                    }
                } else {
                    event.reply("Dies ist leider kein Ticket");
                }
            }
        }
    }
}
