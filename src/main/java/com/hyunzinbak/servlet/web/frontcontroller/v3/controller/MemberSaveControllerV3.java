package com.hyunzinbak.servlet.web.frontcontroller.v3.controller;

import com.hyunzinbak.servlet.domain.member.Member;
import com.hyunzinbak.servlet.domain.member.MemberRepository;
import com.hyunzinbak.servlet.web.frontcontroller.ModelView;
import com.hyunzinbak.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
