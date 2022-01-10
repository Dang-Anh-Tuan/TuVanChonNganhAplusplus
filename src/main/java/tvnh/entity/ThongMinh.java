package tvnh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Data
public class ThongMinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten;
    private String mota;
    
    @OneToMany(mappedBy = "thongMinh")
    @JsonIgnore
    private List<ChiSoThongMinh> chiSoThongMinh = new ArrayList<>();
   
    @ManyToMany(mappedBy = "thongMinh")
    @JsonIgnore
    private List<BanGhi> banGhi = new ArrayList<>();
}
