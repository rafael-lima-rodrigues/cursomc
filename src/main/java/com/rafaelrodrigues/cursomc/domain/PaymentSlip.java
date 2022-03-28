package com.rafaelrodrigues.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafaelrodrigues.cursomc.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentSlip extends Payment {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date paymentDate;

    public PaymentSlip() {
    }

    public PaymentSlip(Integer id, PaymentStatus paymentStatus, Demand demand, Date dueDate, Date paymentDate) {
        super(id, paymentStatus, demand);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
