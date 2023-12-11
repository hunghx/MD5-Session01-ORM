package ra.session01orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.session01orm.model.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
