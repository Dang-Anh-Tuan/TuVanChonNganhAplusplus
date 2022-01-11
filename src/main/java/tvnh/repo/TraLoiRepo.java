package tvnh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import tvnh.entity.TraLoi;

@Repository
public interface TraLoiRepo extends JpaRepository<TraLoi, Integer>{

	@Query(value = "SELECT * FROM tuvannganhhoc.tra_loi WHERE cau_hoi_id = :idCauHoi", nativeQuery = true)
	List<TraLoi> findByCauHoi(@RequestParam("idCauHoi") Integer idCauHoi);
}
