package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.ThongMinh;
import tvnh.repo.ThongMinhRepo;
import tvnh.service.ThongMinhService;

@Service
public class ThongMinhServiceImpl implements ThongMinhService{

	@Autowired
	private ThongMinhRepo repo;
	
	@Override
	public List<ThongMinh> getAll() {
		return repo.findAll();
	}

	@Override
	public ThongMinh getById(Integer id) {
		return repo.findById(id).get();
	}

}
