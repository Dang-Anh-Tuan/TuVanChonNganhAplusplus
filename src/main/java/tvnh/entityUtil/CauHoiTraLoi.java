package tvnh.entityUtil;

import java.util.List;

import lombok.Data;
import tvnh.entity.CauHoi;
import tvnh.entity.TraLoi;

@Data
public class CauHoiTraLoi {
	CauHoi cauHoi;
	List<TraLoi> traLois;

	public CauHoiTraLoi() {

	}

	public CauHoiTraLoi(CauHoi cauHoi, List<TraLoi> traLois) {
		this.cauHoi = cauHoi;
		this.traLois = traLois;
	}
}
