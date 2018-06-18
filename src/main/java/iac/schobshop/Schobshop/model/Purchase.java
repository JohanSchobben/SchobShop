package iac.schobshop.Schobshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date purchaseDate;
    @ManyToOne
    private Account account;
    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;
    @Enumerated(value = EnumType.STRING)
    private PurchaseState purchaseState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase")
    private Set<PurchaseLine> purchaseLines;

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PurchaseState getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(PurchaseState purchaseState) {
        this.purchaseState = purchaseState;
    }

    public Set<PurchaseLine> getPurchaseLines() {
        return purchaseLines;
    }

    public void setPurchaseLines(Set<PurchaseLine> purchaseLines) {
        this.purchaseLines = purchaseLines;
    }

    @Transient
    public double getTotalPrice(){
        double totalPrice = 0;
        for (PurchaseLine purchaseLine : purchaseLines){
            totalPrice+= purchaseLine.getPrice();
        }
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
