import acm.program.*;


public class UseCounter extends ConsoleProgram {
	public void run(){
		MyCountat count1 = new MyCountat();
		MyCountat count2 = new MyCountat(1000);
		
		println("����count1��");
		countFiveTime(count1);
		
		println("����count2��");
		countFiveTime(count2);
		
		println("����count1��");
		countFiveTime(count1);
	}

	private void countFiveTime(MyCountat counter) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<5; i++){
			println(counter.realValue());
		}
	}
}
