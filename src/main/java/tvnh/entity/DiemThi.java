package tvnh.entity;

import javax.persistence.*;

import lombok.Data;
import tvnh.entity.enums.Khoi;

@Entity
@Data
public class DiemThi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Float diem;
    @Enumerated(EnumType.STRING)
    public static Khoi khoi;    
}
