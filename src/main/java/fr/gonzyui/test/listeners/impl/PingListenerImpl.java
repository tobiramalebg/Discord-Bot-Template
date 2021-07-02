package fr.gonzyui.test.listeners.impl;

import fr.gonzyui.test.listeners.PingListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class PingListenerImpl implements PingListener {
    @Override
    public void onMessageCreate(MessageCreateEvent e) {
        if (e.getMessageContent().equals("!ping")) {
            e.getChannel().sendMessage("Pong!");
        }
    }
}
