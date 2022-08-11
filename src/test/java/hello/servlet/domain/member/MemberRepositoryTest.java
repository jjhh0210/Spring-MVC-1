package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        //테스트 끝마다 매번 실행됨
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("asdf", 30);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member foundMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(savedMember).isEqualTo(foundMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("mem1", 10);
        Member member2 = new Member("mem2", 12);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);

        //then
        List<Member> memberList = memberRepository.findAll();
        System.out.println("memberList = " + memberList);
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);
    }
}