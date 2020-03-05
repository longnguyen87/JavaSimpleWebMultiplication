package multiplication.domain;

/*
 * This class will return an object that represent a multiplication
 */
public class Multiplication {
	private int factor1;
	private int factor2;
	private int result;
	public Multiplication(int factor1, int factor2) {
		super();
		this.factor1 = factor1;
		this.factor2 = factor2;
		result = factor1 * factor2;
	}
	public int getFactor1() {
		return factor1;
	}
	public void setFactor1(int factor1) {
		this.factor1 = factor1;
	}
	public int getFactor2() {
		return factor2;
	}
	public void setFactor2(int factor2) {
		this.factor2 = factor2;
	}
	public int getResult() {
		return result;
	}
	@Override
	public String toString() {
		return "Multiplication [factor1=" + factor1 + ", factor2=" + factor2 + ", result=" + result + "]";
	}
	
	
	
}
