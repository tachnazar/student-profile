package se331.lab.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se331.lab.rest.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
