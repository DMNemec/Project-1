package POS_DAO;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

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
		CopyFile(product,true);
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
		CopyFile(product,false);
	}
	
	public void RemoveFromInventory (int id, int qty){
		//TODO
		//Removes qty items with the ID from the inventory
	}

	public void ChangeCategoryDiscount (String category, float discount){
		//copy all lines to a new file
		//when a line w/the category string is encountered, change the discount amount
		//rename new file to old file
		File tempFile = new File("databases\\tempInv.txt");
		String copyLine = new String();
		String[] copyArray = new String[10];
		
		try {
			BufferedReader invReader = new BufferedReader(new FileReader(invFile));
			BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
			while ((copyLine = invReader.readLine()) != null){
				copyArray = copyLine.split(":");
				if (copyArray[8].equals(category)){
					copyArray[9] = String.valueOf(discount);
				}
				tempWriter.write(copyLine);
			}
			tempWriter.close();
			invReader.close();
			invFile.delete();
			tempFile.renameTo(invFile);
			invFile = tempFile;
		} catch (FileNotFoundException ex){
			JOptionPane.showMessageDialog(null, ex);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
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
		return CategoryNames().size();
	}
	
	public LinkedHashMap CatCounts (){ //TODO finish this
		LinkedHashMap result = new LinkedHashMap();
		String[] catNames;
		
		catNames = (String[]) CategoryNames().toArray();
		
		result.
		return result;
	}
	
	public HashSet<String> CategoryNames (){
		//Counts how many different categories appear
		//Local Variables
		HashSet<String> result = new HashSet<String>();
		String line = new String();
		//Globals Used
		//BufferedReader reader
		
		try {
			reader = new BufferedReader(new FileReader(invFile));
			while ((line = reader.readLine()) != null){
				result.add(ArrayToInvItem(line.split(":")).getCategory());
			}
			reader.close();
		} catch (FileNotFoundException ex){
			JOptionPane.showMessageDialog(null, ex);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return result;
	}
	
	public void DeleteCategory(String category){
		//TODO
		//implement this method
	}
	
	//Private Methods
	private void CopyFile(InvItem id, boolean delete){
		//copies the file, when it encounters a line with the itemID, it either deletes or updates it
		File tempFile = new File("databases\\tempInv.txt");
		String copyLine = new String();
		String[] copyArray = new String[10];
		
		try {
			BufferedReader invReader = new BufferedReader(new FileReader(invFile));
			BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
			while ((copyLine = invReader.readLine()) != null){
				copyArray = copyLine.split(":");
				if (Integer.valueOf(copyArray[0]) == id.getId()){
					if (!delete){
						copyLine = id.toString();
					}
				}
				if (!delete){
					tempWriter.write(copyLine);
				}
			}
			tempWriter.close();
			invReader.close();
			invFile.delete();
			tempFile.renameTo(invFile);
			invFile = tempFile;
		} catch (FileNotFoundException ex){
			JOptionPane.showMessageDialog(null, ex);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
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
