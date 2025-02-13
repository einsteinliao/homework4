package model;

public class Room {

	private Integer id;
	private String name;
	private Integer price;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Room(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
