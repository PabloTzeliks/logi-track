package pablo.tzeliks.domain.model.vo;

import java.io.Serializable;
import java.util.Objects;

public final class Address implements Serializable {
    private final String streetAddress;
    private final String streetNumber;
    private final String neighborhood;
    private final Cep zipCode; // Or String if you prefer
    private final String addressComplement; // nullable
    private final Long cityId;

    public Address(String streetAddress,
                   String streetNumber,
                   String neighborhood,
                   Cep zipCode,
                   String addressComplement,
                   Long cityId) {
        if (streetAddress == null || streetNumber == null || neighborhood == null || zipCode == null || cityId == null) {
            throw new IllegalArgumentException("Required fields for Address cannot be null.");
        }
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.addressComplement = addressComplement;
        this.cityId = cityId;
    }

    public String getStreetAddress() { return streetAddress; }
    public String getStreetNumber() { return streetNumber; }
    public String getNeighborhood() { return neighborhood; }
    public Cep getZipCode() { return zipCode; }
    public String getAddressComplement() { return addressComplement; }
    public Long getCityId() { return cityId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(streetAddress, address.streetAddress) &&
                Objects.equals(streetNumber, address.streetNumber) &&
                Objects.equals(neighborhood, address.neighborhood) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(addressComplement, address.addressComplement) &&
                Objects.equals(cityId, address.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, streetNumber, neighborhood, zipCode, addressComplement, cityId);
    }

    @Override
    public String toString() {
        return streetAddress + ", " + streetNumber + " - " + neighborhood +
                ", " + zipCode +
                (addressComplement != null ? " (" + addressComplement + ")" : "") +
                " - City ID: " + cityId;
    }
}
