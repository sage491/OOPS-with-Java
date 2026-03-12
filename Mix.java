public class Mix{
	public void m1() {
		System.out.println("m1 start");
                int num = 10/0;
		System.out.println("m end");
	}
	public void m2() {
		System.out.println("m2 start");
		m1();
		System.out.println("m2 end");
	}
	public void m3() {
		System.out.println("m3 start");
		m2();
		System.out.println("m3 end");
	}
	public void m4() {
		System.out.println("m4 start");
		m3();
		System.out.println("m4 end");
	}
	
	public static void main(String args[]) {
		Mix mix = new Mix();
		System.out.println("Start");
	
		try {
		//	int a = 10/0; //AE ae = new AE();    throw ae; 
			mix.m4();
		}catch(Exception err) {
			System.out.println("don't divide via zero");
		}finally {
			System.out.println("safe code");
		}
		System.out.println("end");
	}
}