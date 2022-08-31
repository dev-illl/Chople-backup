package com.chople.entity;

import com.chople.constant.QuestionsStatus;
import com.chople.constant.Role;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@Table(name = "choiceQuestions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Choice extends BaseEntity {

    @Id
    @Column(name = "choiceQ_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nickName;

    @Enumerated(EnumType.STRING)
    private QuestionsStatus qStatus;

    @Column(nullable = false)
    private String subject;

    @Column(length = 10000, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String firstOptionName;

    @Column(length = 100, nullable = false)
    private String secondOptionName;

    @Column(length = 100)
    private String thirdOptionName;

    @Column(length = 100)
    private String fourthOptionName;

    @Column(length = 100)
    private String fifthOptionName;

    private String firstOptionImage;

    private String secondOptionImage;

    private String thirdOptionImage;

    private String fourthOptionImage;

    private String fifthOptionImage;

    @ColumnDefault("0")
    private Integer firstOptionCount;

    @ColumnDefault("0")
    private Integer secondOptionCount;

    @ColumnDefault("0")
    private Integer thirdOptionCount;

    @ColumnDefault("0")
    private Integer fourthOptionCount;

    @ColumnDefault("0")
    private Integer fifthOptionCount;

    private String ip;

    private Integer hit;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Choice(Long id, String nickName, Member member, QuestionsStatus qStatus, String subject, String content,
                  String firstOptionName, String secondOptionName, String thirdOptionName, String fourthOptionName, String fifthOptionName, String firstOptionImage,
                  String secondOptionImage, String thirdOptionImage, String fourthOptionImage, String fifthOptionImage, Integer firstOptionCount, Integer secondOptionCount,
                  Integer thirdOptionCount, Integer fourthOptionCount, Integer fifthOptionCount, String ip, Integer hit){
        this.id = id;
        this.nickName = nickName;
        this.member = member;
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
}
