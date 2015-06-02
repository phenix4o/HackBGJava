import java.util.concurrent.FutureTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;


public class ComputationTest extends RecursiveTask<Long> {
	long result,n;
	public ComputationTest(int n,long result){
		this.n = n;
		this.result= result;
	}

	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		for(int i = 0;i<100000;i++){
			for(int j = 0;j<100000;j++){
				for(int z = 0;z<100000;z++){
					result = result+i+j+z;
				}
			}
		}
		return result;
	}

}
