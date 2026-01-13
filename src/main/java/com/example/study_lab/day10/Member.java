package com.example.study_lab.day10;

import jakarta.persistence.*;

@Entity(name = "MemberDay10")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 실무 : 무조건 LAZY로. (EAGER는 예측 불가능한 쿼리 폭탄)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    protected Member(){}

    public Member(String name, Team team){
        this.name = name;
        this.team = team;
    }

    public Team getTeam(){return team;}
    public String getName(){return name;}
}
