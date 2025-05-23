package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa;

import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public int createUser(UserEntity userEntity) {
        return entityManager.createNativeQuery("INSERT INTO public.\"SG_USERS\" (" +
                        "\"USER_ID\", \"USER_USERNAME\", \"USER_PASSWORD\", \"USER_NAME\", \"USER_SURNAME\", \"USER_EMAIL\"" +
                        ", \"DATE_INSERT\", \"DATE_MOD\", \"CODE_STATUS\", \"USER_INSERT\", \"USER_MOD\")" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ")
                .setParameter(1, String.valueOf(new Date().getTime()))
                .setParameter(2, userEntity.getUser())
                .setParameter(3, userEntity.getPassword())
                .setParameter(4, userEntity.getName())
                .setParameter(5, userEntity.getSurname())
                .setParameter(6, userEntity.getEmail())

                .setParameter(7, "NOW()")
                .setParameter(8, "NOW()")
                .setParameter(9, "CES001")
                .setParameter(10, "UC0000")
                .setParameter(11, "UC0000")
                .executeUpdate();
    }


    public List<UserEntity> getAll() {
        List<UserEntity> result = entityManager.createNativeQuery("SELECT * FROM public.\"SG_USERS\"; ", UserEntity.class).getResultList();
        return result;
    }

    public UserEntity getById(String id) {

        try {
            UserEntity result = (UserEntity) entityManager.createNativeQuery("SELECT * FROM public.\"SG_USERS\" " +
                            "WHERE \"USER_ID\" = :userId; ", UserEntity.class)
                    .setParameter("userId", id)
                    .getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    public UserEntity getByUserName(String userName) {
        try {
            UserEntity result = (UserEntity) entityManager.createNativeQuery("SELECT * FROM public.\"SG_USERS\" " +
                            "WHERE \"USER_USERNAME\" = :userName; ", UserEntity.class)
                    .setParameter("userName", userName)
                    .getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

}
