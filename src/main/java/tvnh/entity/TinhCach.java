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
public class TinhCach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String ten;
    private String mota;
 
    @OneToMany(mappedBy = "tinhCach")
    @JsonIgnore
    private List<ChiSoTinhCach> chiSoTinhCach = new ArrayList<>();
    
    @ManyToMany(mappedBy = "tinhCach")
    @JsonIgnore
    private List<BanGhi> banGhi = new ArrayList<>();
}
