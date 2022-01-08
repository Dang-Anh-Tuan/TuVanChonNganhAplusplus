package tvnh.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ChiSoTinhCach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    private int chiso;
    
    @ManyToOne(targetEntity = TinhCach.class)
    @JoinColumn(name = "tinhcach_id", referencedColumnName = "id")
    private TinhCach tinhCach;
    
    @ManyToMany
   	@JoinTable(name = "chisotinhcach_traloi", joinColumns = @JoinColumn(name = "chisotinhcach_id"))
   	private Set<TraLoi> traLoi;
}
