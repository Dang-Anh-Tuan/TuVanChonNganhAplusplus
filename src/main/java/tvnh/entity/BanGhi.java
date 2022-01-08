package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class BanGhi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne(targetEntity = ThuNhap.class)
	@JoinColumn(name = "thunhap_id", referencedColumnName = "id")
    private ThuNhap thuNhap;
	
	@ManyToOne(targetEntity = Khoi.class)
	@JoinColumn(name = "khoi_id", referencedColumnName = "id")
    private Khoi khoi;
	
	@ManyToMany
	@JoinTable(name = "banghi_thongminh", joinColumns = @JoinColumn(name = "banghi_id"))
	private Set<ThongMinh> thongminh;
	
	@ManyToMany
	@JoinTable(name = "banghi_tinhcach", joinColumns = @JoinColumn(name = "banghi_id"))
	private Set<TinhCach> tinhcach;
	
	@ManyToOne(targetEntity = Nganh.class)
	@JoinColumn(name = "nganh_id", referencedColumnName = "id")
    private Nganh nganh;
	
}
