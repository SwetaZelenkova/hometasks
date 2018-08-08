package edu.pht.collections;

public class Cat implements Comparable<Cat> {
	private String name;
	private int age;
	private Gender gender;

	public Cat(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cat other = (Cat) o;
		if (age != other.age)
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cat *name=" + name + ", age=" + age + ", gender=" + gender + "*\n";
	}

	@Override
	public int compareTo(Cat o) {
		int result = this.name.compareTo(o.getName());
		if (result != 0) {
			return result / Math.abs(result);
		} else {
			result = this.gender.compareTo(o.getGender());
			if (result != 0) {
				return result / Math.abs(result);
			} else {
				return (o.getAge() < this.age ? -1 : (o.getAge() == this.age ? 0 : 1));
			}
		}
	}

}
