import java.util.ArrayList;

public class FixedOrderPromotion implements Promotion
{  float minimumPrice;
   float fixedDiscount;
   public ArrayList <String> pE2=new ArrayList<String>(); 
   public void addcodes()
{   
	pE2.add(PromotionEnum.values()[3].toString());
	pE2.add(PromotionEnum.values()[4].toString());
	
	
}
   @Override
   
public void setMinimumPrice(int minimumPrice) {
   	this.minimumPrice=minimumPrice;
   	
   }
   @Override
public void setFixedDiscount(int fixedDiscount) {
   	this.fixedDiscount=fixedDiscount;
   	
   }
@Override
public float getMinimumPrice()
{
	return minimumPrice;
}
@Override
public float getFixedDiscount()
{
	return fixedDiscount;
}


@Override
public boolean isPromotionApplicable(String code) {
	   if(pE2.contains(code))
	    {
	       return true;
	     }
	return false;
}

}
