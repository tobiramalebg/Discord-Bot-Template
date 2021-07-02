package fr.gonzyui.test.listeners.impl;

import fr.gonzyui.test.listeners.RateListener;
import fr.gonzyui.test.services.MessagingService;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RateListenerImpl implements RateListener {
    private final static Pattern pattern = Pattern.compile("!rate (\\w+)");

    @Autowired
    private MessagingService messagingService;

    @Override
    public void onMessageCreate(MessageCreateEvent e) {
        if (e.getMessageContent().startsWith("!rate")) {

            Matcher matcher = pattern.matcher(e.getMessageContent());

            if (matcher.matches()) {

                int rating = (int) Math.floor(Math.random() * 100) + 1;
                messagingService.sendMessage(e.getMessageAuthor(),
                        "Rate calculator",
                        e.getMessageAuthor().getDisplayName() + " is " + rating + "% " + matcher.group(1),
                        "Come and rate again!",
                        "https://cdn.discordapp.com/attachments/849698338130755664/860326359493640232/275372.png",
                e.getChannel());
            } else {
                messagingService.sendMessage(e.getMessageAuthor(),
                        "Error!",
                        "You need to specify at least an argument!\nEg: `!rate crazy`",
                        "Come and rate again!",
                        "https://cdn.discordapp.com/attachments/849698338130755664/860326359493640232/275372.png",
                e.getChannel());
            }
        }
    }
}
