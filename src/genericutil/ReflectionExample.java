package genericutil;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//HttpResponse<Node> res = HttpResponse.getHttpResponse(); 
		
		//res.serviceResult.setName("Indresh");
	}

}


class Node  {
	Integer id ;
	String name ;
	
	public String getName(){
		return this.name ;
	}
	public void setName(String name){
	  this.name = name ;
	}
	
}





class HttpResponse<T extends ResultType> {
	String errorCode ;
	String serviceIdentifier ;
	String status ;
   ResultType serviceResult ;
	
	public  <R extends ResultType> HttpResponse<T> getHttpResponse(){
		return new HttpResponse<T>() ;
	}
	
	public ResultType getServiceResult() {
		return this.serviceResult ;
	}
	
	
}

enum  WebService {
 LOGIN("https",Node.class);
 public static final String BASE_URL = "" ;
	
	String url ;
	Type responseType ;
	WebService(String url ,Type type){
		this.responseType =  type ;
		this.url = BASE_URL + url ;
		this.responseType = type ;
	}
	public Type getResponseType(){
		return this.responseType ;
	}
	public String getUrl(){
		return this.url ;
	}
	

}

class Error {
	
}
class ErrorHandler {
	
}


interface ResultType {
	
	public Type getType() ;
	
}

interface ResultReceiver<T extends ResultType> {
	
	public void publisResult(WebService service ,ResultType result ,Error error) ;
	public void publisProgress(WebService service ,double progress) ;

}



class WebServiceManager {
	
	
	private Map<WebService,RemoteCall> hMap = new ConcurrentHashMap<>() ;
	
	
	public void registerServices(){
		
	}
	
	
	
	public void getRemotData(final WebService service ,final ResultReceiver<? extends ResultType> receiver){
		RemoteCall remoteCall = new RemoteCall(service, receiver);
		hMap.put(service, remoteCall);
		
		
		remoteCall.start(new CompleteHandler() {
			
			@Override
			public void onComplete(byte []data) {
				Parser parser = new Parser(); 
				HttpResponse<? extends ResultType> result = parser.parse(data, service.responseType);
				receiver.publisResult(service, result.getHttpResponse().getServiceResult(), null);
				hMap.remove(service);
				
			}
			
			@Override
			public void onCancel() {
				
				hMap.remove(service);
			}

			@Override
			public void onStart() {
				
				
			}
		});
		
	}
	
	
	
	

}


class Parser {
	
	public <E> HttpResponse<? extends ResultType> parse(byte[] data , Type type){
		return new HttpResponse<ResultType>();
	}
}


interface CompleteHandler {
	
	public void onStart() ;
	public void onComplete(byte [] data)  ;
	public void onCancel () ;
}

class RemoteCall  {
	WebService service ;
	ResultReceiver receiver ;
	CompleteHandler handler ;
	
	public RemoteCall(WebService service,ResultReceiver receiver) {
		
	}
	
	public void start(CompleteHandler handler) {
		 this.handler = handler; ;
		if(handler != null){
			handler.onStart();
		}
		byte [] data = new byte[1000] ;
		receivedDataFromRemote(data);
	}
	
	private void receivedDataFromRemote(byte[] data){
		
		if(handler != null){
			handler.onComplete(data) ;
		}
	}
	
	
	public void cancelRemoteCall() {
		if(handler != null){
			handler.onCancel() ;
		}
	}
	
}








class HttpRequest {
	



}