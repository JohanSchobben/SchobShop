package iac.schobshop.Schobshop.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinTable(name = "product_categories",
            joinColumns = { @JoinColumn(name = "category_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private Set<Product> products;

    public Category() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(Id, category.Id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id);
    }
}
