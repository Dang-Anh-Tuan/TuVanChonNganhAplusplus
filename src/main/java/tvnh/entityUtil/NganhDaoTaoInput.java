package tvnh.entityUtil;

import lombok.Data;
import tvnh.entity.Nganh;
import tvnh.entity.Truong;

@Data
public class NganhDaoTaoInput {
	Nganh nganh;
	Truong truong;
	float diem;
}
