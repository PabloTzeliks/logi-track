package pablo.tzeliks.domain.model.vo;

import pablo.tzeliks.domain.exception.DocumentException;

import java.util.Objects;

public class Cpf implements Document {

    final String valor;

    public Cpf(String valor) {

        if(validar(valor)) throw new DocumentException("O CPF inserido é inválido.");

        this.valor = valor;
    }

    private static boolean isValid(String cpf) {
        String cleanedCpf = cpf.replaceAll("[^0-9]", "");

        // 1. Garante que o CPF tem 11 dígitos
        if (cleanedCpf.length() != 11) {
            return false;
        }

        // 2. Garante que não é uma sequência de dígitos iguais (ex: 111.111.111-11)
        if (cleanedCpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // 3. Cálculo do primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Integer.parseInt(String.valueOf(cleanedCpf.charAt(i))) * (10 - i);
            }
            int resto = soma % 11;
            int digito10 = (resto < 2) ? 0 : 11 - resto;

            if (Integer.parseInt(String.valueOf(cleanedCpf.charAt(9))) != digito10) {
                return false;
            }

            // 4. Cálculo do segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Integer.parseInt(String.valueOf(cleanedCpf.charAt(i))) * (11 - i);
            }
            resto = soma % 11;
            int digito11 = (resto < 2) ? 0 : 11 - resto;

            return Integer.parseInt(String.valueOf(cleanedCpf.charAt(10))) == digito11;

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
        return this.valor.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    @Override
    public boolean validar(String valor) {
        return isValid(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(valor, cpf.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

}
