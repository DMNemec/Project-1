package POS_DAO;

import java.io.*;
import javax.swing.JOptionPane;

public class Inventory_DAO {
	
	/*
	 * Written by Devin Nemec and Shane Folkerts
	 * 2016 Software Engineering Final
	*/

	//Global Variables
	private File invFile = new File("databases\\productData.txt");
	private BufferedReader reader;
	private BufferedWriter writer;
	
	//Constructors
	public Inventory_DAO() {
		if (invFile.exists()){
			System.out.println("Inventory data found.");
		} else {
			try {
				invFile.createNewFile();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex);				
			}
		}
	}
	
	//Public Methods
	public void CreateNewProduct (InvItem product){				
		try {
			writer = new BufferedWriter(new FileWriter(invFile, true));
		
			if (!ProductExists(product)){
				writer.write(product.toString());
				writer.newLine();
			}
		} catch (IOException ex){
			JOptionPane.showMessageDialog(null, ex);				
		} finally {
			try {
				writer.close();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex + "\nUnable to close file.");				
			}
		}
	}
	
	public void DeleteProduct (InvItem product){
		//copy all lines to a new text file
		//when a line with the ID is encountered, ignore it
		//rename new file to old file
		//TODO
	}
	
	public void DeleteProduct (int id){
		//create inventory object with int as id
		InvItem product = new InvItem(id);
		DeleteProduct(product);
	}
	
	public void UpdateProduct (InvItem product){
		//DOES NOT UPDATE PRODUCT ID
		//when a line with the ID is encountered, replace with this product.toString
		//rename new file to old file
		//TODO
	}

	public void ChangeCategoryDiscount (String category, int discount){
		//copy all lines to a new file
		//when a line w/the category string is encountered, change the discount amount
		//rename new file to old file
		//TODO
	}
	
	public InvItem GetProductInfo (InvItem product){
		//search through lines until line[0] == product.getId
		//use constructor to place that line[] into product and return it
		//Returns the line number of the specified employee id
		//Local Variables
		InvItem result;
		String string = new String();
		String[] elements = new String[10];
		try {
			reader = new BufferedReader(new FileReader(invFile));
			
			while ((string = reader.readLine()) != null){
				elements = string.split(":");
				if (elements[0].equals(String.valueOf(product.getId()))){
					break;
				}
			}
		} catch (IOException ex){
			JOptionPane.showMessageDialog(null, ex);			
		} finally {
			try {
				reader.close();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex + "\nUnable to close file.");				
			}
		}
		result = ArrayToInvItem(elements);
		return result;
	}
	
	public InvItem GetProductInfo (int id){
		InvItem result = new InvItem(id);
		return GetProductInfo(result);
	}
	
	public int CountOfCategories (){
		return CategoryNames().length;
	}
	
	public String[] CategoryNames (){
		String[] result = null;
		//TODO
		return result;
	}
	
	//Private Methods
	private void CopyFile(InvItem id, boolean delete){
		//TODO
		//copies the file, when it encounters a line with the itemID, it either deletes or updates it
	}
	
	private InvItem ArrayToInvItem(String[] input){
		InvItem output = new InvItem(Integer.valueOf(input[0]),
									 input[1],
									 Float.valueOf(input[2]),
									 Float.valueOf(input[3]),
									 Float.valueOf(input[4]),
									 Integer.valueOf(input[5]),
									 Integer.valueOf(input[6]),
									 Integer.valueOf(input[7]),
									 input[8],
									 Float.valueOf(input[9]));
		return output;
	}
	
	private boolean ProductExists(InvItem id){
		//search through file until id encountered
		boolean result = false;
		String line = new String();
		String[] elements = new String[10];
		try {
			reader = new BufferedReader(new FileReader(invFile));
			
			while ((line = reader.readLine()) != null){
				elements = line.split(":");
				if (elements[0].equals(String.valueOf(id.getId()))){
					result = true;
					break;
				}
			}
		}  catch (IOException ex){
			JOptionPane.showMessageDialog(null, ex);				
		} finally {
			try {
				reader.close();
			} catch (IOException ex){
				JOptionPane.showMessageDialog(null, ex + "\nUnable to close file.");				
			}
		}
		return result;
	}
	
	/*
	 * Written by Devin Nemec and Shane Folkerts
	 * 2016 Software Engineering Final
	*/

}
