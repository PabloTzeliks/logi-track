package pablo.tzeliks.domain.model.entities;

import pablo.tzeliks.domain.model.vo.Cnh;
import pablo.tzeliks.domain.model.vo.VehiclePlate;

public class Driver {

    private long id;
    private String name;
    private Cnh cnh;
    private VehiclePlate vehiclePlate;
    private int baseCityId;

    public Driver(long id, String name, Cnh cnh, VehiclePlate vehiclePlate, int baseCityId) {
        this.id = id;
        this.name = name;
        this.cnh = cnh;
        this.vehiclePlate = vehiclePlate;
        this.baseCityId = baseCityId;
    }

    public Driver(String name, Cnh cnh, VehiclePlate vehiclePlate, int baseCityId) {
        this.name = name;
        this.cnh = cnh;
        this.vehiclePlate = vehiclePlate;
        this.baseCityId = baseCityId;
    }

    public long gentId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cnh getCnh() {
        return cnh;
    }

    public VehiclePlate getVehiclePlate() {
        return vehiclePlate;
    }

    public int getBaseCityId() {
        return baseCityId;
    }
}
