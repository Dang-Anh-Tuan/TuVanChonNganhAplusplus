package tvnh.entity.enums;

public enum XuHuong {
	TANG("tang", 1),
	NGANG("ngang", 2),
	GIAM("giam", 3);
	
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
