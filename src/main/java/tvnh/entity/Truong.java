package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Truong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten;
	
	@OneToMany(mappedBy = "truong")
	private Set<NganhDaoTao> nganhDaoTao;
}
