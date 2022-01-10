package tvnh.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tvnh.entity.enums.Khoi;

@AllArgsConstructor
@NoArgsConstructor
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
