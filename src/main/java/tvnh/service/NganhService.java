package tvnh.service;

import java.util.List;

import tvnh.entity.Nganh;

public interface NganhService {
	List<Nganh> getAll();
	
	public boolean update(Nganh nganh);
	
	Nganh getById(Integer id);
}
