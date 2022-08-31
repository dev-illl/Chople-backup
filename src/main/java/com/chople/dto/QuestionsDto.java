package com.chople.dto;

import com.chople.constant.QuestionsStatus;
import com.chople.constant.Role;
import com.chople.entity.Questions;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class QuestionsDto {

    private Long id;

    private QuestionsStatus qStatus;

    @NotBlank(message = "질문의 제목을 입력 해주세요")
    private String subject;

    private String category;

    @Builder
    public QuestionsDto(Long id, QuestionsStatus qStatus, String subject, String category){
        this.id = id;
        this.qStatus = qStatus;
        this.subject = subject;
        this.category = category;
    }

    public Questions toEntity(String email, String nickName, Role role, String category){
        return Questions.builder()
                .id(id)
                .email(email)
                .nickName(nickName)
                .role(role)
                .qStatus(QuestionsStatus.PROGRESS)
                .subject(subject)
                .category(category)
                .build();
    }
}