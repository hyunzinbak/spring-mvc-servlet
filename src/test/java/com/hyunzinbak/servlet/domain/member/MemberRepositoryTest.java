package com.hyunzinbak.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

class MemberRepositoryTest {
    // 스프링 자체가 싱글톤이고, 싱글톤은 아래 코드 허용 안됨
//    MemberRepository memberRepository = new MemberRepository();

    // 아래 코드로 변경
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("hello", 20);

        // when
        Member svaedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(svaedMember.getId());
        assertThat(findMember).isEqualTo(svaedMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result).hasSize(2);
        assertThat(result).contains(member1, member2);
    }
}
