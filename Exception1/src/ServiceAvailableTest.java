
public class ServiceAvailableTest {
	
	public static void main(String... args){
		 boolean serviceNotAvailable = false;
	     boolean networkIsDown = false;
	     boolean routerIsRestarting = false;
	     boolean fireWallCanStart = false;
		try {
			serviceUse(networkIsDown, routerIsRestarting, fireWallCanStart);
		} catch (ServiceNotAvailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 public static void serviceUse(boolean networkIsDown, boolean routerIsRestarting, boolean fireWallCantStart) throws ServiceNotAvailableException{
	        if(networkIsDown && !routerIsRestarting&&!fireWallCantStart)
	            throw new ServiceNotAvailableException("The network is down"); 
	        else if(routerIsRestarting&&!networkIsDown&&!fireWallCantStart)
	            throw new ServiceNotAvailableException("The router is restarting"); 
	        else if(fireWallCantStart&&!networkIsDown&&!routerIsRestarting)
	            throw new ServiceNotAvailableException("The firewall can't start"); 
	        else if(fireWallCantStart&&networkIsDown&&routerIsRestarting)
	        	 System.out.println("Everything is OK");
	        else 
	           throw new ServiceNotAvailableException("Please check the fucking router and/or the fucking firewall and/or network. Everything is wrong ! ");
	    } 
	 
}
