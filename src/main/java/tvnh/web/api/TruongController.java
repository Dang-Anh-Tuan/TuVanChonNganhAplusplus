package tvnh.web.api;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tvnh.entity.NganhDaoTao;
import tvnh.entity.Truong;
import tvnh.service.TruongService;

@RestController
@RequestMapping(path = "/api/truong", produces = "application/json")
@CrossOrigin(origins = "*")
public class TruongController {

	@Autowired
	TruongService truongService;
	
	@GetMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, 
						message = "get all truong", 
						responseContainer = "List", 
						response = Truong.class) })
	public ResponseEntity<List<Truong>> getAll() {
		List<Truong> truongs = truongService.getAll();
		return new ResponseEntity<>(truongs, HttpStatus.OK);
	}
}
