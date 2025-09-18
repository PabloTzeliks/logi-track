package pablo.tzeliks.domain.model.entities;

import pablo.tzeliks.domain.model.enums.DeliveryStatus;

import java.time.LocalDate;

public class Delivery {

    private long id;
    private long orderId;
    private long driverId;
    private LocalDate departureDate;
    private LocalDate deliveryDate;
    private DeliveryStatus status;

    public Delivery(long id, long orderId, long driverId, LocalDate departureDate, LocalDate deliveryDate, DeliveryStatus status) {
        this.id = id;
        this.orderId = orderId;
        this.driverId = driverId;
        this.departureDate = departureDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public Delivery(long orderId, long driverId, LocalDate departureDate, LocalDate deliveryDate, DeliveryStatus status) {
        this.orderId = orderId;
        this.driverId = driverId;
        this.departureDate = departureDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getDriverId() {
        return driverId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
