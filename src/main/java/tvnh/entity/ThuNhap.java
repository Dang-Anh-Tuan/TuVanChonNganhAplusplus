package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class ThuNhap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    private String mota;
    
    @OneToMany(targetEntity = NguoiDung.class,mappedBy = "thuNhap")
    private Set<NguoiDung> nguoiDung;
    
    @OneToMany(targetEntity = BanGhi.class, mappedBy = "thuNhap")
    private Set<BanGhi> banGhi;
}
