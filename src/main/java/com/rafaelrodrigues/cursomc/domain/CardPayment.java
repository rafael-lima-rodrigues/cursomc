package com.rafaelrodrigues.cursomc.domain;

import com.rafaelrodrigues.cursomc.domain.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class CardPayment extends Payment {
    private static final long serialVersionUID = 1L;


    private Integer installmentsNumber;

    public CardPayment() {
    }

    public CardPayment(Integer id, PaymentStatus paymentStatus, Demand demand, Integer installmentsNumber) {
        super(id, paymentStatus, demand);
        this.installmentsNumber = installmentsNumber;
    }

    public Integer getInstallmentsNumber() {
        return installmentsNumber;
    }

    public void setInstallmentsNumber(Integer installmentsNumber) {
        this.installmentsNumber = installmentsNumber;
    }
}
