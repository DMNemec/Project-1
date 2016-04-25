package POS_DAO;

public class InvItem {
	//Private Variables
	private int id, onHand, minimum, idealAmount;
	private float price, discount, markup, categoryDiscount;
	private String name, category;
	
	//Constructors
	InvItem(){}
	
	InvItem(int newId){
		id = newId;
	}
	
	InvItem(int newId,
			String newName,
			float newPrice,
			float newDiscount,
			float newMarkup,
			int newOnHand,
			int newMinimum,
			int newIdea,
			String newCat,
			float newCatDis){
		id = newId;
		price = newPrice;
		discount = newDiscount;
		markup = newMarkup;
		onHand = newOnHand;
		minimum = newMinimum;
		idealAmount = newIdea;
		category = newCat;
		categoryDiscount = newCatDis;
	}
	
	//Public Methods
	public String toString(){
		String output = new String();
		output = id + ":" + name + ":" + String.valueOf(price) + ":" + String.valueOf(discount) + ":" + 
		String.valueOf(markup) + ":" + onHand + ":" + minimum + ":" + idealAmount + ":" + category + ":" + String.valueOf(categoryDiscount);
		return output;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int newId){
		id = newId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public float getPrice(){
		return price;
	}
	
	public void setPrice(float newPrice){
		price = newPrice;
	}
	
	public float getDiscount(){
		return discount;
	}
	
	public void setDiscount(float newDis){
		discount = newDis;
	}
	
	public float getMarkup(){
		return markup;
	}
	
	public void setMarkup(float newMark){
		markup = newMark;
	}
	
	public int getOnHand(){
		return onHand;
	}
	
	public void setOnHand(int newOn){
		onHand = newOn;
	}
	
	public int getMinimum(){
		return minimum;
	}
	
	public void setMinimum(int newMin){
		minimum = newMin;
	}
	
	public int getIdeal(){
		return idealAmount;
	}
	
	public void setIdeal(int newIdea){
		idealAmount = newIdea;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String newCat){
		category = newCat;
	}
	
	public float getCategoryDiscount(){
		return categoryDiscount;
	}
	
	public void setCategoryDiscount(float newCatDis){
		categoryDiscount = newCatDis;
	}
}
