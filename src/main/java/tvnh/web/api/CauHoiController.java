package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.CauHoi;
import tvnh.service.CauHoiService;

@RestController
@RequestMapping(path = "/api/cauhoi", produces = "application/json")
@CrossOrigin(origins = "*")
public class CauHoiController {

	@Autowired
	private CauHoiService cauHoiService;
	
	@GetMapping
	public List<CauHoi> getAll(){
		return cauHoiService.getAll();
	}
	
	@PostMapping 
	public void readCauHoi(@RequestBody List<CauHoi> cauHois) {
		for(CauHoi cauHoi : cauHois) {
			System.out.println(cauHoi.getId() + " " + cauHoi.getCauHoi());
		}
	}
}
