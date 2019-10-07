package test;

public class Item {
	
	Integer id;
	String name;
	String price;
	Integer num;
	
	
	public Item(Integer id, String name, String price, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", num=" + num + "]";
	}

	
}
