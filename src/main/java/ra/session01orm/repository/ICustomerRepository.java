package ra.session01orm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.session01orm.model.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
