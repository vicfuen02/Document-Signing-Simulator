package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa;


import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {


    UserEntity findByName(String userName);


}
