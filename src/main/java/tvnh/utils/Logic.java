package tvnh.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import tvnh.entity.BanGhi;
import tvnh.entity.ChiSoThongMinh;
import tvnh.entity.ChiSoTinhCach;
import tvnh.entity.ThongMinh;
import tvnh.entity.TinhCach;
import tvnh.entity.TraLoi;
import tvnh.entity.enums.Khoi;
import tvnh.entity.enums.ThuNhap;
import tvnh.entity.enums.XuHuong;
import tvnh.entityUtil.TuVanInput;
import tvnh.service.TraLoiService;

@Component
@ComponentScan
public class Logic {

	private final double chiSoLuaChonThongMinh = 0.5;
	private final double chiSoLuaChonTinhCach = 0.5;
	private final int trongSoKhoi = 10;
	private final int trongSoThongMinh = 8;
	private final int trongSoTinhCach = 8;
	private final int trongSoXuHuong = 5;
	private final int trongSoThuNhap = 3;
	
	

	@Autowired
	private TraLoiService traLoiService;
	

	public List<ThongMinh> xacDinhThongMinh(List<Integer> idTraLois) {
		List<ThongMinh> result = new ArrayList<>();

		List<TraLoi> traLois = new ArrayList<>();
		for (Integer id : idTraLois) {
			TraLoi traLoi = traLoiService.getByID(id);
			traLois.add(traLoi);
		}

		HashMap<ThongMinh, Integer> thongKeChiSoThongMinh = new HashMap<>();

		for (TraLoi traLoi : traLois) {
			List<ChiSoThongMinh> chiSoThongMinhs = traLoi.getChiSoThongMinh();

			for (ChiSoThongMinh chiSoThongMinh : chiSoThongMinhs) {
				ThongMinh thongMinh = chiSoThongMinh.getThongMinh();

				Integer chiSo = thongKeChiSoThongMinh.containsKey(thongMinh) ? thongKeChiSoThongMinh.get(thongMinh) : 0;
				chiSo += chiSoThongMinh.getChiSo();
				thongKeChiSoThongMinh.put(thongMinh, chiSo);
			}
		}

		Integer sumOfChiSoThongMinh = 0;
		for (Integer chiSo : thongKeChiSoThongMinh.values()) {
			sumOfChiSoThongMinh += chiSo;
		}

		LinkedHashMap<ThongMinh, Integer> thongKeSort = new LinkedHashMap<>();

		thongKeChiSoThongMinh.entrySet().stream()
				.sorted(Map.Entry.<ThongMinh, Integer>comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> thongKeSort.put(x.getKey(), x.getValue()));

		// test
		thongKeSort.forEach((key, value) -> System.out.println(key.getTen() + " " + value));
		System.out.println(sumOfChiSoThongMinh);

		Integer temp = 0;
		Iterator it = thongKeSort.entrySet().iterator();
		while (it.hasNext() && (temp < sumOfChiSoThongMinh * chiSoLuaChonThongMinh)) {
			Map.Entry thongMinhChiSo = (Map.Entry) it.next();
			result.add((ThongMinh) thongMinhChiSo.getKey());
			temp += (Integer) thongMinhChiSo.getValue();
		}

		return result;
	}

