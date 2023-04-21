package ch12.sec11;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResourceExample {
	public ResourceExample() {
		JFrame f=new JFrame("Image");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("junkyu.jfif"));
//		ImageIcon icon = new ImageIcon("junkyu.jfif");
		f.add(new JLabel(icon));
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ResourceExample();
	}
}
