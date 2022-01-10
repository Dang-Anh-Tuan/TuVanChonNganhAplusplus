package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.TraLoi;

@Repository
public interface TraLoiRepo extends JpaRepository<TraLoi, Integer>{

}
