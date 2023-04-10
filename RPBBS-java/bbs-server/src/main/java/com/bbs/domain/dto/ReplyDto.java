package com.bbs.domain.dto;

import com.bbs.domain.CardReply;
import lombok.Data;

@Data
public class ReplyDto extends CardReply {
    private String replyToId;
}
