package tvnh.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.BanGhi;
import tvnh.repo.BanGhiRepo;
import tvnh.service.BanGhiService;

@Service
public class BanGhiServiceImpl implements BanGhiService{

	@Autowired
	private BanGhiRepo repo;
	
	@Override
	public List<BanGhi> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean save(BanGhi banGhi) {
		repo.save(banGhi);
		return true;
	}

}
