package com.nicascript.notificationpayments.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nicascript.notificationpayments.dto.request.PaymentCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @ManyToOne
    private CategoryEntity category;

    public PaymentEntity(PaymentCreateDto paymentCreateDto) {
        this.name = paymentCreateDto.getName();
        this.amount = paymentCreateDto.getAmount();
        this.date = paymentCreateDto.getDate();
        this.dateCreated = new Date();
        this.category = CategoryEntity.builder().uuid(paymentCreateDto.getCategoryUuid()).build();
    }

}
