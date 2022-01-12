package tvnh.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class NganhDaoTao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten;
    
    @ManyToOne
    @JoinColumn(name = "nganh_id", referencedColumnName = "id")
    private Nganh nganh;
    
    @ManyToOne
    @JoinColumn(name = "truong_id", referencedColumnName = "id")
    private Truong truong;
    
    @OneToOne
    @JoinColumn(name = "diem_thi_id", referencedColumnName = "id")
    private DiemThi diemThi;
}
