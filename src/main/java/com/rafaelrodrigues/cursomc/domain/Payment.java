package com.rafaelrodrigues.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rafaelrodrigues.cursomc.domain.enums.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer paymentStatus;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "demand_id")
    @MapsId
    private Demand demand;

    public Payment() {
    }

    public Payment(Integer id, PaymentStatus paymentStatus, Demand demand) {
        this.id = id;
        this.paymentStatus = paymentStatus.getCod();
        this.demand = demand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.toEnum(paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus.getCod();
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
