package jiezhang.service.impl;

import jiezhang.base.service.AbstractService;
import jiezhang.entity.db.Message;
import jiezhang.mapper.MessageMapper;
import jiezhang.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends AbstractService<Message, MessageMapper> implements MessageService {
}
