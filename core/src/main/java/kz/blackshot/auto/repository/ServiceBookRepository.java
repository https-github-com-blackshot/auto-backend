package kz.blackshot.auto.repository;

import kz.blackshot.auto.model.ServiceBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBookRepository extends JpaRepository<ServiceBook,Integer> {
}
