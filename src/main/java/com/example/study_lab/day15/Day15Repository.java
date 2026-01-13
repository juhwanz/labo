package com.example.study_lab.day15;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Day15Repository extends JpaRepository<Day15Member, Long> {
    // id로 사람찾기 -> 없을 수도 있으니 Optional
    Optional<Day15Member> findByUsername(String name);
}
