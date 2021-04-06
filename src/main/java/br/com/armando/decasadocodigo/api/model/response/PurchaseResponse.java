package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.Purchase;

public class PurchaseResponse {

    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String document;
    private String address;
    private String complement;
    private CountryResponse country;
    private StateResponse state;
    private String phone;
    private String cep;
    private PurchaseOrderResponse order;
    private AppliedCouponResponse appliedCoupon;

    public PurchaseResponse(Purchase purchase) {
        this.id = purchase.getId();
        this.email = purchase.getEmail();
        this.name = purchase.getName();
        this.lastName = purchase.getLastName();
        this.document = purchase.getDocument();
        this.address = purchase.getAddress();
        this.complement = purchase.getComplement();
        this.country = new CountryResponse(purchase.getCountry());
        this.state = new StateResponse(purchase.getState());
        this.phone = purchase.getPhone();
        this.cep = purchase.getCep();
        this.order = new PurchaseOrderResponse(purchase.getOrder());
        if (purchase.getAppliedCoupon() != null) this.appliedCoupon = new AppliedCouponResponse(purchase.getAppliedCoupon());
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

    public CountryResponse getCountry() {
        return country;
    }

    public StateResponse getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public PurchaseOrderResponse getOrder() {
        return order;
    }

    public AppliedCouponResponse getAppliedCoupon() {
        return appliedCoupon;
    }
}
