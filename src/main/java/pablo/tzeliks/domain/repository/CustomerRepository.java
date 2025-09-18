package pablo.tzeliks.domain.repository;

import pablo.tzeliks.application.dto.CustomerDTO;

import java.util.List;

public interface CustomerRepository {

    public void save(CustomerDTO customer);
    public void delete(CustomerDTO customer);
    public CustomerDTO findById(long id);
    public List<CustomerDTO> findAll();

}
