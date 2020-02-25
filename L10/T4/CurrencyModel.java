
public class CurrencyModel {
	String name;
	float eurRelation;

	
	CurrencyModel(String name, float relation){
		this.name = name;
		this.eurRelation = relation;
	}
	
	public float convert(int value, CurrencyModel other) {
		return value * (this.eurRelation / other.getEurRelation());
	}

	public float getEurRelation() {
		return eurRelation;
	}

	public String getName() {
		return name;
	}
}
