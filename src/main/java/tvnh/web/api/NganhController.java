package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Nganh;
import tvnh.service.NganhService;

@RestController
@RequestMapping(path = "/api/nganh", produces = "application/json")
@CrossOrigin(origins = "*")
public class NganhController {

	@Autowired
	private NganhService nganhService;
	
	@GetMapping
	public List<Nganh> getAll(){
		return nganhService.getAll();
	}
	
	@PutMapping
	public boolean updateNganhs(@RequestBody List<Nganh> nganhs) {
		for(Nganh nganh : nganhs) {
			nganhService.update(nganh);
		}
		return true;
	}
}
