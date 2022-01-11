package tvnh.service;

import java.util.List;

import tvnh.entity.DiemThi;

public interface DiemThiService {
	List<DiemThi> getAll();
	
	DiemThi getByDiem(Float diem);
	
	DiemThi save(DiemThi diemThi);
}
