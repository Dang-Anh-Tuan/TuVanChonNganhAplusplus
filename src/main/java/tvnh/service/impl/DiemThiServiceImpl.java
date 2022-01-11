package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.DiemThi;
import tvnh.repo.DiemThiRepo;
import tvnh.service.DiemThiService;

@Service
public class DiemThiServiceImpl implements DiemThiService{

	@Autowired
	private DiemThiRepo repo;
	
	@Override
	public List<DiemThi> getAll() {
		return repo.findAll();
	}

	@Override
	public DiemThi getByDiem(Float diem) {
		return repo.findByDiem(diem);
	}

	@Override
	public DiemThi save(DiemThi diemThi) {
		return repo.save(diemThi);
	}

}
