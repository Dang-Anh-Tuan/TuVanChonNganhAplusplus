package tvnh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class TraLoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String traLoi;
   
	@ManyToOne
    @JoinColumn(name = "cauHoi_id", referencedColumnName = "id")
    private CauHoi cauHoi;
	
	@OneToMany(mappedBy = "traLoi")
	@JsonIgnore
	private List<ChiSoTinhCach> chiSoTinhCach = new ArrayList<>();
	
	@OneToMany(mappedBy = "traLoi")
	@JsonIgnore
	private List<ChiSoThongMinh> chiSoThongMinh = new ArrayList<>();
}
