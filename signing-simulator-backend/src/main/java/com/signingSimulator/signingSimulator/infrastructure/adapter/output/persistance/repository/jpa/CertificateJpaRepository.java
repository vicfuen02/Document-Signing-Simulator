package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class CertificateJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;



    public List<CertificateEntity> getCertificateByUserId(String userId) {
        try {
            List<CertificateEntity> result = entityManager.createNativeQuery(
                     "SELECT CE.*, U.\"USER_ID\" " +
                        "FROM   PUBLIC.\"SG_CERTIFICATES\" CE " +
                                " INNER JOIN PUBLIC.\"SG_USER_CERTIFICATE\" UCE ON UCE.\"CERT_ID\" = CE.\"CERT_ID\"" +
                                " INNER JOIN PUBLIC.\"SG_USERS\" U ON UCE.\"USER_ID\" = U.\"USER_ID\"" +
                        "WHERE  U.\"USER_ID\" = :userId;"
                    , CertificateEntity.class)
                    .setParameter("userId", userId)
                    .getResultList();
            return result;
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    @Transactional
    public Boolean uploadCertificate(String userId, Certificate certificate) {

        Boolean uploaded = true;
        try {
            String certId = String.valueOf(new Date().getTime());
            entityManager.createNativeQuery("INSERT INTO public.\"SG_USER_CERTIFICATE\"( " +
                            " \"USER_ID\", \"CERT_ID\", \"DATE_INSERT\", \"DATE_MOD\", \"CODE_STATUS\", \"USER_INSERT\", \"USER_MOD\")" +
                            " VALUES (?, ?, NOW(), NOW(), ?, ?, ?); ")
                    .setParameter(1, userId)
                    .setParameter(2, certId)
                    .setParameter(3, "CES001")
                    .setParameter(4, "UC0000")
                    .setParameter(5, "UC0000")
                    .executeUpdate();

            entityManager.createNativeQuery("INSERT INTO public.\"SG_CERTIFICATES\"(" +
                            " \"CERT_ID\", \"CERT_DOCUMENT\", \"CERT_NAME\", \"CERT_PASSWORD\", \"CERT_DATEFROM\", \"CERT_DATETO\", \"DATE_INSERT\", \"DATE_MOD\", \"CODE_STATUS\", \"USER_INSERT\", \"USER_MOD\")" +
                            " VALUES (?, ?, ?, ?, NOW(), NOW(), NOW(), NOW(), ?, ?, ?); ")
                    .setParameter(1, certId)
                    .setParameter(2, certificate.getCertificate())
                    .setParameter(3, certificate.getName())
                    .setParameter(4, certificate.getPassword())
                    .setParameter(5, "CES001")
                    .setParameter(6, "UC0000")
                    .setParameter(7, "UC0000")
                    .executeUpdate();
        } catch (PersistenceException e) {
            System.out.println(e.toString());
            uploaded = false;
        }

        return uploaded;

    }




}
