package com.sparta.membertest.repository;

import com.sparta.membertest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
