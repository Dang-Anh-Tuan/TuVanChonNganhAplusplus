package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.ChiSoThongMinh;

@Repository
public interface ChiSoThongMinhRepo extends JpaRepository<ChiSoThongMinh, Integer>{

}
