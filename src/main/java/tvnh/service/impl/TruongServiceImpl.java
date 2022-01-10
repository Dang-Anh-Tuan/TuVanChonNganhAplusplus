package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tvnh.entity.Truong;
import tvnh.repo.TruongRepo;
import tvnh.service.TruongService;

@Service
public class TruongServiceImpl implements TruongService {

	@Autowired
	private TruongRepo repo;
	
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Truong> getAll() {
		return repo.findAll();
	}

}
