package co.cue.edu.ticventory.ticventory.inventory.repository;

import co.cue.edu.ticventory.ticventory.inventory.model.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {

    // Método para encontrar un recurso por código
    Resource findByCode(String code);

    // delete personalizado. MongoRepository tiene deleteById y deleteByCode.
    void deleteByCode(String code);  // Método para eliminar por código
}
