package tvnh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tvnh.entity.enums.ThuNhap;
import tvnh.entity.enums.XuHuong;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Nganh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    @Enumerated(EnumType.ORDINAL)
    private XuHuong xuHuong;
    @Enumerated(EnumType.ORDINAL)
    private ThuNhap thuNhap;
    
    @OneToMany(mappedBy = "nganh")
    @JsonIgnore
    private List<NganhDaoTao> nganhDaoTao = new ArrayList<>();
    
    @OneToMany(mappedBy = "nganh")
    @JsonIgnore
    private List<BanGhi> banGhi = new ArrayList<>();
}
