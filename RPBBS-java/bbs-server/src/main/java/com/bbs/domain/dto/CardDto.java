package com.bbs.domain.dto;

import com.bbs.domain.Card;
import com.bbs.domain.CardInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 帖子的全部信息数据
 */
@Data
public class CardDto {
    private static final long serialVersionUID = 1L;

    /** 相关帖子id */
    private String cardId;

    /** 标题 */
    private String title;

    /** 文本内容 */
    private String message;

    /** 创建者id */
    private String createById;

    /** 所属板块id */
    private String blockId;

    /** 状态 */
    private Long status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 帖子类型 */
    private String cardTypeId;

    /** 喜欢数量 */
    private Long likeNum;

    /** 富文本 */
    private String richtext;

    /** 资源路径 */
    private String sourcePath;

    /** 资源文件 */
    private MultipartFile sourceFile;

    public CardDto() {}

    public CardDto(Card card, CardInfo cardInfo) {
        this.cardId = String.valueOf(card.getId());
        this.title = card.getTitle();
        this.message = card.getMessage();
        this.createById = card.getCreateById();
        this.blockId = card.getBlockId();
        this.status = card.getStatus();
        this.createTime = card.getCreateTime();
        this.updateTime = card.getUpdateTime();
        this.cardTypeId = cardInfo.getCardTypeId();
        this.likeNum = cardInfo.getLikeNum();
        this.richtext = cardInfo.getRichtext();
        this.sourcePath = cardInfo.getSourcePath();
    }
}
