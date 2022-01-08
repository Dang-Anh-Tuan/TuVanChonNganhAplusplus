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
	
	@ManyToMany
	@JoinTable(name = "truong_nganhdaotao", joinColumns = @JoinColumn(name = "truong_id"))
	private Set<NganhDaoTao> nganhDaoTao;
}
