package jiezhang.console.service.impl;

import jiezhang.base.context.SpringContext;
import jiezhang.console.config.SubscribeListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/server")
public class WebSocketServer {
    /**
     * 因为@ServerEndpoint不支持注入，所以使用SpringUtils获取IOC实例
     */
//    private RedisMessageListenerContainer redisMessageListenerContainer = SpringContext.getBean("redisMessageListenerContainer");
    //concurrent包的线程安全Set，用来存放每个客户端对应的webSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private SubscribeListener subscribeListener;

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        subscribeListener = new SubscribeListener();
        subscribeListener.setSession(session);
        //设置订阅topic
        RedisMessageListenerContainer redisMessageListenerContainer = SpringContext.getBean(RedisMessageListenerContainer.class);
        redisMessageListenerContainer.addMessageListener(subscribeListener, new ChannelTopic("TOPIC"));
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() throws IOException {
        webSocketSet.remove(this);  //从set中删除
        RedisMessageListenerContainer redisMessageListenerContainer = SpringContext.getBean(RedisMessageListenerContainer.class);
        redisMessageListenerContainer.removeMessageListener(subscribeListener);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
