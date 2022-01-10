package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.TraLoi;
import tvnh.repo.TraLoiRepo;
import tvnh.service.TraLoiService;

@Service
public class TraLoiServiceImpl implements TraLoiService{

	@Autowired
	private TraLoiRepo repo;
	
	@Override
	public List<TraLoi> getAll() {
		return repo.findAll();
	}

}
