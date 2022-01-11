package tvnh.web.api;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.CauHoi;
import tvnh.entityUtil.CauHoiTraLoi;
import tvnh.service.CauHoiService;

@RestController
@RequestMapping(path = "/api/cauhoi", produces = "application/json")
@CrossOrigin(origins = "*")
public class CauHoiController {

	@Autowired
	private CauHoiService cauHoiService;
	
	
	@GetMapping
	public List<CauHoiTraLoi> getAll(){
		List<CauHoiTraLoi> result = new ArrayList<>();
		List<CauHoi> cauHois = cauHoiService.getAll();
		for(CauHoi cauHoi : cauHois) {
			result.add(new CauHoiTraLoi(cauHoi, cauHoi.getTraLoi()));
		}
		return result;
	}
	
	@PutMapping
	public boolean update(@RequestBody CauHoi cauHoi) {
		return cauHoiService.update(cauHoi);
	}
	
	@PostMapping
	public CauHoi create(@RequestBody CauHoi cauHoi) {
		return cauHoiService.save(cauHoi);
	}
	
}
