package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.CauHoi;

@Repository
public interface CauHoiRepo extends JpaRepository<CauHoi, Integer>{

}
