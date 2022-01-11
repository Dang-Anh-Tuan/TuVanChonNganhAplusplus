package tvnh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tvnh.entity.TraLoi;

import tvnh.entityUtil.TraLoiInput;
import tvnh.repo.TraLoiRepo;
import tvnh.service.CauHoiService;

import tvnh.service.TraLoiService;

@Service
public class TraLoiServiceImpl implements TraLoiService{

	@Autowired
	private TraLoiRepo repo;
	
	@Autowired
	private CauHoiService cauHoiService;
	
	@Override
	public List<TraLoi> getAll() {
		return repo.findAll();
	}

	@Override
	public List<TraLoi> getByCauHoi(Integer idCauHoi) {
		return repo.findByCauHoi(idCauHoi);
	}

	@Override
	public TraLoi getByID(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public TraLoi save(TraLoiInput traLoiInput) {
		TraLoi traLoi = new TraLoi();
		traLoi.setTraLoi(traLoiInput.getCauTraLoi());
		traLoi.setCauHoi(cauHoiService.getById(traLoiInput.getIdCauHoi()));
		return repo.save(traLoi);
	}

}
