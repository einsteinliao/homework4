package model;

public class Order {
	private Integer id;
	private Integer member_id;
	private Integer room_id;
	private Integer price;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Order(Integer member_id, Integer room_id, Integer price) {
		super();
		this.member_id = member_id;
		this.room_id = room_id;
		this.price = price;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
