package pablo.tzeliks.domain.model.vo;

import pablo.tzeliks.domain.exception.DocumentException;

import java.util.Objects;

public class Cnh implements Document {

    final String value;

    public Cnh(String value) {

        if(validate(value)) throw new DocumentException("O CNH inserido é inválido.");

        this.value = value;
    }

    private static boolean isValid(String cnh) {
        String cleanedCnh = cnh.replaceAll("[^0-9]", "");

        // 1. Garante que a CNH tem 11 dígitos
        if (cleanedCnh.length() != 11) {
            return false;
        }

        // 2. Garante que não é uma sequência de dígitos iguais
        if (cleanedCnh.matches("(\\d)\\1{10}")) {
            return false;
        }

        return true;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getFormattedValue() {
        return this.value;
    }

    @Override
    public boolean validate(String value) {
        return isValid(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cnh cnh = (Cnh) o;
        return Objects.equals(value, cnh.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
