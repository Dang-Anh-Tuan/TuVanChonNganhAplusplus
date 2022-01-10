package tvnh.entity.enums;

public enum Khoi {
	A("A"),
	B("B"),
	C("C"),
	D("D");
	
	private String name;
	
	private Khoi(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
