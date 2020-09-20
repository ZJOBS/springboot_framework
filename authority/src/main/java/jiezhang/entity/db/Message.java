package jiezhang.entity.db;

import jiezhang.base.annotation.Id;
import jiezhang.base.entity.BaseEntity;
import lombok.Data;

@Data
public class Message extends BaseEntity {
    @Id
    private String messageId;
    private String type;
    private String message;
    private Boolean see;
    private String jump;

}
