package utility.thread;
import java.util.ArrayList;
import java.util.concurrent.*;


class DownloadTask implements Callable<String> {
	
	private int start_offset ;
	private int request_size ;
	
	
	public DownloadTask(int start_offset, int request_size) {
		this.start_offset = start_offset ;
		this.request_size = request_size ;
		
	}
	
	public String getTaskName(){
		Integer count = this.start_offset / 100 ;
		return count.toString();
	}
	

	@Override
	public String call() throws Exception {
		int i = 4 ;
		String data = "";
		while(i > 0){
			
			try {
				Thread.sleep(1000);
				System.out.println("Task " + this.getTaskName() );
                data = data + "-data-" + this.getTaskName(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
			
		}
		return data ;
	}
}

public class ExecutorServiceExample {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

		ArrayList<Future<String>> list = new ArrayList<>();
		for(int i = 0 ; i < 4 ; i++){
			DownloadTask task = new DownloadTask(i*100, 500);
			Future<String> f = executor.submit(task);
			list.add(f);
			
		}
        
		for(Future<String> t : list){
			try {
				String result = t.get();
				System.out.println("result : " + result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	}

	
}
