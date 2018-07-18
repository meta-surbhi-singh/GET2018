
public enum PromotionEnum {

    FLAT50(" FLAT50", "10/7/18" , "20/7/18" ),
    SPECIAL20("SPECIAL20", "1/7/18","15/7/18"),
    EARLY40("EARLY40","10/7/18", "22/7/18"),
    MIN20K("MIN20K","1/7/18","1/8/18"),
    MIN9K("MIN9K","15/7/18","15/7/19");
     
    private final String code;
    private final String startDate; 
    private final String endDate;
    
    private PromotionEnum(String code , String startDate, String endDate)
    {
        this.code = code;
        this.startDate=startDate;
        this.endDate=endDate;
    }
     
    public String getPromoCode()
    {
        return code;
    }
    public String getStartDate()
    {
    	return startDate;
    }
    public String getEndDate()
    {
    	return endDate;
    }
     
}

