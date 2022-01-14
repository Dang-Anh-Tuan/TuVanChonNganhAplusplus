package tvnh.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.BanGhi;
import tvnh.entity.Nganh;
import tvnh.entity.NganhDaoTao;
import tvnh.entity.ThongMinh;
import tvnh.entity.TinhCach;
import tvnh.entity.enums.Khoi;
import tvnh.entity.enums.ThuNhap;
import tvnh.entity.enums.XuHuong;
import tvnh.entityUtil.TuVanInput;
import tvnh.entityUtil.TuVanResult;
import tvnh.service.BanGhiService;
import tvnh.service.NganhDaoTaoService;
import tvnh.service.TuVanService;
import tvnh.utils.Logic;

@Service
public class TuVanServiceImpl implements TuVanService {

	@Autowired
	private BanGhiService banGhiService;

	@Autowired
	private NganhDaoTaoService nganhDaoTaoService;

	@Autowired
	private Logic logic;

	@Override
	public TuVanResult tuVan(TuVanInput tuVanInput) {

		TuVanResult result = new TuVanResult();

		List<ThongMinh> inputThongMinh = logic.xacDinhThongMinh(tuVanInput.getIdTraLois());
		List<TinhCach> inputTinhCach = logic.xacDinhTinhCach(tuVanInput.getIdTraLois());

		Khoi khoiInput = Khoi.valueOf(tuVanInput.getKhoi());
		XuHuong xuHuongInput = XuHuong.valueOf(tuVanInput.getXuHuong());

		ThuNhap thuNhapInput;
		Integer thuNhap = tuVanInput.getThuNhap();
		if (thuNhap < 50000) {
			thuNhapInput = ThuNhap.THAP;
		} else if (thuNhap >= 50000 && thuNhap < 80000) {
			thuNhapInput = ThuNhap.TRUNGBINH;
		} else if (thuNhap >= 80000 && thuNhap < 100000) {
			thuNhapInput = ThuNhap.KHA;
		} else if (thuNhap >= 100000 && thuNhap < 150000) {
			thuNhapInput = ThuNhap.KHACAO;
		} else {
			thuNhapInput = ThuNhap.CAO;
		}

		List<BanGhi> banGhis = banGhiService.getAll();
		HashMap<BanGhi, Double> thongKeCBR = new HashMap<>();

		for (BanGhi banGhi : banGhis) {
			thongKeCBR.put(banGhi,
					logic.CBR(banGhi, inputThongMinh, inputTinhCach, khoiInput, xuHuongInput, thuNhapInput));
		}

		// test
		thongKeCBR.forEach((key, value) -> System.out.println(key.getId() + " " + value));

		LinkedHashMap<BanGhi, Double> thongKeSort = new LinkedHashMap<>();

		thongKeCBR.entrySet().stream().sorted(Map.Entry.<BanGhi, Double>comparingByValue(Comparator.reverseOrder()))
				.forEach(x -> thongKeSort.put(x.getKey(), x.getValue()));

		// test
		System.out.println("-------------- SORT ---------------------");
		thongKeSort.forEach((key, value) -> System.out.println(key.getId() + " " + value));

		BanGhi banGhiKetQua = (BanGhi) thongKeSort.entrySet().iterator().next().getKey();

		// test
		System.out.println("ID ban ghi ket qua : " + banGhiKetQua.getId());

		Nganh nganhKetQua = banGhiKetQua.getNganh();

		// test
		System.out.println(nganhKetQua.getTen());

		List<NganhDaoTao> nganhDaoTaos = nganhDaoTaoService.getByNganh(nganhKetQua.getId());

		Collections.sort(nganhDaoTaos, new Comparator<NganhDaoTao>() {
			public int compare(NganhDaoTao o1, NganhDaoTao o2) {
				if (o1.getDiemThi().getDiem() < o2.getDiemThi().getDiem()) {
					return 1;
				}
				return -1;
			};
		});

		// test
		for (NganhDaoTao nganhDaoTao : nganhDaoTaos) {
			System.out.println(nganhDaoTao.getTruong().getTen() + " " + nganhDaoTao.getNganh().getTen() + " "
					+ nganhDaoTao.getDiemThi().getDiem());
		}

		int index = 0;
		boolean flagOK = false;

		while (index < nganhDaoTaos.size() - 1) {
			NganhDaoTao nganhDaoTao = nganhDaoTaos.get(index);
			if (tuVanInput.getDiem() > nganhDaoTao.getDiemThi().getDiem()) {
				result.setNganh(nganhDaoTao.getNganh());
				result.setTruong(nganhDaoTao.getTruong());
				flagOK = true;
				break;
			}
			index++;
		}

		if (!flagOK) {
			NganhDaoTao lastResult = nganhDaoTaos.get(nganhDaoTaos.size() - 1);
			result.setNganh(lastResult.getNganh());
			result.setTruong(lastResult.getTruong());
		}

		return result;
	}

}
