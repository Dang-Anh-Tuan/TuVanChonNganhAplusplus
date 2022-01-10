package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.ThongMinh;

@Repository
public interface ThongMinhRepo extends JpaRepository<ThongMinh, Integer>{

}
