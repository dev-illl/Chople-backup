package com.chople.entity;

import com.chople.constant.Role;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nickName;

    @Column(unique = true)
    private String email;

    private String password;

    @Transient
    private String ConfirmPassword;

    private String phone;

    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member")
    private List<Choice> choices = new ArrayList<>();

    @Builder
    public Member(Long id, String nickName, String email, String password, String confirmPassword, String phone, String gender, Role role){
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.ConfirmPassword = confirmPassword;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }
}
