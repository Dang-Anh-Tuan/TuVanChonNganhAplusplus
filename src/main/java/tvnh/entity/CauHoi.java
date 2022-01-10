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
public class CauHoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cauHoi;
    private boolean trangThai;
    
    @OneToMany(mappedBy = "cauHoi")
    @JsonIgnore
    private List<TraLoi> traLoi = new ArrayList<>();
}
