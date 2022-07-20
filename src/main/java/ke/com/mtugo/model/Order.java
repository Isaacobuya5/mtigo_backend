package ke.com.mtugo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.com.mtugo.Status;

import javax.persistence.*;
import java.util.List;


@Table(name = "meals_order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "customer_phone", length = 50)
    private String customerPhone;

    @Column(name = "order_reference", length = 50)
    private String orderReference;

    @Enumerated(EnumType.STRING)
    @Column(name="order_status")
    private Status status;

    @Column(name = "mpesa_reference")
    private String mpesaReference;

    @Column(name = "mpesa_description")
    private String mpesaDescription;

    @Column(name = "merchant_request_id")
    private String merchantRequestId;

    @Column(name = "checkout_request_id")
    private String checkoutRequestId;

    @OneToMany(mappedBy = "orderId")
    @JsonIgnore
    private List<Order> orderItem;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Order> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<Order> orderItem) {
        this.orderItem = orderItem;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMpesaReference() {
        return mpesaReference;
    }

    public void setMpesaReference(String mpesaReference) {
        this.mpesaReference = mpesaReference;
    }

    public String getMpesaDescription() {
        return mpesaDescription;
    }

    public void setMpesaDescription(String mpesaDescription) {
        this.mpesaDescription = mpesaDescription;
    }

    public String getMerchantRequestId() {
        return merchantRequestId;
    }

    public void setMerchantRequestId(String merchantRequestId) {
        this.merchantRequestId = merchantRequestId;
    }

    public String getCheckoutRequestId() {
        return checkoutRequestId;
    }

    public void setCheckoutRequestId(String checkoutRequestId) {
        this.checkoutRequestId = checkoutRequestId;
    }
}
