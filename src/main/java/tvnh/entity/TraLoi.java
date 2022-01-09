package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

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
	private Set<ChiSoTinhCach> chiSoTinhCach;
	
	@OneToMany(mappedBy = "traLoi")
	private Set<ChiSoThongMinh> chiSoThongMinh;
}
