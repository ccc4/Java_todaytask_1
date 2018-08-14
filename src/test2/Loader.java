package test2;

public class Loader extends Thread{
	private T2_Class t2c;
	
	public Loader(T2_Class t2c) {
		this.t2c = t2c;
	}
	
	@Override
	public void run() {
		try {
			t2c.load();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
