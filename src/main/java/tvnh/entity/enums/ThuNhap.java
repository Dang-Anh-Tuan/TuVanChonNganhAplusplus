package tvnh.entity.enums;

public enum ThuNhap {
	THAP("thap", 0, 0.2),
	TRUNGBINH("trung binh", 1, 0.4),
	KHA("kha", 2, 0.6),
	KHACAO("kha cao",3, 0.8),
	CAO("cao", 4, 1);
	private String name;
	private Integer value;
	private double trongSo;
	
	private ThuNhap(String name, Integer value, double trongSo) {
		this.name  = name;
		this.value = value;
		this.trongSo = trongSo;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public double getTrongSo() {
		return trongSo;
	}
}
