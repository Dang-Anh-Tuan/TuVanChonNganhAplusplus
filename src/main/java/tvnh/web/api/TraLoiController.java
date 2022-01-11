package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.TraLoi;
import tvnh.entityUtil.TraLoiInput;
import tvnh.service.TraLoiService;

@RestController
@RequestMapping(path = "/api/traloi", produces = "application/json")
@CrossOrigin(origins = "*")
public class TraLoiController {

	@Autowired
	private TraLoiService traLoiService;
	
	
	@GetMapping("/{id}")
	public List<TraLoi> getByCauHoi(@PathVariable("id") Integer idCauHoi){
		return traLoiService.getByCauHoi(idCauHoi);
	}
	
	@PostMapping
	public TraLoi createTraLoi(@RequestBody TraLoiInput traLoiInput) {
		return traLoiService.save(traLoiInput);
	}
}
