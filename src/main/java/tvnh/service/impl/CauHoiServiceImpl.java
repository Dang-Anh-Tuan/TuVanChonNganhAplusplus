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

}
