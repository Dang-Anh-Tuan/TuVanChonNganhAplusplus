package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.BanGhi;
import tvnh.entity.Nganh;
import tvnh.entity.ThongMinh;
import tvnh.entity.TinhCach;
import tvnh.entity.enums.Khoi;
import tvnh.entityUtil.KhaoSatInput;
import tvnh.service.BanGhiService;
import tvnh.service.KhaoSatService;
import tvnh.service.NganhService;
import tvnh.utils.Logic;

@Service
public class KhaoSatServiceImpl implements KhaoSatService{

	@Autowired
	private Logic logic;
	
	@Autowired
	private BanGhiService banGhiService;
	
	@Autowired
	private NganhService nganhService;
	
	@Override
	public boolean khaoSat(KhaoSatInput khaoSatInput) {
		List<Integer> idTralois = khaoSatInput.getIdTraLois();
		List<ThongMinh> thongMinhs = logic.xacDinhThongMinh(idTralois);
		List<TinhCach> tinhCachs = logic.xacDinhTinhCach(idTralois);
		
		String tenKhoi = khaoSatInput.getKhoi();
		Khoi khoi = Khoi.valueOf(tenKhoi);
		
		Integer idNganh = khaoSatInput.getIdNganh();
		Nganh nganh = nganhService.getById(idNganh);
		
		BanGhi banGhi = new BanGhi();
		banGhi.setKhoi(khoi);
		banGhi.setNganh(nganh);
		banGhi.setThongMinh(thongMinhs);
		banGhi.setTinhCach(tinhCachs);
		banGhiService.save(banGhi);
		return true;
	}

}
