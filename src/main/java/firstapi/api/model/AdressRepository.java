package firstapi.api.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AdressRepository extends CrudRepository<Adress, String>{
}
