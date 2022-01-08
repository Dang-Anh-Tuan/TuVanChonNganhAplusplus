package tvnh.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class DiemThi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private int diem;
    
    @ManyToOne(targetEntity = Khoi.class)
    @JoinColumn(name = "khoi_id", referencedColumnName = "id")
    private Khoi khoi;
    
    
}
