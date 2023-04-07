
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.util.Random;

public class Chest extends Inventory implements ActionListener {
	private JFrame f;
	private JPanel p;
	private JButton open;
	private int color;
	private int item;
	private String c_item, c_color;
	private static String Item; 
	private JLabel found;
	
	public Chest() {
		super(Item);
		f = new JFrame("Chest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		p = new JPanel();
		f.add(p);
		open = new JButton("Open Chest");
		p.add(open);
		open.addActionListener(this);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Random rand = new Random();
		color = rand.nextInt(100);
		//System.out.println(color);
		color = rarity(color);
		//System.out.println(color);
		switch(color) {
		case 1:
			c_color = "White";
			break;
		case 2:
			c_color = "Green";
			break;
		case 3:
			c_color = "Blue";
			break;
		case 4:
			c_color = "Orange";
			break;
		}
		item = rand.nextInt(2)+1;
		switch(item) {
		case 1:
			c_item = "Weapon";
			break;
		case 2:
			c_item = "Shield";
			break;
		}
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		Item = (c_color + " " + c_item);
		found = new JLabel(Item);
		p.add(found);
		f.setVisible(true);
		String ans;
		ans = JOptionPane.showInputDialog("Would you like to add this to your Inventory?");
		if(ans.toLowerCase().equals("yes")) {
			//add to inventory
			JOptionPane.showMessageDialog(null, "Item was added to your inventory!");
			Inventory in = new Inventory(Item);
			System.out.println(in);
		}
		else if(ans.toLowerCase().equals("no")) {
			JOptionPane.showMessageDialog(null, "Item was lost.");
		}
		else {
			throw new IllegalArgumentException("INVALID RESPONSE!");
		}
		create_save();
		System.exit(0);
	}
	
	public int rarity(int num) {
		if(num < 51) {
			//white item
			return num = 1;
		}
		else if(num < 76) {
			//green item
			return num = 2;
		}
		else if(num < 96) {
			//blue item
			return num = 3;
		}
		else {
			//orange item
			return num = 4;
		}
	}
	
	public void create_save() {
		try {
			File Inventory_file = new File("C://Users//spart//OneDrive//Documents//Chest Game/Save1.txt");
			if(Inventory_file.createNewFile()) {
				System.out.println("Save Created");
			}
			else {
				System.out.println("Save File Already Exists!");
			}
			FileWriter w = new FileWriter(Inventory_file);
			w.write(My_Inventory.toString());
			w.close();
		}
		catch(IOException e){
			System.out.println("An error occured. Save lost.");
			e.printStackTrace();
		}
	}
}
