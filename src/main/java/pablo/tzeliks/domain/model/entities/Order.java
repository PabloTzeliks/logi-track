package pablo.tzeliks.domain.model.entities;

import pablo.tzeliks.domain.model.enums.OrderStatus;
import pablo.tzeliks.domain.model.vo.Address;

import java.time.LocalDate;

public class Order {

    private long id;
    private long customerId;
    private LocalDate orderDate;
    private double volumeM3;
    private double weightKg;
    private Address address;
    private OrderStatus status;

    public Order(long id, long customerId, LocalDate orderDate, double volumeM3, double weightKg, Address address, OrderStatus status) {
        this.customerId = customerId;
        this.id = id;
        this.orderDate = orderDate;
        this.volumeM3 = volumeM3;
        this.weightKg = weightKg;
        this.address = address;
        this.status = status;
    }

    public Order(long customerId, LocalDate orderDate, double volumeM3, double weightKg, Address address, OrderStatus status) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.volumeM3 = volumeM3;
        this.weightKg = weightKg;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
