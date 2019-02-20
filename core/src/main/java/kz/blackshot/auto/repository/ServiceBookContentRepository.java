package kz.blackshot.auto.repository;

import kz.blackshot.auto.model.ServiceBookContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBookContentRepository extends JpaRepository<ServiceBookContent, Integer> {
}
