package com.springtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springtutorial.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	@Query("SELECT x FROM Member x ORDER BY x.firstName, x.lastName")
	List<Member> findAllOrderByName();
}
