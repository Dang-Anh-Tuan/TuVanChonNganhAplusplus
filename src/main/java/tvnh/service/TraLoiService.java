package tvnh.service;

import java.util.List;

import tvnh.entity.TraLoi;
import tvnh.entityUtil.TraLoiInput;

public interface TraLoiService {
	List<TraLoi> getAll();
	
	List<TraLoi> getByCauHoi(Integer idCauHoi);
	
	TraLoi getByID(Integer id);

	TraLoi save(TraLoiInput traLoiInput);
}
