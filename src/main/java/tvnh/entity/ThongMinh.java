package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class ThongMinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten;
    private String mota;
    
    @OneToMany(targetEntity = ChiSoThongMinh.class, mappedBy = "thongMinh")
    private Set<ChiSoThongMinh> chiSoThongMinh;
    
    @ManyToMany
	@JoinTable(name = "nguoidung_thongminh", joinColumns = @JoinColumn(name = "thongminh_id"))
	private Set<NguoiDung> nguoiDung;
    
    @ManyToMany
	@JoinTable(name = "banghi_thongminh", joinColumns = @JoinColumn(name = "thongminh_id"))
	private Set<BanGhi> banGhi;
}
