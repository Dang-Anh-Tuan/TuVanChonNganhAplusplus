package tvnh.service;

import java.util.List;

import tvnh.entity.NganhDaoTao;

public interface NganhDaoTaoService {
	List<NganhDaoTao> getAll();
	
	boolean save(NganhDaoTao nganhDaoTao);
	
	List<NganhDaoTao> getByTruong(Integer idTruong);
	
	List<NganhDaoTao> getByNganh(Integer idNganh);
}
