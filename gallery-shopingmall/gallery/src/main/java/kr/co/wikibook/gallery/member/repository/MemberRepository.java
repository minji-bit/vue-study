package kr.co.wikibook.gallery.member.repository;

import kr.co.wikibook.gallery.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Integer> {

    Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);
    //로그인 아이디로 회원정보 조회
    Optional<Member> findByLoginId(String loginId);
}
