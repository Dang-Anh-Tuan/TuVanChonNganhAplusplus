package tvnh.entity.enums;

public enum ThuNhap {
	THAP("thap", 1),
	TRUNGBINH("trung binh", 2),
	CAO("cao", 3);
	private String name;
	private Integer value;
	
	private ThuNhap(String name, Integer value) {
		this.name  = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getValue() {
		return value;
	}
}
