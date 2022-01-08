package tvnh.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class NganhDaoTao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    private int diemchuan;
    
    @OneToOne
    @JoinColumn(name = "nganh_id", referencedColumnName = "id")
    private Nganh nganh;
    
    @ManyToMany
    @JoinTable(name = "truong_nganhdaotao", joinColumns = @JoinColumn(name = "nganhdt_id"))
    private Set<Truong> truong;
    
    @ManyToMany
	@JoinTable(name = "nguoidung_nganhdaotao", joinColumns = @JoinColumn(name = "nganhdt_id"))
	private Set<NguoiDung> nguoiDung;
}
