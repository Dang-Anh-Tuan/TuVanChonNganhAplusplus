package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.TinhCach;

@Repository
public interface TinhCachRepo extends JpaRepository<TinhCach, Integer>{

}