	public List<TinhCach> xacDinhTinhCach(List<Integer> idTraLois) {
		List<TinhCach> result = new ArrayList<>();

		List<TraLoi> traLois = new ArrayList<>();
		for (Integer id : idTraLois) {
			TraLoi traLoi = traLoiService.getByID(id);
			traLois.add(traLoi);
		}

		HashMap<TinhCach, Integer> thongKeChiSoTinhCach = new HashMap<>();

		for (TraLoi traLoi : traLois) {
			List<ChiSoTinhCach> chiSoTinhCachs = traLoi.getChiSoTinhCach();

			for (ChiSoTinhCach chiSoTinhCach : chiSoTinhCachs) {
				TinhCach tinhCach = chiSoTinhCach.getTinhCach();

				Integer chiSo = 
						thongKeChiSoTinhCach.containsKey(tinhCach) ? thongKeChiSoTinhCach.get(tinhCach) : 0;
				chiSo += chiSoTinhCach.getChiSo();
				thongKeChiSoTinhCach.put(tinhCach, chiSo);
			}
		}

		Integer sumOfChiSoTinhCach = 0;
		for (Integer chiSo : thongKeChiSoTinhCach.values()) {
			sumOfChiSoTinhCach += chiSo;
		}

		LinkedHashMap<TinhCach, Integer> thongKeSort = new LinkedHashMap<>();

		thongKeChiSoTinhCach.entrySet().stream()
				.sorted(Map.Entry.<TinhCach, Integer>comparingByValue(Comparator.reverseOrder()))
 				.forEachOrdered(x -> thongKeSort.put(x.getKey(), x.getValue()));

		// test
		thongKeSort.forEach((key, value) -> System.out.println(key.getTen() + " " + value));
		System.out.println(sumOfChiSoTinhCach);

		Integer temp = 0;
		Iterator it = thongKeSort.entrySet().iterator();
		while (it.hasNext() && (temp < sumOfChiSoTinhCach * chiSoLuaChonTinhCach)) {
			Map.Entry tinhCachhChiSo = (Map.Entry) it.next();
			result.add((TinhCach) tinhCachhChiSo.getKey());
			temp += (Integer) tinhCachhChiSo.getValue();
		}

		return result;
	}
	
	
	public double CBR(BanGhi banGhi, TuVanInput tuVanInput) {
		double result = 0;
		
		List<ThongMinh> inputThongMinh = xacDinhThongMinh(tuVanInput.getIdTraLois());
		List<TinhCach> inputTinhCach = xacDinhTinhCach(tuVanInput.getIdTraLois());
		
		Khoi khoiInput = Khoi.valueOf(tuVanInput.getKhoi());
		XuHuong xuHuongInput = XuHuong.valueOf(tuVanInput.getXuHuong());
		
		ThuNhap thuNhapInput;
		Integer thuNhap = tuVanInput.getThuNhap();
		if(thuNhap < 50000) {
			thuNhapInput = ThuNhap.THAP;
		}else if(thuNhap >= 50000 && thuNhap < 80000) {
			thuNhapInput = ThuNhap.TRUNGBINH;
		}else if(thuNhap >= 80000 && thuNhap < 100000 ) {
			thuNhapInput = ThuNhap.KHA;
		}else if(thuNhap >= 100000 && thuNhap < 150000) {
			thuNhapInput = ThuNhap.KHACAO;
		}else {
			thuNhapInput = ThuNhap.CAO;
		}
		
		List<ThongMinh> banGhiThongMinh = banGhi.getThongMinh();
		List<TinhCach> banGhiTinhCach = banGhi.getTinhCach();
		
		int soLuongThongMinh = 0;
		int soLuongTinhCach = 0;
		
		if(banGhiThongMinh.size() != 0) {
			for(ThongMinh thongMinh : banGhiThongMinh) {
				if(inputThongMinh.contains(thongMinh)) {
					soLuongThongMinh++;
				}
			}
			
			result += (soLuongThongMinh / banGhiThongMinh.size()) * trongSoThongMinh;
		}
		
		if(banGhiTinhCach.size() != 0) {
			for(TinhCach tinhCach : banGhiTinhCach) {
				if(inputTinhCach.contains(tinhCach)) {
					soLuongTinhCach++;
				}
			}
			
			result += (soLuongTinhCach / banGhiTinhCach.size()) * trongSoTinhCach;
		}
		
		if(banGhi.getNganh().getXuHuong() == xuHuongInput) {
			result += 1 * trongSoXuHuong;
		}
		
		if(banGhi.getKhoi() == khoiInput) {
			result += 1 * trongSoKhoi;
		}
		
		result += (1 - Math.abs(thuNhapInput.getTrongSo() - banGhi.getNganh().getThuNhap().getTrongSo())) 
					* trongSoThuNhap;
		
		Integer tongTrongSo = trongSoThongMinh + trongSoTinhCach + trongSoThuNhap + trongSoXuHuong + trongSoKhoi;
		
		result /= tongTrongSo;
		
		return result;
		
	}
}
