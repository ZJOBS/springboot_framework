package jiezhang.console.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import javax.websocket.Session;
import java.io.IOException;

public class SubscribeListener implements MessageListener {

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msg = new String(message.getBody());
        if (null!=session && session.isOpen()){
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
