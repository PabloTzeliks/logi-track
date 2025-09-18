package pablo.tzeliks.domain.model.vo;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public final class Cep implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Pattern PATTERN = Pattern.compile("^\\d{5}-?\\d{3}$");

    private final String value;

    public Cep(String value) {
        if (value == null || !PATTERN.matcher(value.trim()).matches()) {
            throw new IllegalArgumentException("Invalid CEP format: " + value);
        }
        // Normalize to XXXXX-XXX format
        this.value = normalize(value);
    }

    private String normalize(String cep) {
        String digits = cep.replaceAll("[^\\d]", "");
        return digits.substring(0, 5) + "-" + digits.substring(5, 8);
    }

    public String getValue() {
        return value;
    }

    public String getDigits() {
        return value.replace("-", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cep)) return false;
        Cep cep = (Cep) o;
        return Objects.equals(value, cep.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}