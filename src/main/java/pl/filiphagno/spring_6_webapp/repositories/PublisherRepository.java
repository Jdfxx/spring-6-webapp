package pl.filiphagno.spring_6_webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.filiphagno.spring_6_webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
