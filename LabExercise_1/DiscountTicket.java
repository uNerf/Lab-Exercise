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