package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class TraLoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String traloi;
   
	@ManyToOne(targetEntity = CauHoi.class)
    @JoinColumn(name = "cauHoi_id", referencedColumnName = "id")
    private CauHoi cauHoi;
	
	@ManyToMany
	@JoinTable(name = "nguoidung_traloi", joinColumns = @JoinColumn(name = "traloi_id"))
	private Set<NguoiDung> nguoiDung;
	
	@ManyToMany
	@JoinTable(name = "chisotinhcach_traloi", joinColumns = @JoinColumn(name = "traloi_id"))
	private Set<ChiSoTinhCach> chiSoTinhCach;
	
	@ManyToMany
	@JoinTable(name = "chisothongminh_traloi", joinColumns = @JoinColumn(name = "traloi_id"))
	private Set<ChiSoThongMinh> chiSoThongMinh;
}
