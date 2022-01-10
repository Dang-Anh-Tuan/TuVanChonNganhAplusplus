package tvnh.entity.enums;

public enum ThuNhap {
	THAP("thap", 0),
	TRUNGBINH("trung binh", 1),
	CAO("cao", 2);
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
