/**
 * increasement class
 * @author Mike Shihua
 *
 */
public class MyCountat {
	/**
	 * ���캯��������
	 * @param startValue
	 */
	public MyCountat(int startValue){
		counter = startValue;
	}
	/**
	 * ���캯����������
	 * 
	 */
	public MyCountat(){
		counter = 1;
	}
	
	
	public int realValue(){
		int temp  = counter;
		counter++;
		return (temp);
	}
	private static int counter;
}
