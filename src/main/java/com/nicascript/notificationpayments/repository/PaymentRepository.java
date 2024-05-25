package com.nicascript.notificationpayments.repository;

import com.nicascript.notificationpayments.dto.entity.PaymentEntity;
import com.nicascript.notificationpayments.dto.request.PaymentReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
    @Query(value = """
            SELECT
              p.name AS paymentName,
              p.amount,
              c.name AS categoryName
            FROM
              payment p
            JOIN
              category c ON p.category_uuid = c.uuid;
            """, nativeQuery = true)
    List<PaymentReportDto> findPaymentCategoryDetails();

}
