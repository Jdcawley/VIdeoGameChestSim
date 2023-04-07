
/**Final Exam Project
* Author: Joey Cawley
* Project Purpose: Program uses java swing to simulate a video game, using a chest and an inventory system
* Input:  Input whether you would like to add the item to your inventory
* Desired Output:  Your inventory should be displayed
* Variables and Classes:  class Chest, Inventory, Demo
* Formulas: Uses JOptionPane and System prints to display info
* Description of the main algorithm:
* April 28, 2020
**/

public class Demo extends Chest {

	public static void main(String[] args) {
		System.out.print("Add weapons and shields to your inventory.\n"
				+ "Color (Weakest to Strongest): White, Green, Blue, Orange.\n" 
				+ "Click to open your first chest!\n");
		Chest chest_one = new Chest();
	}
}
