package com.chople.entity;

import com.chople.constant.QuestionsStatus;
import com.chople.constant.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "questions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Questions extends BaseEntity {

    @Id
    @Column(name = "questions_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String email;

    private String nickName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private QuestionsStatus qStatus;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String category;

    @Builder
    public Questions(Long id, String email, String nickName, Role role, QuestionsStatus qStatus, String subject, String category){
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.role = role;
        this.qStatus = qStatus;
        this.subject = subject;
        this.category = category;
    }
}
