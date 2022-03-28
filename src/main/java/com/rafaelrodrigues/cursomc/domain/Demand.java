package com.rafaelrodrigues.cursomc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Demand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "demand")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "delivery_Address_id")
    private Address address;

    @OneToMany(mappedBy = "id.demand")
    private Set<DemandItem> items = new HashSet<>();

    public Demand() {
    }

    public Demand(Integer id, Date date, Customer customer, Address address) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<DemandItem> getItems() {
        return items;
    }

    public void setItems(Set<DemandItem> items) {
        this.items = items;
    }

    public void addAllItems(List<DemandItem> demandItem) {
        this.items.addAll(demandItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demand demand = (Demand) o;
        return Objects.equals(id, demand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
