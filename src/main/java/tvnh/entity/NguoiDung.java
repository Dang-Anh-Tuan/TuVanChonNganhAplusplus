package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten;
	
	
	@OneToOne
	@JoinColumn(name = "diemThi_id", referencedColumnName = "id")
	private DiemThi diem;
	
	@ManyToOne
	@JoinColumn(name = "thunhap_id", referencedColumnName = "id")
	private ThuNhap thuNhap;
	
	@ManyToMany
	@JoinTable(name = "nguoidung_tinhcach", joinColumns = @JoinColumn(name = "nguoidung_id"))
	private Set<TinhCach> tinhCach;
	
	@ManyToMany
	@JoinTable(name = "nguoidung_thongminh", joinColumns = @JoinColumn(name = "nguoidung_id"))
	private Set<ThongMinh> thongMinh;
	
	@ManyToMany
	@JoinTable(name = "nguoidung_traloi", joinColumns = @JoinColumn(name = "nguoidung_id"))
	private Set<TraLoi> traLoi;
	
	@ManyToMany
	@JoinTable(name = "nguoidung_nganhdaotao", joinColumns = @JoinColumn(name = "nguoidung_id"))
	private Set<NganhDaoTao> nganhPhuHop;
	
}
