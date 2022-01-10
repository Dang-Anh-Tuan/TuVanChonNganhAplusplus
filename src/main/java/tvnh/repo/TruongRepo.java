package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Truong;

@Repository
public interface TruongRepo extends JpaRepository<Truong, Integer>{

}
