package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.ChiSoTinhCach;
import tvnh.entityUtil.ChiSoTinhCachInput;
import tvnh.repo.ChiSoTinhCachRepo;
import tvnh.service.ChiSoTinhCachService;
import tvnh.service.TinhCachService;
import tvnh.service.TraLoiService;

@Service
public class ChiSoTinhCachServiceImpl implements ChiSoTinhCachService{

	@Autowired
	private ChiSoTinhCachRepo repo;
	
	@Autowired
	private TraLoiService traLoiService;
	
	@Autowired
	private TinhCachService tinhCachService;
	
	@Override
	public List<ChiSoTinhCach> getAll() {
		return repo.findAll();
	}

	@Override
	public ChiSoTinhCach save(ChiSoTinhCachInput chiSoTinhCachInput) {
		ChiSoTinhCach chiSoTinhCach = new ChiSoTinhCach();
		chiSoTinhCach.setChiSo(chiSoTinhCachInput.getChiSo());
		chiSoTinhCach.setTinhCach(tinhCachService.getById(chiSoTinhCachInput.getIdTinhCach()));
		chiSoTinhCach.setTraLoi(traLoiService.getByID(chiSoTinhCachInput.getIdTraLoi()));
		return repo.save(chiSoTinhCach);
	}

}
