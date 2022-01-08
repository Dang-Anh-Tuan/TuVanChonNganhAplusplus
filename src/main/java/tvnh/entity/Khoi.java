package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Khoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten;
	
	@OneToMany(targetEntity = DiemThi.class, mappedBy = "khoi")
	private Set<DiemThi> diemThi;
	
	@OneToMany(targetEntity = BanGhi.class, mappedBy = "khoi")
	private Set<BanGhi> banGhi;
}
