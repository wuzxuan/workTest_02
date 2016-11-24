package entity;

public class Emp {
	private Integer id;
	private String name;
	
	
	public Emp(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Emp(){
		
	}
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
