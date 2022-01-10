package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.ChiSoTinhCach;

@Repository
public interface ChiSoTinhCachRepo extends JpaRepository<ChiSoTinhCach, Integer>{

}
