package tvnh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import tvnh.entity.DiemThi;

@Repository
public interface DiemThiRepo extends JpaRepository<DiemThi, Integer>{

	@Query(value = "SELECT * FROM tuvannganhhoc.diem_thi where diem = :diem", nativeQuery = true)
	DiemThi findByDiem(@RequestParam("diem") Float diem);
}
