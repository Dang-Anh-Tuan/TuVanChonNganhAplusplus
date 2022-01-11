package tvnh.service;

import java.util.List;

import tvnh.entity.TinhCach;

public interface TinhCachService {
	List<TinhCach> getAll();
	
	TinhCach getById(Integer id);
}
