import java.util.ArrayList;
import java.util.Random;

public class CustomerSimulation {
	
	// return using commandline args
	private static Customer genCust(String agentType, Random rand) {
		if (agentType.equals("RandomCustomer")) {
			return new RandomCustomer(1+rand.nextInt(6));
		} else if (agentType.equals("PickyCustomer")) {
			return new PickyCustomer(1+rand.nextInt(6), 5);
		} else {
			return new Pick2Customer(1+rand.nextInt(6));
		}
	}
	
	// return mixed
	private static Customer genCust(int agentType, Random rand) {
		if (agentType == 0) {
			return new RandomCustomer(1+rand.nextInt(6));
		} else if (agentType == 1) {
			return new PickyCustomer(1+rand.nextInt(6), 5);
		} else {
			return new Pick2Customer(1+rand.nextInt(6));
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// basic setup
		Random gen = new Random();
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);

        for(int i=0;i<5;i++) {
            CheckoutAgent checkout = new CheckoutAgent( i*100+50, 480 );
            checkouts.add( checkout );
        }
        Landscape scape = new Landscape(500,500, checkouts);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        
        for (int j = 0; j < 1000; j++) {
        	Customer cust;
        	if (args.length != 0) {
        		cust = genCust(args[0], gen);        		
        	} else {
        		cust = genCust(gen.nextInt(3), gen);
        	}
            int choice = cust.chooseLine(checkouts, false);
            checkouts.get(choice).addCustomer(cust);
            scape.updateState();
            display.repaint();
            Thread.sleep(250);
//            if (j%99 == 0) {
//            	scape.printCustStats();
//            }
        }
        scape.mixedAnalysis();
	}

}
