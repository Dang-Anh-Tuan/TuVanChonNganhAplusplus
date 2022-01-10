package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.BanGhi;

@Repository
public interface BanGhiRepo extends JpaRepository<BanGhi, Integer>{

}
