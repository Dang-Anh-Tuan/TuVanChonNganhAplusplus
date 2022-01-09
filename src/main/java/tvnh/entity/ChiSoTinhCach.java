package tvnh.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ChiSoTinhCach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    private Integer chiSo;
    
    @ManyToOne
    @JoinColumn(name = "tinh_cach_id", referencedColumnName = "id")
    private TinhCach tinhCach;
    
    @ManyToOne
    @JoinColumn(name = "tra_loi_id", referencedColumnName = "id")
    private TraLoi traLoi;
}
