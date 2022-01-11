package tvnh.service;

import tvnh.entity.CauHoi;

import java.util.List;

public interface CauHoiService {
	List<CauHoi> getAll();
	
	boolean update(CauHoi cauHoi);
	
	CauHoi getById(Integer id);
	
	CauHoi save(CauHoi cauHoi);
}
