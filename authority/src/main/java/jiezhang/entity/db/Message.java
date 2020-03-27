package jiezhang.entity.db;

import jiezhang.base.annotation.Id;
import jiezhang.base.entity.BaseEntity;

public class Message extends BaseEntity {
    @Id
    private String messageId;

    private String type;

    private String message;

    private Boolean see;
    private String jump;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSee() {
        return see;
    }

    public void setSee(Boolean see) {
        this.see = see;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", see=" + see +
                ", jump='" + jump + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state='" + state + '\'' +
                '}';
    }
}
