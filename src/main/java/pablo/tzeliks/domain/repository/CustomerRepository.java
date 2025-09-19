package pablo.tzeliks.domain.repository;

import pablo.tzeliks.domain.model.entities.Customer;
import pablo.tzeliks.domain.model.vo.Document;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);
    Customer update(Customer customer);
    void deleteById(Long id);
    Optional<Customer> findById(Long id);
    Optional<Customer> findByDocument(Document document);
    List<Customer> findAll();
}