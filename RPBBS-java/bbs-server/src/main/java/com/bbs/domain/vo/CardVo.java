package com.bbs.domain.vo;

import com.bbs.domain.dto.CardDto;
import lombok.Data;

@Data
public class CardVo extends CardDto {
    private Long commentNum;
}
