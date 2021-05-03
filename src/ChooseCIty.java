import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseCIty implements ActionListener
{
	static final String DB_URL = "jdbc:oracle:thin:@//localhost/oracle";

	  //  Database credentials
	  static final String USER = "java_project";
	  static final String PASS = "pass";
	JFrame f ;
	JPanel p11 , p22 , p33 , p44 , p55 , p66 , information ;
	JLabel l1 , l2 , l3 , l4 , l5 , l6 ;
	JLabel location , name , movie_name  , rating , release , rdate,l ;
	JLabel text_area ;
	String city[] = new String[] {"CHENNAI","COIMABTORE","MADURAI","VELLORE","ERODE","TRICHY"} ;
	JComboBox < String > c = new JComboBox<>(city) ;
	JButton  i1 , i2 , i3 , i4 , i5 , i6 , logout ;
	JButton  b[] = new JButton[6] ;
	String signed_user ;
	String text = "The biggest film of the year Avengers: The End game has released.After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance. ";
	void Choose(String cuser)
	{
		signed_user = cuser ;
		f = new JFrame() ;
		f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		f.setLayout(null);
		Color mycolor = new Color(79,8,9);
		f.getContentPane().setBackground(mycolor);
		
		p11 = new JPanel();
		f.add(p11);
		p11.setBounds(310, 325 , 220, 400);
		p11.setLayout(null);
		p11.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));;
		p11.setBackground(mycolor);
		
		
		l1 = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\kkk.jpg"));
		p11.add(l1);
		l1.setBounds(10, 3 , 210, 348);
		i1 = new JButton("info");
		p11.add(i1);
		
		i1.setBounds(60, 340,98, 33);
		i1.setBackground(Color.black);
	    i1.setForeground(Color.white);
	    i1.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
	    i1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		i1.addActionListener(this);
		p11.setVisible(true);
		
		
		
		
		p22 = new JPanel();
		f.add(p22);
		p22.setBounds(535, 325 , 220, 400);
		p22.setLayout(null);
		p22.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
		p22.setBackground(mycolor);
		
		
		l2 = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\kaithii.jpg"));
		p22.add(l2);
		l2.setBounds(10, 18 , 200, 320);
		i2 = new JButton("info");
		p22.add(i2);
		
		i2.setBounds(60, 340,98, 33);
		i2.setBackground(Color.black);
	    i2.setForeground(Color.white);
	    i2.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
	    i2.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		i2.addActionListener(this);
		p22.setVisible(true);
		
		p33 = new JPanel();
		f.add(p33);
		p33.setBounds(760, 325 , 220, 400);
		p33.setLayout(null);
		p33.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
		p33.setBackground(mycolor);
		
		
		l3 = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\kabaliii.jpg"));
		p33.add(l3);
		l3.setBounds(10, 25 , 200, 298);
		i3 = new JButton("info");
		p33.add(i3);
		
		i3.setBounds(60, 340,98, 33);
		i3.setBackground(Color.black);
	    i3.setForeground(Color.white);
	    i3.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
	    i3.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		i3.addActionListener(this);
		p33.setVisible(true);
		
		p44 = new JPanel();
		f.add(p44);
		p44.setBackground(mycolor);
		p44.setBounds(985, 325 , 220, 400);
		p44.setLayout(null);
		p44.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
		
		
		l4 = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\varanee.jpg"));
		p44.add(l4);
		l4.setBounds(10, 33 , 200, 285);
		i4 = new JButton("info");
		p44.add(i4);
		
		i4.setBounds(60, 340,98, 33);
		i4.setBackground(Color.black);
	    i4.setForeground(Color.white);
	    i4.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
	    i4.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		i4.addActionListener(this);
		p44.setVisible(true);
		
		p55 = new JPanel();
		f.add(p55);
		p55.setBackground(mycolor);
		p55.setBounds(1210, 325 , 220, 400);
		p55.setLayout(null);
		p55.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));;
		
		
		l5 = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\endgame.jpg"));
		p55.add(l5);
		l5.setBounds(10, 25 , 200, 298);
		i5 = new JButton("info");
		p55.add(i5);
		
		i5.setBounds(60, 340,98, 33);
		i5.setBackground(Color.black);
	    i5.setForeground(Color.white);
	    i5.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
	    i5.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		i5.addActionListener(this);
		p55.setVisible(true);
		
		p66 = new JPanel();
		f.add(p66);
		p66.setBackground(mycolor);
		p66.setBounds(1435, 325 , 220, 400);
		p66.setLayout(null);
		p66.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
		
		
		l6 = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\frozen2.jpg"));
		p66.add(l6);
		l6.setBounds(10, 25 , 200, 298);
		i6 = new JButton("info");
		p66.add(i6);
		
		i6.setBounds(60, 340,98, 33);
		i6.setBackground(Color.black);
	    i6.setForeground(Color.white);
	    i6.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
	    i6.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		i6.addActionListener(this);
		p66.setVisible(true);
		
		information = new JPanel();
		f.add(information);
		information.setBackground(mycolor);
		information.setForeground(Color.white);
		information.setBounds(310, 110 , 1342, 184);
		information.setLayout(null);
		information.setBorder(BorderFactory.createLineBorder(Color.white,2,true));
		
		
		
		information.add(c);
		c.setBounds(70, 20 , 200, 36);
		
		location = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\location.jpg"));
		information.add(location);
		location.setBounds(10, 10, 60, 60);
		
		
		name = new JLabel("Welcome "+" "+ cuser);
		name.setFont(new Font("Serif", Font.BOLD, 20));
		name.setForeground(Color.white);
		information.add(name);
		name.setBounds(1000, 20, 220, 40);
		
		logout = new JButton(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\logoutt.png"));
		information.add(logout);
		logout.setBounds(1220, 15, 65, 65);
		logout.setContentAreaFilled(false);
		logout.setFocusPainted(false);
		logout.setBorderPainted(false);
		logout.addActionListener(this);
		Font fo = new Font("Cambria",Font.BOLD,18);
		l = new JLabel("logout");
	    l.setBounds(1225,73,90,30);
	    l.setForeground(Color.white);
	    l.setFont(fo);
	    information.add(l);
		
		movie_name = new JLabel("AVENGERS: THE END GAME");
		movie_name.setFont(new Font("Serif", Font.BOLD, 20)) ;
		information.add(movie_name);
		movie_name.setBounds(400,20,850,40);
		movie_name.setForeground(Color.white);
		
		text_area = new JLabel("<html>" + text + "</html>");
		text_area.setFont(new Font("Baskerville",Font.BOLD,15));
		text_area.setBounds(40,52, 800, 100);
		text_area.setForeground(Color.white);
		information.add(text_area);
		
		release = new JLabel("RELEASE DATE :") ;
		release.setForeground(Color.white);
		information.add(release);
		release.setBounds(50,133, 140, 40);
		release.setFont(new Font("Baskerville",Font.BOLD,15));
		
		rdate = new JLabel("2020-04-28");
		information.add(rdate);
		rdate.setBounds(190, 130, 100, 40);
		rdate.setFont(new Font("Baskerville",Font.BOLD,15));
		rdate.setForeground(Color.white);
	
	
		
		
		information.setVisible(true);
		
		for(int i = 0 ; i < 6 ; i++)
		{
			b[i] = new JButton(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\book_.jpg"));
			f.add(b[i]);
			b[i].setBounds(310 + i*225, 730, 220,100);
			b[i].setContentAreaFilled(false);
			b[i].setFocusPainted(false);
			b[i].setBorderPainted(false);
			b[i].addActionListener(this);
		}
		
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == i1)
		{
			Connection con = null;
			 Statement stmt = null;
			try{
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully...");
			     stmt = con.createStatement();
	    	   String qry = "select * from movie where movie_name = 'Kannum Kannum Kollaiyadithaal'"  ;
	           
	           stmt = con.createStatement();
	           	ResultSet rs = stmt.executeQuery(qry);
	           	
	           	rs.next();
	            movie_name.setText(rs.getString(1));
	            text_area.setText("<html>"+rs.getString(2)+"</html>");
	            rdate.setText(rs.getString(3));
	        
	       }catch(Exception e1){
	       	e1.printStackTrace();
	       }
	        
			
			
		}
		if(e.getSource() == i2)
		{
			Connection con = null;
			 Statement stmt = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully...");
			     stmt = con.createStatement();
	    	   String qry = "select * from movie where movie_name = 'Kaithi'"  ;
	           
	           stmt = con.createStatement();
	           	ResultSet rs = stmt.executeQuery(qry);
	           	
	           	rs.next();
	            movie_name.setText(rs.getString(1));
	            text_area.setText("<html>"+rs.getString(2)+"</html>");
	            rdate.setText(rs.getString(3));
	        
	       }catch(Exception e1){
	       	e1.printStackTrace();
	       }
	        
			
			
		}
		if(e.getSource() == i3)
		{
			Connection con = null;
			 Statement stmt = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully...");
			     stmt = con.createStatement();
	    	   String qry = "select * from movie where movie_name = 'Kabali'"  ;
	           
	           stmt = con.createStatement();
	           	ResultSet rs = stmt.executeQuery(qry);
	           	
	           	rs.next();
	            movie_name.setText(rs.getString(1));
	            text_area.setText("<html>"+rs.getString(2)+"</html>");
	            rdate.setText(rs.getString(3));
	        
	       }catch(Exception e1){
	       	e1.printStackTrace();
	       }
	        
			
			
		}
		if(e.getSource() == i4)
		{
			Connection con = null;
			 Statement stmt = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully...");
			     stmt = con.createStatement();
	    	   String qry = "select * from movie where movie_name = 'Varane Avashyamund'"  ;
	           
	           stmt = con.createStatement();
	           	ResultSet rs = stmt.executeQuery(qry);
	           	
	           	rs.next();
	            movie_name.setText(rs.getString(1));
	            text_area.setText("<html>"+rs.getString(2)+"</html>");
	            rdate.setText(rs.getString(3));
	        
	       }catch(Exception e1){
	       	e1.printStackTrace();
	       }
	        
			
			
		}
		if(e.getSource() == i5)
		{
			Connection con = null;
			 Statement stmt = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully...");
			     stmt = con.createStatement();
	    	   String qry = "select * from movie where movie_name = 'Avengers: The End Game'"  ;
	           
	           stmt = con.createStatement();
	           	ResultSet rs = stmt.executeQuery(qry);
	           	
	           	rs.next();
	            movie_name.setText(rs.getString(1));
	            text_area.setText("<html>"+rs.getString(2)+"</html>");
	            rdate.setText(rs.getString(3));
	        
	       }catch(Exception e1){
	       	e1.printStackTrace();
	       }
	        
			
			
		}
		if(e.getSource() == i6)
		{
			Connection con = null;
			 Statement stmt = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully...");
			     stmt = con.createStatement();
	    	   String qry = "select * from movie where movie_name = 'Frozen 2'"  ;
	           
	           stmt = con.createStatement();
	           	ResultSet rs = stmt.executeQuery(qry);
	           	
	           	rs.next();
	            movie_name.setText(rs.getString(1));
	            text_area.setText("<html>"+rs.getString(2)+"</html>");
	            rdate.setText(rs.getString(3));
	        
	       }catch(Exception e1){
	       	e1.printStackTrace();
	       }
	        
			
			
		}
		
		if(e.getSource() == b[0])
		{
			f.dispose();
			try {
				new AvailabilityList().Availability("Kannum Kannum Kollaiyadithaal",String.valueOf(c.getSelectedItem()),signed_user);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b[1])
		{
			f.dispose();
			try {
				new AvailabilityList().Availability("Kaithi",String.valueOf(c.getSelectedItem()),signed_user);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b[2])
		{
			f.dispose();
			try {
				new AvailabilityList().Availability("Kabali",String.valueOf(c.getSelectedItem()),signed_user);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b[3])
		{
			f.dispose();
			try {
				new AvailabilityList().Availability("Varane Avashyamund",String.valueOf(c.getSelectedItem()),signed_user);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b[4])
		{
			f.dispose();
			try {
				new AvailabilityList().Availability("Avengers: The End Game",String.valueOf(c.getSelectedItem()),signed_user);
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b[5])
		{
			f.dispose();
			try {
				new AvailabilityList().Availability("Frozen 2",String.valueOf(c.getSelectedItem()),signed_user);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == logout)
		{
			
			new FrontPage() ;
			f.dispose();
		}
		
	}
	
	

}
