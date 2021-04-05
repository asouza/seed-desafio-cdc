package br.com.armando.decasadocodigo.domain.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.function.Function;

@Entity
@Table(name = "tb_purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String complement;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String cep;

    @OneToOne(mappedBy = "purchase", cascade = CascadeType.PERSIST)
    private Order order;

    @Deprecated
    public Purchase() {
    }

    public Purchase(
            String email,
            String name,
            String lastName,
            String document,
            String address,
            String complement,
            Country country,
            String phone,
            String cep,
            Function<Purchase, Order> orderCreationFunction
    ) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.country = country;
        this.phone = phone;
        this.cep = cep;
        this.order = orderCreationFunction.apply(this);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public Order getOrder() {
        return order;
    }

    public void setState(State state) {
        Assert.isTrue(state.belongsToCountry(country), "Esse estado não está associado com o País informado na Compra.");
        this.state = state;
    }

}
