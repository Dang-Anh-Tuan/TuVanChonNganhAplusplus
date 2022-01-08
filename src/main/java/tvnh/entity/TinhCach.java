package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class TinhCach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    private String mota;
    
    @OneToMany(targetEntity = ChiSoTinhCach.class, mappedBy = "tinhCach")
    private Set<ChiSoTinhCach> chiSoTinhCach;
    
    @ManyToMany
	@JoinTable(name = "nguoidung_tinhcach", joinColumns = @JoinColumn(name = "tinhcach_id"))
	private Set<NguoiDung> nguoiDung;
    
    @ManyToMany
	@JoinTable(name = "banghi_tinhcach", joinColumns = @JoinColumn(name = "tinhcach_id"))
	private Set<BanGhi> banGhi;
}
