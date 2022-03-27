package com.rafaelrodrigues.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rafaelrodrigues.cursomc.domain.enums.CustomerType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Customer implements Serializable {

    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfOrCnpj;
    private Integer type;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "PHONE")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private List<Demand> demands = new ArrayList<>();

    public Customer() {
    }

    public Customer(Integer id, String name, String email, String cpfOrCnpj, CustomerType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.type = type.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public CustomerType getType() {
        return CustomerType.toEnum(type);
    }

    public void setType(CustomerType type) {
        this.type = type.getCod();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    public void addAllAddresses(List<Address> addresses) {
        this.addresses.addAll(addresses);
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public void addAllPhones(List<String> phones) {
        this.phones.addAll(phones);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addOrders(List<Demand> demands) {
        this.demands.addAll(demands);
    }
}
