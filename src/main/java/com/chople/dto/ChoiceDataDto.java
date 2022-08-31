package com.chople.dto;

import com.chople.constant.QuestionsStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChoiceDataDto {

    private Long id;

    private QuestionsStatus qStatus;

    private String subject;

    private String content;

    private String firstOptionName;

    private String secondOptionName;

    private Integer hit;

    private String nickName;

    @Builder
    public ChoiceDataDto(Long id, QuestionsStatus qStatus, String subject, Integer hit, String nickName){
        this.id = id;
        this.qStatus = qStatus;
        this.subject = subject;
        this.hit = hit;
        this.nickName = nickName;
    }
}
