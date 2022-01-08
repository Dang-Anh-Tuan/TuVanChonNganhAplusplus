package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Nganh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    
    @OneToMany(targetEntity = BanGhi.class, mappedBy = "nganh")
    private Set<BanGhi> banGhi;
    
    @ManyToOne(targetEntity = XuHuong.class)
    @JoinColumn(name = "xu_huong_id", referencedColumnName = "id")
    private XuHuong xuhuong; 
    
}
