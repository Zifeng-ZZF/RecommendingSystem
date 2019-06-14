package starter.files;

public class Rating {
	
	//Description of the moive
	private String item = null;
	//Value of the rating
	private double value = 0.0;

	public Rating(String item, double value) {
		this.item = item;
		this.value = value;
	}

	public String getItem() {
		return item;
	}

	public double getValue() {
		return value;
	}
	
	public String toString() {
		return "[" + getItem() + ", " + getValue() + "]";
	}
	
	public int compareTo(Rating other) {
		if(this.getValue() > other.getValue()) return 1;
		if(this.getValue() < other.getValue()) return -1;
		
		return 0;
	}

}
