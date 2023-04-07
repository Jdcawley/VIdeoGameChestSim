
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Inventory {
	protected static ArrayList<String> My_Inventory;
	public Inventory(String s) {
		super();
		My_Inventory = new ArrayList<String>(10);
		My_Inventory.add(s);
	}
	
	@Override
	public String toString() {
		String My_items = "";
		for(int x = 0; x < My_Inventory.size(); x++) {
			My_items += My_Inventory.get(x) + " ";
		}
		return "Inventory [My_Inventory = " + My_items + "]";
	}
}
