package ra.session01orm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.session01orm.model.Customer;
public interface ICustomerService {
    Page<Customer> findAll (Pageable pageable);
    Page<Customer> findAllByName (String name, Pageable pageable);
    Customer save(Customer customer);
    void deleteById(Long id);
}
