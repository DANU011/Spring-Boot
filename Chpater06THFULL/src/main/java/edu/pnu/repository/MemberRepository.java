package edu.pnu.repository;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
