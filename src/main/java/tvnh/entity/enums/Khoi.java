package tvnh.entity.enums;

public enum Khoi {
	A("Khoi A"),
	B("Khoi B"),
	C("Khoi C"),
	D("Khoi D");
	
	private String name;
	
	private Khoi(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
