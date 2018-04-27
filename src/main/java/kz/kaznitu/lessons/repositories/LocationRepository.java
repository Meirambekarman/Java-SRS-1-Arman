package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Integer> {
    List<Location> findByCity (String city);
}
