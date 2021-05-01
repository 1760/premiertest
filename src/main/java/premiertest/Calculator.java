package premiertest;

public class Calculator {
	public int add (int a,int b) {
		return a+b;
	}
	public int multiply (int a,int b) {
		return a*b;
	}
	
	public double add (double a, double b) {
		return a+b;
	}
	
	public double multiply (double a, double b) {
		return a*b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

	public double sub(double a, double b) {
		return a - b;
	}

	public double divide(double a, double b) {
		return a / b;
	}

	public int fact(int a) {
		if (a < 0 || a > 12) {
			throw new IllegalArgumentException("Doit être compris entre 0 et 12.");
		}
		if (a <= 1) {
			return a;
		}
		return a * fact(a - 1);
	}

	public void longCalculation() {
		try {
			Thread.sleep(500);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
}
