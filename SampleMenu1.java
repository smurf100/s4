import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class SampleMenu1 extends JFrame implements ActionListener
{
JMenuItem load,save,exit;
JRadioButtonMenuItem b1,b2;
JTextArea tr;
JMenuBar mb;
JMenu m,New;
ButtonGroup bg;
JFileChooser  fc1;
JLabel lblnum;
public SampleMenu1() 
{
setSize(600,700) ;
initComponent();
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public void initComponent()
{
bg=new ButtonGroup();
mb = new JMenuBar();
load=new JMenuItem("  Load    ");
save=new JMenuItem("  Save    ");
exit=new JMenuItem("  Exit    ");


b1=new JRadioButtonMenuItem(" Ascending");
b2=new JRadioButtonMenuItem(" Descending");

setJMenuBar(mb) ;

lblnum = new JLabel("Numbers :");
mb.add(m = new JMenu("Operation"));
m.add(load);
m.add(save);
m.addSeparator();		
m.add(exit);
mb.add(New =new JMenu("  Sort "));
New.add(b1);
New.add(b2);
bg.add(b1);
bg.add(b2);
add(lblnum);
JPanel p = new JPanel();
p.add(new JTextArea());
tr=new JTextArea(" ");
lblnum.setBounds(80,210,100,30);
tr.setBounds(50,250,500,300);
add(tr);
add(p);
	
	
load.addActionListener(this);
save.addActionListener(this);
exit.addActionListener(this);


b1.addActionListener(this);
b2.addActionListener(this);
}
	
public void actionPerformed(ActionEvent e) 
{

Object src = e.getSource();
String fname="";
String num="";

if(src.equals(load))
{
	try
	{

	tr.setText("");
	fc1 = new JFileChooser("File Dialog");
	int result;
	result=fc1.showOpenDialog(this);
		if(result==fc1.APPROVE_OPTION)
			{
			fname=fc1.getSelectedFile().getAbsolutePath();
			}
		FileInputStream fin=new FileInputStream(fname);
  		int i;
  				
  		do
  		{
		i=fin.read();
		if(i!=-1)
		{
  		num=num+""+(char)(i);
		}
  		}while(i!=-1);
  		tr.append(num);
  	}
  	catch(IOException io)
  	{
  		System.out.println(""+io);
	}
}


else if(src.equals(exit))
{
  setVisible(false);
  System.exit(0);
}
		

else if(src.equals(save))
{
	try
	 {
	  FileWriter fout=new FileWriter(fc1.getSelectedFile().getAbsolutePath());
	  num="";
	  num=tr.getText();
	  fout.write(num);
	  fout.close();		
	 }
	catch(Exception se)
	 {
	  System.out.println(""+se);
	 }
}
		



else if(src.equals(b1))
{
System.out.println("Ascending Button Clicked");

}

else if(src.equals(b2))
{
System.out.println("Descending Button Clicked");

}

}

public static void main(String arg[]) 
{
new SampleMenu1();
}


}


