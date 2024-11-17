package dev.harshit.productcatalog.inheritancedemo.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_mentor")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    <S extends Mentor> S save(S entity);
}
