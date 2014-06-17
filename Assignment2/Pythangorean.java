import acm.program.*;

public class Pythangorean extends ConsoleProgram{
	
	
	public void run(){
		println("Enter values to compute the Pythagorean theorem");
		double a = readDouble("a:");
		double b = readDouble("b:");
		double c = Math.sqrt(a*a+b*b);
		println("c = " + c);
		
	}
}
