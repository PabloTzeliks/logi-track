package pablo.tzeliks.domain.model.entities;

import java.util.Date;

public class Delivery {

    private long id;
    private long orderId;
    private long driverId;
    private Date departureDate;
    private Date deliveryDate;
    private DeliveryStatus status;

}
