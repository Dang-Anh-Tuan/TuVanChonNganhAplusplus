package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class XuHuong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    
    @OneToMany(targetEntity = Nganh.class,mappedBy = "xuhuong")
    private Set<Nganh> nganh;
}
