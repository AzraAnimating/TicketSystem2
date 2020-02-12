package de.azraanimating.ticketsystem2.commands;

import de.azraanimating.customprefixapi.command.Command;
import de.azraanimating.customprefixapi.command.CommandEvent;
import de.azraanimating.ticketsystem2.yml.Config;

public class Rang extends Command {

    public Rang(){
        this.name = "rang";
    }

    @Override
    protected void excecute(CommandEvent event) {

        if(event.getMember().getRoles().contains(event.getGuild().getRoleById(Config.getRequiredRankID()))){
            try {
                event.getGuild().addRoleToMember(event.getGuild().getMemberById(event.getArgs().get(0).replace("<@!", "").replace(">", "")), event.getGuild().getRoleById(Config.getRankID())).queue();
                event.reply("Rang wurde an " + event.getGuild().getMemberById(event.getArgs().get(0).replace("<@!", "").replace(">", "")).getAsMention() + " vergeben!");
            } catch (Exception e){
                event.reply("Dieser Benutzer ist nicht auf diesem Server vertreten.");
            }
        } else {
            event.getMessage().delete().queue();
        }

        //TODO
        //Rang in Config festlegen und dann mit command (samt erforderlichen rang) vergeben
    }
}
