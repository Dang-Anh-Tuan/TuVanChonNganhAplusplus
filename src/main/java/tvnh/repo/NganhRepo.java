package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Nganh;

@Repository
public interface NganhRepo extends JpaRepository<Nganh, Integer>{

}
