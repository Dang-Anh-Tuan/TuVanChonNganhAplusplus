package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import tvnh.entity.enums.ThuNhap;
import tvnh.entity.enums.XuHuong;

@Entity
@Data
public class Nganh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    private XuHuong xuHuong;
    private ThuNhap thuNhap;
    
    @OneToMany(mappedBy = "nganh")
    private Set<NganhDaoTao> nganhDaoTao;
    
    @OneToMany(mappedBy = "nganh")
    private Set<BanGhi> banGhi;
}
