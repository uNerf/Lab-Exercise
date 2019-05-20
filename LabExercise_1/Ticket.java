class Ticket
{
    public static int Counter = 0;
    public int serialNumber = Counter;
    public int price;
	
    Ticket(){
        serialCounter++;
    }
    public int getPrice(){
        return price;
    }
    public String toString(){
        return "Ticket: ["+"serial#: " + serialNumber
                + " Price: " + price +"]";
    }
}

class CounterTicket extends Ticket
{
    public static int COUNTER_TICKET_PRICE = 50;
	
    CounterTicket(){
        price = COUNTER_TICKET_PRICE;
    }
}

class WebTicket extends Ticket 
{
    public static int WEB_TICKET_PRICE = 30;
    public static int WEB_TICKET_LT_WEEK_PRICE = 40;
	
    WebTicket(int days){
        if (days>=7) price = WEB_TICKET_PRICE;
        else price = WEB_TICKET_LT_WEEK_PRICE;
    }
}

class DiscountTicket extends WebTicket 
{
    public static double DISCOUNT = 0.5;
    public String discountType;
	
    DiscountTicket(int days, String discountType){
        super(days);
        this.discountType = discountType;
        if (days>=7) price = (int)(WEB_TICKET_PRICE*DISCOUNT);
        else price =(int)(WEB_TICKET_LT_WEEK_PRICE*DISCOUNT);
    }
	
    public String toString(){
        String ticketInfo = super.toString().substring(0,super.toString().length()-1);
        return ticketInfo + " Type: "+discountType+"]";
    }
}

public class TicketTest
{
	public static void main(String args[])
	{
		int total_sales = 0;

 	       	Ticket[] tickets = {
        	        new WebTicket(10),
                	new WebTicket(5),
	                new CounterTicket(),
        	        new DiscountTicket(5, "Student"),
                	new DiscountTicket(10, "Senior"),
        	};

	        for(int i=0; i<tickets.length; i++) {
            		System.out.println( tickets[i] );
        	}

	        for(int i=0; i<tickets.length; i++) {
        		total_sales += tickets[i].getPrice();
        	}  

        	System.out.println();
        	System.out.print("Total sales: " + total_sales );
	}
}
