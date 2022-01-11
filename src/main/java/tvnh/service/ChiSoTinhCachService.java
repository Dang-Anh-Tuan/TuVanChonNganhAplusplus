package tvnh.service;

import java.util.List;

import tvnh.entity.ChiSoTinhCach;
import tvnh.entityUtil.ChiSoTinhCachInput;

public interface ChiSoTinhCachService {
	List<ChiSoTinhCach> getAll();
	
	ChiSoTinhCach save(ChiSoTinhCachInput chiSoTinhCachInput);
}
