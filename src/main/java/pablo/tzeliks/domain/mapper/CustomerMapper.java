package pablo.tzeliks.domain.mapper;

import org.mapstruct.Mapper;
import pablo.tzeliks.application.dto.CustomerDTO;
import pablo.tzeliks.domain.model.entities.Customer;

@Mapper
public interface CustomerMapper {

    public Customer toEntity(CustomerDTO dto);
    public CustomerDTO toDTO(Customer entity);

}
