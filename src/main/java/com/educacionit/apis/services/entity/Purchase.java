package com.educacionit.apis.services.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID = -2969524610059270447L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private Long id;

    @Column
    private int quantity;

    @Column
    private double total;

    @Column
    private LocalDate datePurchanse;

    @Column
    private LocalDate cancellationDate;

     //Mapeos de base de datos Id Book a comprar
    //Mapeos de base de datos Id Usuario
    //Getters, Setters, HashCode, Equals & ToString Functions
     @Size(min=1)
     @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(name = "purchase_book",
             joinColumns=@JoinColumn(name="purchase_id"),
             inverseJoinColumns=@JoinColumn(name="book_id"))
     private Set<Book> books;

    @Size(min=1)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "purchase_user",
            joinColumns=@JoinColumn(name="purchase_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDatePurchanse() {
        return datePurchanse;
    }

    public void setDatePurchanse(LocalDate datePurchanse) {
        this.datePurchanse = datePurchanse;
    }

    public LocalDate getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    /*
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Purchase other = (Purchase) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", description=" + description + "]";
    }
     */

}