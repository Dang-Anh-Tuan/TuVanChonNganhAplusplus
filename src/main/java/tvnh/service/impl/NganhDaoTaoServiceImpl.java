package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.NganhDaoTao;
import tvnh.repo.NganhDaoTaoRepo;
import tvnh.service.NganhDaoTaoService;

@Service
public class NganhDaoTaoServiceImpl implements NganhDaoTaoService{

	@Autowired
	private NganhDaoTaoRepo repo;
	
	@Override
	public List<NganhDaoTao> getAll() {
		return repo.findAll();
	}

}
