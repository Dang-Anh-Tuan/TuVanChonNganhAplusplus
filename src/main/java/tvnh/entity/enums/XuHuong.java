package tvnh.entity.enums;

public enum XuHuong {
	TANG("tang", 0),
	NGANG("ngang", 1),
	GIAM("giam", 2),
	BATDINH("bat dinh", 3);
	
	private String ten;
	private Integer value;
	
	private XuHuong(String ten, Integer value) {
		this.ten = ten;
		this.value = value;
	}
	
	public String getTen() {
		return ten;
	}
	
	public Integer getValue() {
		return value;
	}
}
