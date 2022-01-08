package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class CauHoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cauhoi;
    private boolean trangthai;
    
    @OneToMany(targetEntity = TraLoi.class, mappedBy = "cauHoi")
    private Set<TraLoi> traLoi;
}
