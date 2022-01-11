package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.service.DiemThiService;
import tvnh.service.NganhDaoTaoService;
import tvnh.entity.DiemThi;
import tvnh.entity.NganhDaoTao;
import tvnh.entityUtil.NganhDaoTaoInput;

@RestController
@RequestMapping(path = "/api/nganhdaotao", produces = "application/json")
@CrossOrigin(origins = "*")
public class NganhDaoTaoController {

	@Autowired
	NganhDaoTaoService nganhDaoTaoService;
	
	@Autowired
	DiemThiService diemThiService;
	
	@GetMapping
	public List<NganhDaoTao> getAll(){
		return nganhDaoTaoService.getAll();
	}
	
	@PostMapping
	public boolean create(@RequestBody NganhDaoTaoInput nganhDaoTaoInput) {
		NganhDaoTao nganhDaoTao = new NganhDaoTao();
		nganhDaoTao.setNganh(nganhDaoTaoInput.getNganh());
		nganhDaoTao.setTruong(nganhDaoTaoInput.getTruong());
		
		DiemThi diemThi = diemThiService.getByDiem(nganhDaoTaoInput.getDiem());
		if(diemThi != null) {
			nganhDaoTao.setDiemThi(diemThi);
		}else {
			DiemThi newDiemThi = new DiemThi();
			newDiemThi.setDiem(nganhDaoTaoInput.getDiem());
			nganhDaoTao.setDiemThi(diemThiService.save(newDiemThi));
		}
		
		return nganhDaoTaoService.save(nganhDaoTao);
	}
	
	@PutMapping
	public boolean update(@RequestBody NganhDaoTao nganhDaoTao) {
		DiemThi newDiemThi = new DiemThi();
		newDiemThi.setDiem(nganhDaoTao.getDiemThi().getDiem());
		nganhDaoTao.setDiemThi(diemThiService.save(newDiemThi));
		return nganhDaoTaoService.save(nganhDaoTao);
	}
	
	@GetMapping("/{id}")
	public List<NganhDaoTao> getByTruong(@PathVariable(name = "id") Integer idTruong){
		return nganhDaoTaoService.getByTruong(idTruong);
	}
}
