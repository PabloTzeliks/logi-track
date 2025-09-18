package pablo.tzeliks.domain.model.vo;

import java.io.Serializable;
import java.util.Objects;

public final class VehiclePlate implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String plate;

    public VehiclePlate(String plate) {
        // Limpa espaços e padroniza para maiúsculas
        String normalized = plate == null ? "" : plate.trim().toUpperCase();
        if (!isValidPlate(normalized)) {
            throw new IllegalArgumentException("Placa de veículo inválida: " + plate);
        }
        this.plate = normalized;
    }

    private boolean isValidPlate(String plate) {
        // Regex para placas antigas (ABC-1234) e Mercosul (ABC1D23)
        String oldPattern = "^[A-Z]{3}-\\d{4}$";
        String mercosulPattern = "^[A-Z]{3}\\d[A-Z]\\d{2}$";
        return plate.matches(oldPattern) || plate.matches(mercosulPattern);
    }

    public String getValue() {
        return plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehiclePlate)) return false;
        VehiclePlate that = (VehiclePlate) o;
        return Objects.equals(plate, that.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate);
    }

    @Override
    public String toString() {
        return plate;
    }
}