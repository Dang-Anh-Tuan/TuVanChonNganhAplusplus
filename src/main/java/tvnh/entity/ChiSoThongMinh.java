package tvnh.entity;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class ChiSoThongMinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    private Integer chiSo;
    
    @ManyToOne
    @JoinColumn(name = "thong_minh_id", referencedColumnName = "id")
    private ThongMinh thongMinh;
    
    @ManyToOne
    @JoinColumn(name = "tra_loi_id", referencedColumnName = "id")
	private TraLoi traLoi;
}
