package tvnh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import tvnh.entity.NganhDaoTao;

@Repository
public interface NganhDaoTaoRepo extends JpaRepository<NganhDaoTao, Integer>{
	@Query(value = "SELECT * FROM tuvannganhhoc.nganh_dao_tao WHERE truong_id = :idTruong", nativeQuery = true)
	List<NganhDaoTao> findByTruong(@RequestParam("idTruong") Integer idTruong);
	
	@Query(value = "SELECT * FROM tuvannganhhoc.nganh_dao_tao WHERE nganh_id = :idNganh", nativeQuery = true)
	List<NganhDaoTao> findByNganh(@RequestParam("idNganh") Integer idNganh);
}
