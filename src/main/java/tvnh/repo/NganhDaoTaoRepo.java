package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.NganhDaoTao;

@Repository
public interface NganhDaoTaoRepo extends JpaRepository<NganhDaoTao, Integer>{

}
