package com.example.study_lab.day10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepositoryDay10 extends JpaRepository<Member, Long> {
    // 1. 일반 조회 (N+1 발생 예정)
    // 그냥 findAll() 사용

    // 2. 패치 조인 (해결 시)
    // 일반 JOin과 달리 'select  m, t' 처럼 에니티 두 개를 한 번에 다 퍼올림.
    @Query("select m from MemberDay10 m join fetch m.team")
    List<Member> findAllJoinFetch();
}
