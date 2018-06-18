package iac.schobshop.Schobshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PurchaseLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int amount;
    @Column(columnDefinition = "decimal")
    private double price;
    @ManyToOne
    private Purchase purchase;

    public PurchaseLine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = this.product.getPrice() * this.amount;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseLine that = (PurchaseLine) o;
        return amount == that.amount &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product, amount);
    }
}
