package com.educacionit.apis.services.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Book implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1671417246199538663L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private Long id;

    @Column
    @NotBlank
    @Size(max=13,message="No se cumple las reglas del tamano isbn")
    private String isbn;

    @Column
    @NotBlank
    @Size(max=50,message="No se cumple las reglas del tamano title")
    private String title;

    @Column
    @NotBlank
    @Size(min=100,max=200,message="No se cumple las reglas del tamano title")
    private String sinopsis;

    @Column
    @NotBlank
    @Size(min=10,max=20,message="No se cumple las reglas del tamano title")
    private String gender;

    @Column
    @NotBlank
    private String price;


    /**
     * size: que al menos devuelva 1 como minimo
     * manytomany: muchos a muchos, */
    @Size(min=1)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="author_id")) //fk
    private Set<Author> authors;

    public Book() {
        super();
    }

    public Book(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

   /*

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
                + ", roles=" + roles + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        Book other = (Book) obj;
        if (confirmPassword == null) {
            if (other.confirmPassword != null)
                return false;
        } else if (!confirmPassword.equals(other.confirmPassword))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }*/

}
