package pablo.tzeliks.infrastructure.persistence.repository;

import pablo.tzeliks.application.dto.CustomerDTO;
import pablo.tzeliks.domain.repository.CustomerRepository;
import pablo.tzeliks.infrastructure.persistence.dao.CustomerDao;

public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerDao customerDao;

    public CustomerRepositoryAdapter(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void save(CustomerDTO dto) {

        return customerDao.save(dto);

    }

}
