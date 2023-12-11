package ra.session01orm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.session01orm.model.Customer;
import ra.session01orm.repository.ICustomerRepository;

import java.time.LocalDate;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private  ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        // custom
        pageable = PageRequest.of(pageable.getPageNumber(),1,pageable.getSort());
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        pageable = PageRequest.of(3,2);
        return iCustomerRepository.findByNameContaining(name, pageable) ;
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        iCustomerRepository.deleteById(id);
    }
}
