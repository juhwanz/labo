package com.example.study_lab.day9;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaExperimentService {

    private final MemberRepository memberRepository;

    public JpaExperimentService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Transactional // 이게 있어야 영속성 컨텍스트 유지
    public void experiment(){
        System.out.println("========== [1] 데이터 저장 ==========");
        Member member = new Member("OldNmae");
        memberRepository.save(member);// INSERT 실행 (사실은 쓰기 지연 때문에 커밋 시점에 나감)
        Long saveId = member.getId();

        System.out.println("========== [2] 1차 캐시 실험 ==========");
        System.out.println(">>> 1번째 조회 요청");
        Member find1 = memberRepository.findById(saveId).get();

        System.out.println(">>> 2번째 조회 요청 (sql 나감??)");
        Member find2 = memberRepository.findById(saveId).get();

        System.out.println(">>> 객체 동일성 비교 (find1 == find2): " + (find1 == find2));

        System.out.println("========== [3] Dirty Checking 실험 ==========");
        System.out.println(">>> 이름을 'NewName'으로 변경합니다.");
        find1.changeName("NewName");

        System.out.println(">>> (중요) save()를 호출하지 않았습니다!");
        System.out.println("========== [4] 메서드 종료 (트랜잭션 커밋) ==========");
    }
}
