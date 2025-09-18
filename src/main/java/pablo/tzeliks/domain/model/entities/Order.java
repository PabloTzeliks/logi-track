package pablo.tzeliks.domain.model.entities;

import java.util.Date;

public class Order {

    private long id;
    private long customerId;
    private Date orderDate;
    private double volumeM3;
    private double weightKg;
    private String deliveryStreetAddress;
    private String deliveryStreetNumber;
    private String deliveryNeighborhood;
    private String deliveryZipCode;
    private String deliveryAddressComplement;
    private int deliveryCityId;
    private OrderStatus status;


}
