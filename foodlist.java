package EntityList;
import Entity.*;

public class foodlist {
    private food foods[];
    public foodlist(){foods=new food[100];}

    public void insert(food f) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == null) {
                foods[i] = f;
                break;
            }
        }
    }
    public float GetTotalBill(){
        float sum=0;
        for (int i=0;i< foods.length;i++) {
            if(foods[i] !=null){
                sum+=foods[i].getPrice();
            }
        }
        return sum;
    }
    public void DeleteAll(){
        for (int i=0;i< foods.length;i++) {
            if(foods[i] !=null){
                foods[i]=null;
            }
        }
    }
    public void DeleteByName(String name){
        for (int i=0;i< foods.length;i++) {
            if(foods[i] !=null){
                if(foods[i].getName().equals(name)){
                    foods[i]=null;
                }
            }
        }
    }
    public String ShowAllFood(){
        String allfood="";
        for(int i=0;i< foods.length;i++){
            if(foods[i]!=null){
                allfood+=foods[i].getFoodInfoAsString();
            }
        }
        allfood+="\n======================\n";
        allfood+="Total : "+GetTotalBill();
        return allfood;
    }
}
