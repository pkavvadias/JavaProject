
public class RoomTypeB extends RoomTypeA {
    private int DiscountPerDay;
    private double cost=0;

    public void setDiscountPerDay(int i){DiscountPerDay=i;}
    public int getDiscountPerDay(){return DiscountPerDay;}


    @Override
    public double costCalculate(){
        double cost=0;
        double finalPricePerDay;
        Reservation previous=null;
        int dayCounter=0;
        int i;
        for (Reservation r: Availability){
            if (r==null && previous==null){
                //no reservations
                continue;
            }
            else if (r!=null && previous==null){
                //new reservation after room being unreserved for day(s)
                dayCounter=1;
                //(we could have just incremented it, but we chose to assign 1 directly to be sure)
                previous=r;
                continue;
            }
            else if (r!=null && previous!=null && previous!=r){
                //new reservation immediately after the end of the previous reservation
                finalPricePerDay=getPricePerDay();
                for (i=0; i<dayCounter; i++){
                    cost+=finalPricePerDay;
                    System.out.println(cost);
                    if (finalPricePerDay-DiscountPerDay>=(getPricePerDay()/2)){
                        finalPricePerDay-=DiscountPerDay;
                    }
                }
                dayCounter=1;
                //(this is the first day of the new reservation)
                previous=r;
                continue;
            }
            else if (r==null && previous!=null){
                //end of a reservation followed by unreserved day(s)
                finalPricePerDay=getPricePerDay();
                for (i=0; i<dayCounter; i++){
                    cost+=finalPricePerDay;
                    System.out.println(cost);
                    if (finalPricePerDay-DiscountPerDay>=(getPricePerDay()/2)){
                        finalPricePerDay-=DiscountPerDay;
                    }
                }
                dayCounter=0;
                previous=r;
                continue;
            }
            else if (r!=null && r==previous){
                //reservation continues
                dayCounter++;
                previous=r;
                continue;
            }
        }
        return cost;
    }

    @Override
    public boolean cancel ( int ReservationId) {
        return false;
    }
}
