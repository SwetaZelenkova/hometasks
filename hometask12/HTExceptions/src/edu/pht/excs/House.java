package edu.pht.excs;

public class House {
	private long id;
	private HouseType type;
	private int floor;
	private int room;
	private Address address;
	private int price;

	public enum HouseType {
		PRIVATE, BLOCK_OF_FLATS
	}

	public House() {
	}

	public House(long id, HouseType type, int floor, int room) {
		this.id = id;
		this.type = type;
		this.floor = floor;
		this.room = room;
	}

	public House(long id, HouseType type, int floor, int room, Address address, int price) {
		this(id, type, floor, room);
		this.address = address;
		this.price = price;
	}

	public House(long id) {
		this.id = id;
	}

	public House(long id, Address address) {
		this(id);
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) throws NIDException {
		if (id >= 0) {
			this.id = id;
		} else {
			throw new NIDException("...impossible event: id negative sign", "...id can not negative sign");
		}
	}

	public HouseType getType() {
		return type;
	}

	public void setType(HouseType type) throws IllegalArgumentException {
		if (type instanceof HouseType) {
			this.type = type;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", type=" + type + ", floor=" + floor + ", room=" + room + ", address=" + address
				+ ", price=" + price + "]";
	}
}
