package pablo.tzeliks.domain.model.entities;

import java.util.Date;

public class DeliveryHistory {

    private long id;
    private long deliveryId;
    private Date eventDate;
    private String description;

    public DeliveryHistory(long id, long deliveryId, Date eventDate, String description) {
        this.id = id;
        this.deliveryId = deliveryId;
        this.eventDate = eventDate;
        this.description = description;
    }

    public DeliveryHistory(long deliveryId, Date eventDate, String description) {
        this.deliveryId = deliveryId;
        this.eventDate = eventDate;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}