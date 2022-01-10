package tvnh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class Truong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten;
	
	@OneToMany(mappedBy = "truong")
	@JsonIgnore
	private List<NganhDaoTao> nganhDaoTao = new ArrayList<>();
}
