package de.azraanimating.ticketsystem2.commands;

import de.azraanimating.customprefixapi.command.Command;
import de.azraanimating.customprefixapi.command.CommandEvent;
import de.azraanimating.ticketsystem2.TicketSystem;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.internal.requests.Route;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Speichern extends Command {

    public Speichern(){
        this.name = "speichern";
    }

    @Override
    protected void excecute(CommandEvent event) {
        if(event.getChannel().getName().startsWith("ticket-") && event.getMember().getRoles().contains(event.getGuild().getRoleById(TicketSystem.ticketSupportRoleID))){
            Category saveCategory = event.getGuild().getCategoryById(TicketSystem.saveCategoryID);

            TextChannel savedChannel = saveCategory.createTextChannel(event.getChannel().getName()).complete();

            savedChannel.getManager().setTopic(event.getChannel().getTopic() + " ARCHIVED " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))).queue();

            MessageHistory messageHistory = new MessageHistory(event.getChannel());

            messageHistory.retrievePast(100).complete();

            System.out.println(messageHistory.getRetrievedHistory().size());

            List<Message> messagesList = messageHistory.getRetrievedHistory();

            ArrayList<Message> messages = new ArrayList<>(messagesList);

            Collections.reverse(messages);

            messages.forEach(message -> {
                savedChannel.sendMessage(new EmbedBuilder().addField(message.getAuthor().getAsTag(), message.getContentRaw(), false).setColor(Color.GREEN).setFooter(message.getTimeCreated().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + " ; " + message.getTimeCreated().getHour() + ":" + message.getTimeCreated().getMinute() + ":" + message.getTimeCreated().getSecond(), message.getAuthor().getAvatarUrl()).build()).queue();
            });
        }
    }
}
