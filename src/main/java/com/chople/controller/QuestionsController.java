package com.chople.controller;

import com.chople.dto.NewChoiceFormDto;
import com.chople.dto.ChoiceDataDto;
import com.chople.repository.MemberRepository;
import com.chople.service.MemberService;
import com.chople.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionsController {

    private final QuestionsService questionsService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 문의 생성 페이지
    @GetMapping("/newChoice")
    public String newQuestionsForm(NewChoiceFormDto choiceDto, Model model){
        model.addAttribute("choiceDto", choiceDto);
        return "questions/newChoiceForm";
    }

    // 문의 생성하는 Form
    @PostMapping("/newChoice")
    public String newQuestions(@Valid NewChoiceFormDto newChoiceFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "questions/newChoiceForm";
        }

        try{
            //문의 저장
            questionsService.saveChoiceQuesitons(newChoiceFormDto);
        } catch(Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            return "questions/newChoiceForm";
        }
        return "redirect:/";
    }

    // Choice 하는 문의 전체 게시판
    @GetMapping("/choiceList")
    public String choiceList(Model model){
        List<ChoiceDataDto> choiceDtoList = questionsService.choiceList();
        model.addAttribute("choiceList", choiceDtoList);
        return "/questions/choiceList";
    }

    // Choice 하는 문의 상세 페이지
    @GetMapping("/choiceDetail/{id}")
    public String choiceDetail(@PathVariable("id")Long id, Model model){

        return "/questions/choiceDetail";
    }
}