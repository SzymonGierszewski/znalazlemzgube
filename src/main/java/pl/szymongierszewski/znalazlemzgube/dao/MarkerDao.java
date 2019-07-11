package pl.szymongierszewski.znalazlemzgube.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymongierszewski.znalazlemzgube.model.Marker;

@Repository
public interface MarkerDao extends CrudRepository<Marker, Long> {

}
