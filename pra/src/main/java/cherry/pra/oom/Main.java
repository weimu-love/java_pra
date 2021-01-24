package cherry.pra.oom;

public class Main {
	public static void main(String[] args) {
//		Item item1 = new Item("xueping", 50);
//		System.out.println(item1);

		Hero hanHero = new Hero("hanlin", 80);
		hanHero.recovery(20);
		System.out.println(hanHero.getHp());
	}
}

class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		String str = this.name + "is: " + String.valueOf(this.price);
		return str;
	}
}

class Hero {
	private String name;
	private float hp;

	public Hero(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}

	public void legendary() {
	}

	public float getHp() {
		return this.hp;
	}

	public void recovery(float blood) {
		this.hp += blood;
	}
}