package dev.harshit.productcatalog.inheritancedemo.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_user")
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    <S extends User> S save(S entity);
}
