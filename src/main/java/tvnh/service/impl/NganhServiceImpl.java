package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Nganh;
import tvnh.repo.NganhRepo;
import tvnh.service.NganhService;

@Service
public class NganhServiceImpl implements NganhService{

	@Autowired
	private NganhRepo repo;
	
	@Override
	public List<Nganh> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean update(Nganh nganh) {
		repo.save(nganh);
		return true;
	}

	@Override
	public Nganh getById(Integer id) {
		return repo.findById(id).get();
	}

}
