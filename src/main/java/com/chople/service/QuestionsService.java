package com.chople.service;


import com.chople.dto.NewChoiceFormDto;
import com.chople.dto.ChoiceDataDto;
import com.chople.entity.Choice;
import com.chople.entity.Member;
import com.chople.repository.ChoiceRepository;
import com.chople.repository.MemberRepository;
import com.chople.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionsService {

    private final ChoiceRepository choiceRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final QuestionsRepository questionsRepository;

    public Choice saveChoiceQuesitons(NewChoiceFormDto choiceDto){
        // 회원 정보를 끌어와 문의 DB 에 같이 저장
        Member memberInfo = memberRepository.findByEmail(memberService.nowMemberInfo());
        Choice choice = choiceDto.toEntity(memberInfo);
        return choiceRepository.save(choice);
    }

    // 등록된 Choice Questions 목록을 가져오는 메서드
    public List<ChoiceDataDto> choiceList(){
        List<Choice> allChoiceList = choiceRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ChoiceDataDto> choiceDescList = new ArrayList<>();
        for(Choice choice : allChoiceList){
            ChoiceDataDto choiceListBuilder = ChoiceDataDto.builder()
                    .id(choice.getId())
                    .qStatus(choice.getQStatus())
                    .subject(choice.getSubject())
                    .hit(choice.getHit())
                    .nickName(choice.getNickName())
                    .build();
            choiceDescList.add(choiceListBuilder);
        }
        return choiceDescList;
    }

    public ChoiceDataDto choiceGetData(Long id){
        Optional<Choice> choiceData = choiceRepository.findById(id);
        Choice choice = choiceData.get();
        ChoiceDataDto choiceDataDto = ChoiceDataDto.builder()
                .id(choice.getId())
                .
    }

}
