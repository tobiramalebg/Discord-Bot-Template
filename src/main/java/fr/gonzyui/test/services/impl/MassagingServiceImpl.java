package fr.gonzyui.test.services.impl;

import fr.gonzyui.test.services.MessagingService;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class MassagingServiceImpl implements MessagingService {

    @Override
    public void sendMessage(MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel channel) {
        int red = (int) Math.floor(Math.random() * 255);
        int green = (int) Math.floor(Math.random() * 255);
        int blue = (int) Math.floor(Math.random() * 255);
        new MessageBuilder().setEmbed(new EmbedBuilder()
        .setAuthor(author)
        .setDescription(description)
        .setFooter(footer)
        .setThumbnail(thumbnail)
        .setColor(new Color(red, green, blue)))
                .send(channel);
    }
}
