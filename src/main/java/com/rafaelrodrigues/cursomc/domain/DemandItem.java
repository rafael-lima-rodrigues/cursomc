package com.rafaelrodrigues.cursomc.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class DemandItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DemandItemPK id = new DemandItemPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public DemandItem() {
    }

    public DemandItem(Demand demand, Product product, Double discount, Integer quantity, Double price) {
        this.id.setDemand(demand);
        this.id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    public Demand getDemand() {
        return id.getDemand();
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public DemandItemPK getId() {
        return id;
    }

    public void setId(DemandItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandItem that = (DemandItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
