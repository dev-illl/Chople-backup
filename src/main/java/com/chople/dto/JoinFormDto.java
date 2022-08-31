package com.chople.dto;

import com.chople.constant.Role;
import com.chople.entity.Member;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class JoinFormDto {

    private Long id;

    @NotBlank(message = "닉네임을 입력 해주세요")
    private String nickName;

    @NotBlank(message = "Email을 입력 해주세요")
    private String email;

    @NotBlank(message = "비밀번호는 반드시 입력 해주세요")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호를 다시한번 입력 해주세요")
    private String confirmPassword;

    @NotBlank(message = "핸드폰 번호를 입력 해주세요")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "성별을 입력해 주세요")
    private String gender;

    private Role role;

    @Builder
    public JoinFormDto (Long id, String nickName, String email, String password, String confirmPassword, String phone, String gender, Role role){
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public Member toEntity(PasswordEncoder passwordEncoder){
        String firstPassword = passwordEncoder.encode(password);
        return Member.builder()
                .id(id)
                .nickName(nickName)
                .email(email)
                .password(firstPassword)
                .confirmPassword(confirmPassword)
                .phone(phone)
                .gender(gender)
                .role(Role.USER)
                .build();
    }
}
