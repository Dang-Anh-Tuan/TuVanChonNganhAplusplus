package tvnh.entity;


import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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
