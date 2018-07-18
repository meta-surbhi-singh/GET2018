public interface Promotion
{
public float getMinimumPrice();
public void setMinimumPrice(int minimumPrice);
public float getFixedDiscount();
public void setFixedDiscount(int fixedDiscount);
public boolean isPromotionApplicable(String code);

}