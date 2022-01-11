package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.ChiSoTinhCach;
import tvnh.repo.ChiSoTinhCachRepo;
import tvnh.service.ChiSoTinhCachService;

@Service
public class ChiSoTinhCachServiceImpl implements ChiSoTinhCachService{

	@Autowired
	private ChiSoTinhCachRepo repo;
	
	@Override
	public List<ChiSoTinhCach> getAll() {
		return repo.findAll();
	}

	@Override
	public ChiSoTinhCach save(ChiSoTinhCach chiSoTinhCach) {
		return repo.save(chiSoTinhCach);
	}

}
