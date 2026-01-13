package com.example.study_lab.day10;

import com.example.study_lab.day9.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NPlusOneService {

    private final TeamRepositoryDay10 teamRepository;
    private final MemberRepositoryDay10 memberRepository;

    public NPlusOneService(TeamRepositoryDay10 teamRepository, MemberRepositoryDay10 memberRepository){
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void setup(){
        // 팀 4개 생성
        Team t1 = teamRepository.save(new Team("Team_A"));
        Team t2 = teamRepository.save(new Team("Team_B"));
        Team t3 = teamRepository.save(new Team("Team_C"));
        Team t4 = teamRepository.save(new Team("Team_D"));

        // 회원 4명 생성 ( 각자 다른 팀 소속)
        memberRepository.save(new Member("Member1", t1));
        memberRepository.save(new Member("Member2", t2));
        memberRepository.save(new Member("Member3", t3));
        memberRepository.save(new Member("Member4", t4));
    }

    @Transactional(readOnly = true)
    public void runPlusOne(){
        System.out.println("========== [1] N+1 발생 실험 (LAZY) ==========");
        List<Member> members = memberRepository.findAll(); // 쿼리 1방 (Member만 가져옴)

        System.out.println(">>> 회원 수: " + members.size());
        System.out.println(">>> 이제 팀 이름을 출력합니다 (지옥문 개방)");

        for(Member m : members){
            // 여기서 getTeam().getName() 할 때마다 SELECT 쿼리 나감.
            System.out.println("Member: " + m.getName() + " -> Team: " + m.getTeam().getName());
        }
    }

    @Transactional(readOnly = true)
    public void runFetchJoin(){
        System.out.println("========== [2] Fetch Join 해결 실험 ==========");
        // 쿼리 1방에 Member랑 Team을 다 조인해서 가져옴
        List<Member> members = memberRepository.findAllJoinFetch();

        System.out.println(">>> 조회 완료. 이제 반복문 돕니다.");
        for(Member m : members){
            // 이미 영속성 컨텍스트에 Team이 다 들어있음. 쿼리 안 나감
            System.out.println("Member: " + m.getName() + " -> Team: " + m.getTeam().getName());
        }
    }

}
