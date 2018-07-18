import java.util.*;

public class FixedProductPromotion implements Promotion
{  float minimumPrice;
   float fixedDiscount;
   public ArrayList <String> pE1=new ArrayList<String>(); 

   public void addCodes()
{   
	pE1.add(PromotionEnum.values()[0].toString());
	pE1.add(PromotionEnum.values()[1].toString());
	pE1.add(PromotionEnum.values()[2].toString());
	
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
	  if(pE1.contains(code))
	  return true;
return false;
	
}

}
