import java.util.concurrent.ForkJoinPool;


public class TestComputationTest {
	static long n = 0;
	public static void main(String... args){
		long time = System.currentTimeMillis();
		ComputationTest ct = new ComputationTest(8000, n);
		ForkJoinPool poool = new ForkJoinPool(2);
		//poool.invoke(ct);
		//poool.shutdown();
		//poool.invoke(ct);
		
		//poool.shutdown();
	for(int i = 0;i<100000;i++){
			for(int j = 0;j<100000;j++){
				for(int z = 0;z<100000;z++){
					n = n+i+j+z;
				}
			}
		}
		
		System.out.println(ct.result);
		System.out.println(System.currentTimeMillis()-time);
	}
}
