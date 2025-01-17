package day65.model.repository;

import day65.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository
        extends JpaRepository<MemberEntity, Integer > {

}
