package Entity;

public class food {
    String name;
    float price;

    public food(String name,float price){
        this.name=name;
        this.price=price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getFoodInfoAsString(){
        String foodinfo="Name : "+name+"\tPrice : "+price+" \n" ;;
//        foodinfo+="Name : "+name+"\t Price : "+price+" \n" ;
        return foodinfo;
    }
}
