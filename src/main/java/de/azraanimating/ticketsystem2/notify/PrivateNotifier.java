package de.azraanimating.ticketsystem2.notify;

import de.azraanimating.customprefixapi.command.CommandEvent;
import de.azraanimating.customprefixapi.privatechannel.PrivateMessenger;
import de.azraanimating.ticketsystem2.TicketSystem;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import java.util.ArrayList;
import java.util.List;

public class PrivateNotifier {

    public void notify(CommandEvent event, String ticketName){
        Guild guild = event.getGuild();

        List<Member> supporters = new ArrayList<Member>();

        //Alle die die Supportrolle tragen werden in eine Liste einsortiert
        event.getGuild().getMembers().forEach(member -> {
            if(member.getRoles().contains(event.getGuild().getRoleById(TicketSystem.ticketSupportRoleID))){
                supporters.add(member);
            }
        });

        supporters.forEach(member -> {
            try {
                PrivateMessenger privateMessenger = new PrivateMessenger(member.getUser());//Ebenso aus CustomprefixAPI
                privateMessenger.sendMessage(event.getMember().getEffectiveName() + " hat gerade ein Support-Ticket mit dem Namen '" + ticketName + "' auf '" + event.getGuild().getName() + "' erstellt");
            } catch (Exception e){}
        });
    }
}
