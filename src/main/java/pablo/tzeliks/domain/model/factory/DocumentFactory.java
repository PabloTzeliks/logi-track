package pablo.tzeliks.domain.model.factory;

import pablo.tzeliks.domain.exception.DocumentException;
import pablo.tzeliks.domain.model.vo.Cnh;
import pablo.tzeliks.domain.model.vo.Cnpj;
import pablo.tzeliks.domain.model.vo.Cpf;
import pablo.tzeliks.domain.model.vo.Document;

public class DocumentFactory {

    public static Document createCpfOrCnpj(String documentNumber) {
        if (documentNumber == null) {
            throw new DocumentException("Número do documento não pode ser nulo.");
        }

        String cleaned = documentNumber.replaceAll("[^0-9]", "");

        if (cleaned.length() == 11) {
            return new Cpf(cleaned); // O construtor do Cpf fará a validação final
        } else if (cleaned.length() == 14) {
            return new Cnpj(cleaned); // O construtor do Cnpj fará a validação final
        } else {
            throw new DocumentException("Número de documento inválido. Deve ter 11 (CPF) ou 14 (CNPJ) dígitos.");
        }
    }

    public static Cnh createCnh(String CnhNumber) {

        if (CnhNumber == null) {
            throw new DocumentException("Número do documento não pode ser nulo.");
        }

        String cleaned = CnhNumber.replaceAll("[^0-9]", "");

        return new Cnh(CnhNumber);
    }

}
