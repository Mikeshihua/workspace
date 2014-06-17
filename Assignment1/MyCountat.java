/**
 * increasement class
 * @author Mike Shihua
 *
 */
public class MyCountat {
	/**
	 * 构造函数带参数
	 * @param startValue
	 */
	public MyCountat(int startValue){
		counter = startValue;
	}
	/**
	 * 构造函数不带参数
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
