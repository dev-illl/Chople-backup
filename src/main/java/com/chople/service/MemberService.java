package com.chople.service;

import com.chople.dto.JoinFormDto;
import com.chople.entity.Member;
import com.chople.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public Member saveMember(JoinFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = memberFormDto.toEntity(passwordEncoder);
        validateDuplicateMember(member);
        validateDuplicateNickName(member);
        confirmPassword(memberFormDto);
        return memberRepository.save(member);
    }

    private void validateDuplicateNickName(Member member) {
        Member findNickName = memberRepository.findByNickName(member.getNickName());
        if (findNickName != null) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다");
        }
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if (member == null) {
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

    public void confirmPassword(JoinFormDto memberFormDto) {
        System.out.println("비밀번호 : " + memberFormDto.getPassword() + " 비밀번호 확인 : " + memberFormDto.getConfirmPassword());
        if (!memberFormDto.getPassword().equals(memberFormDto.getConfirmPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }

    public String nowMemberInfo(){
        System.out.println("멤버 정보 가져오기 성공");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = "";
        if(authentication != null){
            userId = authentication.getName();
        }
        return userId;
    }
}
