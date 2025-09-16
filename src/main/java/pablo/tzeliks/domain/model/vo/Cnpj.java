package pablo.tzeliks.domain.model.vo;

import pablo.tzeliks.domain.exception.DocumentException;

import java.util.Objects;

public class Cnpj implements Document {

    final String valor;

    public Cnpj(String valor) {

        if(validar(valor)) throw new DocumentException("O CNPJ inserido é inválido.");

        this.valor = valor;
    }

    private static boolean isValid(String cnpj) {
        String cleanedCnpj = cnpj.replaceAll("[^0-9]", "");

        // 1. Garante que o CNPJ tem 14 dígitos
        if (cleanedCnpj.length() != 14) {
            return false;
        }

        // 2. Garante que não é uma sequência de dígitos iguais
        if (cleanedCnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        try {
            // 3. Cálculo do primeiro dígito verificador
            int soma = 0;
            int peso = 5;
            for (int i = 0; i < 12; i++) {
                soma += Integer.parseInt(String.valueOf(cleanedCnpj.charAt(i))) * peso;
                peso--;
                if (peso < 2) {
                    peso = 9;
                }
            }
            int resto = soma % 11;
            int digito13 = (resto < 2) ? 0 : 11 - resto;

            if (Integer.parseInt(String.valueOf(cleanedCnpj.charAt(12))) != digito13) {
                return false;
            }

            // 4. Cálculo do segundo dígito verificador
            soma = 0;
            peso = 6;
            for (int i = 0; i < 13; i++) {
                soma += Integer.parseInt(String.valueOf(cleanedCnpj.charAt(i))) * peso;
                peso--;
                if (peso < 2) {
                    peso = 9;
                }
            }
            resto = soma % 11;
            int digito14 = (resto < 2) ? 0 : 11 - resto;

            return Integer.parseInt(String.valueOf(cleanedCnpj.charAt(13))) == digito14;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getValor() {
        return valor;
    }

    @Override
    public String getValorFormatado() {
        return this.valor.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }

    @Override
    public boolean validar(String valor) {
        return isValid(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cnpj cnpj = (Cnpj) o;
        return Objects.equals(valor, cnpj.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
