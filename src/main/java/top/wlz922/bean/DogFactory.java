package top.wlz922.bean;

public abstract class DogFactory {
	public Dog getDog() {
		Dog dog = new Dog();
		dog.setName("工厂造的dog");
		return dog;
	}
}
