package tvnh.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.ChiSoTinhCach;
import tvnh.entityUtil.ChiSoTinhCachInput;
import tvnh.service.ChiSoTinhCachService;

@RestController
@RequestMapping(path = "/api/chisotinhcach", produces = "application/json")
@CrossOrigin(origins = "*")
public class ChiSoTinhCachController {

	@Autowired
	private ChiSoTinhCachService chiSoTinhCachService;
	
	@PostMapping
	public ChiSoTinhCach create(@RequestBody ChiSoTinhCachInput chiSoTinhCachInput) {
		return chiSoTinhCachService.save(chiSoTinhCachInput);
	}
}
