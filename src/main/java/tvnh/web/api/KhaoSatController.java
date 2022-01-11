package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.TinhCach;
import tvnh.entityUtil.KhaoSatInput;
import tvnh.entityUtil.TraLoiIds;
import tvnh.service.KhaoSatService;
import tvnh.utils.Logic;

@RestController
@RequestMapping(path = "/api/khaosat", produces = "application/json")
@CrossOrigin(origins = "*")
public class KhaoSatController {

	@Autowired
	private Logic logic;
	
	@Autowired
	private KhaoSatService khaoSatService;
	
	@PostMapping
	public boolean khaoSat(@RequestBody KhaoSatInput khaoSatInput) {
		return khaoSatService.khaoSat(khaoSatInput);
	}
	
//	@PostMapping
//	public List<ThongMinh> timThongMinh(@RequestBody TraLoiIds traLoiIds){
//		return logic.xacDinhThongMinh(traLoiIds.getIds());
//	}
	
	@PostMapping("/timtinhcach")
	public List<TinhCach> timTTinhCah(@RequestBody TraLoiIds traLoiIds){
		return logic.xacDinhTinhCach(traLoiIds.getIds());
	}
}
