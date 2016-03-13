package com.preproduction.delivery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author Irbis
 */
@Component
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "Order.findByCustomer", query = "SELECT o FROM Order o WHERE o.customer = :customer")
})
public class Order implements Serializable {

    private static final int MAX_ORDER_SIZE = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<OrderDetails> pizzas = new ArrayList<>();
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "price")
    private Double orderPrice;
    @Column(name = "orderSize")
    private Integer orderSize;

    public Order() {
    }

    public Order(Customer customer, OrderStatus orderStatus, Integer orderSize) {
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderSize = orderSize;
    }

    public Order(Integer id, Customer customer, OrderStatus OrderStatus,
            List<OrderDetails> pizzas, Double orderPrice, Integer orderSize) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
        this.orderStatus = OrderStatus;
        this.orderPrice = orderPrice;
        this.orderSize = orderSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetails> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<OrderDetails> pizzas) {
        this.pizzas = pizzas;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }        

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(Integer orderSize) {
        this.orderSize = orderSize;
    }

    public void addPizza(Pizza pizza) {
        if (orderSize < MAX_ORDER_SIZE) {
            orderSize++;
            for (OrderDetails od : pizzas) {
                if (od.getPizza().equals(pizza)) {
                    od.setQuantity(od.getQuantity() + 1);
                    return;
                }
            }
            pizzas.add(new OrderDetails(pizza, 1, this));
        }
    }

    public void deletePizza(Pizza pizza) {
        for (OrderDetails od : pizzas) {
            if (od.getPizza().equals(pizza)) {
                orderSize -= od.getQuantity();
                pizzas.remove(od);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (OrderDetails od : pizzas) {
            str.append(od.toString());
        }
        String cust = customer != null ? customer.getId().toString() : null;
        return "Order{" + "id=" + id + ", customer=" + cust + ", pizzas=" + str
                + ", orderStatus=" + orderStatus + ", orderPrice=" + orderPrice
                + ", orderSize=" + orderSize + '}';
    }

    public enum OrderStatus {
        DONE(),
        CANCELED(),
        IN_PROGRES(CANCELED, DONE),
        NEW(IN_PROGRES, CANCELED);

        private final OrderStatus[] validTransitionStatuses;

        private OrderStatus(OrderStatus... validTransitionStatuses) {
            this.validTransitionStatuses = validTransitionStatuses;
        }

        public OrderStatus[] getValidTransitionStatuses() {
            return validTransitionStatuses;
        }

    }
}
