package tvnh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import tvnh.entity.enums.Khoi;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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
	@JsonIgnore
	private List<ThongMinh> thongMinh = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "ban_ghi_tinh_cach",
			   joinColumns = @JoinColumn(name = "ban_ghi_id"),
			   inverseJoinColumns = @JoinColumn(name = "tinh_cach_id"))
	@JsonIgnore
	private List<TinhCach> tinhCach = new ArrayList<>();
	
}
