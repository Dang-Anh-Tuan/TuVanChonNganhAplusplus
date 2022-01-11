package tvnh.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.TinhCach;
import tvnh.repo.TinhCachRepo;
import tvnh.service.TinhCachService;

@Service
public class TinhCachServiceImpl implements TinhCachService{

	@Autowired
	private TinhCachRepo repo;
	
	@Override
	public List<TinhCach> getAll() {
		return repo.findAll();
	}

	@Override
	public TinhCach getById(Integer id) {
		return repo.findById(id).get();
	}

}
