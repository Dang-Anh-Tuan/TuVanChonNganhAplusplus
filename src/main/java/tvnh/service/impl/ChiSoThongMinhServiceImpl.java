package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.ChiSoThongMinh;
import tvnh.repo.ChiSoThongMinhRepo;
import tvnh.service.ChiSoThongMinhService;

@Service
public class ChiSoThongMinhServiceImpl implements ChiSoThongMinhService{

	@Autowired
	private ChiSoThongMinhRepo repo;
	
	@Override
	public List<ChiSoThongMinh> getAll() {
		return repo.findAll();
	}

}
