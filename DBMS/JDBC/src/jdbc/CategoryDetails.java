package jdbc;

public class CategoryDetails {
	private String categoryName;
	private int childCategory;
	
	//parametrized constructor
	//@param-categoryName:String,productId:int
	public CategoryDetails(String categoryName , int chidCategory) {
		this.categoryName = categoryName;
		this.childCategory = chidCategory;
	}
	
	//return the name of parentCategory
	String getCategory(){
		return this.categoryName;
	}
	
	//return the count of the child
	int getChildCategoryCount(){
		return this.childCategory;
	}
}
