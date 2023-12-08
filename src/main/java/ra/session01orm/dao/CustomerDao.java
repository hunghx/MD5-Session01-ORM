package ra.session01orm.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ra.session01orm.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    // lấy tất cả
    public List<Customer> findAll(){
        return entityManager.createQuery("select C from Customer c", Customer.class)
                .getResultList();
    }
    // lấy theo id
    public Customer findById(Long id){
        return entityManager.find(Customer.class,id);
    }

    // vừa thêm mới vừa cập nhật
    // lưu ý , các thao tác chỉnh sửa dữ liệu sẽ phải có transaction
    @Transactional
    public void save(Customer customer){        Session session = null;
        if (customer.getId()==null){
            entityManager.persist(customer);
        }else {
            entityManager.merge(customer);
        }
    }
    @Transactional
    public void delete(Long id){
        entityManager.remove(findById(id));
    }

}
