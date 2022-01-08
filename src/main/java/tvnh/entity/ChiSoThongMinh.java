package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class ChiSoThongMinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    private int chiso;
    
    @ManyToOne(targetEntity = ThongMinh.class)
    @JoinColumn(name = "thongminh_id", referencedColumnName = "id")
    private ThongMinh thongMinh;
    
    @ManyToMany
	@JoinTable(name = "chisothongminh_traloi", joinColumns = @JoinColumn(name = "chisothongminh_id"))
	private Set<TraLoi> traLoi;
}
