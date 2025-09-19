package pablo.tzeliks.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import pablo.tzeliks.application.dto.CustomerResponseDTO;
import pablo.tzeliks.domain.model.entities.Customer;
import pablo.tzeliks.domain.model.vo.Address;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "entity", target = "document", qualifiedByName = "mapDocumentToString")
    @Mapping(source = "entity.address", target = "fullAddress", qualifiedByName = "mapAddressToString")
    CustomerResponseDTO toResponseDTO(Customer entity);

    @Named("mapDocumentToString")
    default String mapDocumentToString(Customer customer) {
        if (customer.getCpf() != null) {
            return customer.getCpf().getFormattedValue();
        }
        if (customer.getCnpj() != null) {
            return customer.getCnpj().getFormattedValue();
        }
        return null;
    }

    @Named("mapAddressToString")
    default String mapAddressToString(Address address) {
        if (address == null) {
            return null;
        }

        String complement = address.getAddressComplement() != null && !address.getAddressComplement().isBlank() ?
                ", " + address.getAddressComplement() : "";

        return String.format("%s, %s%s - %s. CEP: %s",
                address.getStreetAddress(),
                address.getStreetNumber(),
                complement,
                address.getNeighborhood(),
                address.getZipCode());
    }
}