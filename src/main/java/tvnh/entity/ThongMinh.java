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
    
    @OneToMany(mappedBy = "thongMinh")
    private Set<ChiSoThongMinh> chiSoThongMinh;
   
    @ManyToMany(mappedBy = "thongMinh")
    private Set<BanGhi> banGhi;
}
