package tvnh.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entityUtil.TuVanInput;
import tvnh.entityUtil.TuVanResult;
import tvnh.service.TuVanService;

@RestController
@RequestMapping(path = "/api/tuvan", produces = "application/json")
@CrossOrigin(origins = "*")
public class TuVanController {
	
	@Autowired
	private TuVanService tuVanService;
	
	@PostMapping
	public TuVanResult tuVan(@RequestBody TuVanInput tuVanInput) {
		TuVanResult tuVanResult = new TuVanResult();
		
		tuVanResult = tuVanService.tuVan(tuVanInput);
		
		return tuVanResult;
	}
}
