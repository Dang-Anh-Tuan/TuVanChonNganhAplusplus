package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.CauHoi;
import tvnh.repo.CauHoiRepo;
import tvnh.service.CauHoiService;

@Service
public class CauHoiServiceImpl implements CauHoiService{

	@Autowired
	private CauHoiRepo repo;
	
	@Override
	public List<CauHoi> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean update(CauHoi cauHoi) {
		repo.save(cauHoi);
		return true;
	}

	@Override
	public CauHoi getById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public CauHoi save(CauHoi cauHoi) {
		return repo.save(cauHoi);
	}
	
	

}
