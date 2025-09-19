package pablo.tzeliks.application.dto;

import pablo.tzeliks.domain.model.vo.Address;
import pablo.tzeliks.domain.model.vo.Cnpj;
import pablo.tzeliks.domain.model.vo.Cpf;

public record CustomerResponseDTO(long id, String name, Cpf cpf, Cnpj cnpj, Address address) {
}
