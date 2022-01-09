package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import tvnh.entity.enums.Khoi;

@Entity
@Data
public class BanGhi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private Khoi khoi;
	
	@ManyToOne
	@JoinColumn(name = "nganh_id", referencedColumnName = "id")
	private Nganh nganh;
	
	@ManyToMany
	@JoinTable(name = "ban_ghi_thong_minh",
			   joinColumns = @JoinColumn(name = "ban_ghi_id"),
			   inverseJoinColumns = @JoinColumn(name = "thong_minh_id"))
	private Set<ThongMinh> thongMinh;
	
	@ManyToMany
	@JoinTable(name = "ban_ghi_tinh_cach",
			   joinColumns = @JoinColumn(name = "ban_ghi_id"),
			   inverseJoinColumns = @JoinColumn(name = "tinh_cach_id"))
	private Set<TinhCach> tinhCach;
	
}
