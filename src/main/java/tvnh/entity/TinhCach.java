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
 
    @OneToMany(mappedBy = "tinhCach")
    private Set<ChiSoTinhCach> chiSoTinhCach;
    
    @ManyToMany(mappedBy = "tinhCach")
    private Set<BanGhi> banGhi;
}
