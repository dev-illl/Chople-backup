package com.chople.dto;

import com.chople.constant.QuestionsStatus;
import com.chople.entity.Choice;
import com.chople.entity.Member;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class NewChoiceFormDto {
    private Long id;

    private QuestionsStatus qStatus;

    @NotBlank(message = "질문의 제목을 입력 해주세요")
    private String subject;

    @NotBlank(message = "질문의 내용을 입력 해주세요")
    private String content;

    @NotBlank(message = "1번째 선택지")
    private String firstOptionName;

    @NotBlank(message = "2번째 선택지")
    private String secondOptionName;

    @NotBlank(message = "3번째 선택지")
    private String thirdOptionName;

    @NotBlank(message = "4번째 선택지")
    private String fourthOptionName;

    @NotBlank(message = "5번째 선택지")
    private  String fifthOptionName;

    private String firstOptionImage;

    private String secondOptionImage;

    private String thirdOptionImage;

    private String fourthOptionImage;

    private String fifthOptionImage;

    private Integer firstOptionCount;

    private Integer secondOptionCount;

    private Integer thirdOptionCount;

    private Integer fourthOptionCount;

    private Integer fifthOptionCount;

    private String ip;

    private Integer hit;


    @Builder
    public NewChoiceFormDto(Long id , QuestionsStatus qStatus, String subject, String content,
                            String firstOptionName, String secondOptionName, String thirdOptionName, String fourthOptionName, String fifthOptionName, String firstOptionImage,
                            String secondOptionImage, String thirdOptionImage, String fourthOptionImage, String fifthOptionImage, Integer firstOptionCount, Integer secondOptionCount,
                            Integer thirdOptionCount, Integer fourthOptionCount, Integer fifthOptionCount, String ip, Integer hit){
        this.id = id;
        this.qStatus = qStatus;
        this.subject = subject;
        this.content = content;
        this.firstOptionName = firstOptionName;
        this.secondOptionName = secondOptionName;
        this.thirdOptionName = thirdOptionName;
        this.fourthOptionName = fourthOptionName;
        this.fifthOptionName = fifthOptionName;
        this.firstOptionImage = firstOptionImage;
        this.secondOptionImage = secondOptionImage;
        this.thirdOptionImage = thirdOptionImage;
        this.fourthOptionImage = fourthOptionImage;
        this.fifthOptionImage = fifthOptionImage;
        this.firstOptionCount = firstOptionCount;
        this.secondOptionCount = secondOptionCount;
        this.thirdOptionCount = thirdOptionCount;
        this.fourthOptionCount = fourthOptionCount;
        this.fifthOptionCount = fifthOptionCount;
        this.ip = ip;
        this.hit = hit;
    }

    public Choice toEntity(Member member){
        return Choice.builder()
                .id(id)
                .nickName(member.getNickName())
                .member(member)
                .qStatus(QuestionsStatus.PROGRESS)
                .subject(subject)
                .content(content)
                .firstOptionName(firstOptionName)
                .secondOptionName(secondOptionName)
                .thirdOptionName(thirdOptionName)
                .fourthOptionName(fourthOptionName)
                .fifthOptionName(fifthOptionName)
                .firstOptionImage(firstOptionImage)
                .secondOptionImage(secondOptionImage)
                .thirdOptionImage(thirdOptionImage)
                .fourthOptionImage(fourthOptionImage)
                .fifthOptionImage(fifthOptionImage)
                .firstOptionCount(firstOptionCount)
                .secondOptionCount(secondOptionCount)
                .thirdOptionCount(thirdOptionCount)
                .fourthOptionCount(fourthOptionCount)
                .fifthOptionCount(fifthOptionCount)
                .ip(ip)
                .hit(hit)
                .build();
    }
}
