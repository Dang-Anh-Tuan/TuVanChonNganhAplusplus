package tvnh.service;

import java.util.List;

import tvnh.entity.ThongMinh;

public interface ThongMinhService {
	List<ThongMinh> getAll();
	
	ThongMinh getById(Integer id);
}
