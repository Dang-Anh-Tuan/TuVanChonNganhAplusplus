package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.DiemThi;

@Repository
public interface DiemThiRepo extends JpaRepository<DiemThi, Integer>{

}
