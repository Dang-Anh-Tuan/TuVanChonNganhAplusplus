package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.BanGhi;
import tvnh.service.BanGhiService;

@RestController
@RequestMapping(path = "/api/banghi", produces = "application/json")
@CrossOrigin(origins = "*")
public class BanGhiController {
	
	@Autowired
	private BanGhiService banGhiService;
	
	@GetMapping
	public List<BanGhi> getAll(){
		return banGhiService.getAll();
	}
	
	@PostMapping
	public boolean create(@RequestBody BanGhi banGhi) {
		return banGhiService.save(banGhi);
	}
	
}
