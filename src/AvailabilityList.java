import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AvailabilityList implements ActionListener
{
	static final String DB_URL = "jdbc:oracle:thin:@//localhost/oracle";

	  static final String USER = "java_project";
	  static final String PASS = "pass";
	JFrame f ;
	JPanel p1 , p2 , p3 , p4   ;
	JLabel l1 , l2 , l3 , l4 , user , logo ;
	JButton b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8  , back ;
	JButton day[] = new JButton[3] ;
	String mo_name , ci_name , sign;
	String s[] = new String[8] ;
	Timer to ;
	int pi ;
	JLabel d1 , d2 , d3 ;
	int seat = 0 ;
	ButtonGroup bob ;
	Font fo = new Font("Cambria",Font.BOLD,20);
	
	void setb(JButton l , String se)
	{
		Connection con = null;
		Statement stmt = null;
		try
        {
			seat = 0 ;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection(DB_URL, USER, PASS);
		//     System.out.println("Connected database successfully for seats_booked!!!!!!!!!!!...");
		     stmt = con.createStatement();
     	    String qry = "select count(*) from seats_booked where show_id = '"+se+"'" ;
            stmt = con.createStatement();
            	ResultSet rs = stmt.executeQuery(qry);
            	rs.next();
            	 seat = seat + rs.getInt(1);
            	if(seat > 30 && seat < 40)
            	{
            		l.setBackground(Color.YELLOW);
            	}
            	else if(seat <= 30)
            	{
            		l.setBackground(Color.GREEN);
            	}
            	else
            	{
            		l.setEnabled(false);
            		l.setBackground(Color.RED);
            	}
            	       	
          
         
        }catch(Exception e1){
        	e1.printStackTrace();
        }
	}
	
	
	void Availability(String movie_name , String city_name,String cuser) throws HeadlessException, IOException
	{
		sign = cuser ;
		mo_name = movie_name ;
		ci_name = city_name ;
		
		f = new JFrame();
		f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		f.setLayout(null);
		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\background1.jpg")));
		Color mycolor = new Color(79,8,9);
		f.getContentPane().setBackground(mycolor);
		
		user = new JLabel(cuser + "  CHOOSE SHOW TIME");
		f.add(user);
		user.setBounds(820, 30, 350, 40);
		user.setForeground(Color.black);
		user.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
		
		
/*		logo = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\pic_logo.png"));
		f.add(logo);
		logo.setBounds(1300, 270, 250, 250);*/
		
		back = new JButton(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\back_.jpg"));
		f.add(back);
		back.setBounds(1810, 20, 75, 80);
		back.addActionListener(this);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		
		d1 = new JLabel("6 NOV");
		f.add(d1);
		d1.setBounds(570, 200, 70, 50);
		d2 = new JLabel("7 NOV");
		f.add(d2);
		d2.setBounds(650, 200, 70, 50);
		d3 = new JLabel("8 NOV");
		f.add(d3);
		d1.setFont(fo);
		d2.setFont(fo);
		d3.setFont(fo);
		d3.setBounds(730, 200, 70, 50);
		d1.setForeground(Color.white);
		d2.setForeground(Color.white);
		d3.setForeground(Color.white);
		day[0] = new JButton(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\fri.png"));
		f.add(day[0]);
		day[0].setBounds(570, 240, 70, 70);
		day[0].addActionListener(this);
		day[0].setContentAreaFilled(false);
		day[0].setFocusPainted(false);
		day[0].setBorderPainted(false);
		day[1] = new JButton(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\sat.jpg"));
		f.add(day[1]);
		day[1].setBounds(650, 240, 70, 70);
		day[1].addActionListener(this);
		day[1].setContentAreaFilled(false);
		day[1].setFocusPainted(false);
		day[1].setBorderPainted(false);
		day[2] = new JButton(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\sun.png"));
		f.add(day[2]);
		day[2].setBounds(730, 240, 70, 70);
		day[2].addActionListener(this);
		day[2].setContentAreaFilled(false);
		day[2].setFocusPainted(false);
		day[2].setBorderPainted(false);
		
		p1 = new JPanel();
		f.add(p1);
		p1.setBackground(mycolor);
		p1.setBounds(570, 322 , 780, 105);
		p1.setBorder(BorderFactory.createLineBorder(Color.cyan,2,true));
		
		l1 = new JLabel("Luxe");
		p1.add(l1);
		p1.setLayout(new GridLayout());
		
		
		
		b1 = new JButton("15:00");
		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.black);
		b1.setFont(fo);
		
		p1.add(b1);
        
        b2 = new JButton("18:00");
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.black);
        p1.add(b2);
        p1.setVisible(true);
		
		p2 = new JPanel();
		f.add(p2);
		p2.setBackground(mycolor);
		p2.setBounds(570, 438, 780, 105);
		p2.setBorder(BorderFactory.createLineBorder(Color.cyan,2,true));
		l2 = new JLabel("Vettri Cinemas");
		p2.add(l2);
		p2.setLayout(new GridLayout());
		b3 = new JButton("10:00");
		b3.setBackground(Color.DARK_GRAY);
		b3.setForeground(Color.black);
        p2.add(b3);
        
        b4 = new JButton("1:00");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.black);
        p2.add(b4);
		p2.setVisible(true);
		
		p3 = new JPanel();
		f.add(p3);
		p3.setBackground(mycolor);
		p3.setBounds(570, 556, 780, 105);
		p3.setBorder(BorderFactory.createLineBorder(Color.cyan,2,true));
		l3 = new JLabel("KG Cinemas");
		p3.add(l3);
		p3.setLayout(new GridLayout());
		b5 = new JButton("18:00");
		b5.setBackground(Color.DARK_GRAY);
		b5.setForeground(Color.black);
        p3.add(b5);
        
        b6 = new JButton("21:00");
        b6.setBackground(Color.DARK_GRAY);
        b6.setForeground(Color.black);
        p3.add(b6);
		p3.setVisible(true);
		
		p4 = new JPanel();
		f.add(p4);
		p4.setBackground(mycolor);
		p4.setBounds(570,674, 780, 105);
		p4.setBorder(BorderFactory.createLineBorder(Color.cyan,2,true));
		l4 = new JLabel("Vishnu Cinemas");
		
		p4.add(l4);
		p4.setLayout(new GridLayout());
		b7 = new JButton("14:00");
		b7.setBackground(Color.DARK_GRAY);
		b7.setForeground(Color.black);
        p4.add(b7);
        
        b8 = new JButton("17:00");
        b8.setBackground(Color.DARK_GRAY);
        b8.setForeground(Color.black);
        p4.add(b8);
		p4.setVisible(true);
		
		
		
		b2.setFont(fo);
		b3.setFont(fo);
		b4.setFont(fo);
		b5.setFont(fo);
		b6.setFont(fo);
		b7.setFont(fo);
		b8.setFont(fo);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		
		Connection con = null;
		Statement stmt = null;  
		try
	       {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection(DB_URL, USER, PASS);
		     System.out.println("Connected database successfully for theatre...");
		     stmt = con.createStatement();
	    	   String qry = "select theatre_name from theatre where city ="+ "'"+city_name+"' group by theatre_name" ;

	           
	           stmt = con.createStatement();
	           	ResultSet rs = stmt.executeQuery(qry);
	           	if(rs.next())
	           		l1.setText(rs.getString(1));
	           	if(rs.next())
	           		l2.setText(rs.getString(1));
	           	if(rs.next())
	           		l3.setText(rs.getString(1));
	           	if(rs.next())
	           		l4.setText(rs.getString(1));
	           	
	           	
	           	
	                   	
	         
	        
	       }catch(Exception e1){
	       	e1.printStackTrace();
	       }
		
	
		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		l3.setForeground(Color.black);
		l4.setForeground(Color.black);
		
		l1.setFont(fo);
		l2.setFont(fo);
		l3.setFont(fo);
		l4.setFont(fo);
		
		pi = 1 ;
		to = new Timer(1000, new ActionListener()
		{
	

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				if(pi == 1)
				{
					p1.setBackground(Color.white);
					p4.setBackground(mycolor);
				    pi++;
				}
				else if( pi == 2)
				{
					p2.setBackground(Color.white);
					p1.setBackground(mycolor);
					pi++ ;
				}
				else if( pi == 3)
				{
					p3.setBackground(Color.white);
					p2.setBackground(mycolor);
					pi++ ;
				}
				else if( pi == 4)
				{
					p4.setBackground(Color.white);
					p3.setBackground(mycolor);
					pi = 1 ;
				}
				
			}
	
		}) ;
        to.start();
		
		
		
		f.setVisible(true);
	}
	
	
	
	
	
	public static void main(String args[]) throws HeadlessException, IOException
	{
		AvailabilityList a = new AvailabilityList() ;
		a.Availability("","","");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 3 ; i++)
		{
		if(e.getSource() == day[i])
		{
			
			Connection con = null;
			Statement stmt = null;
			Statement stmt1 = null;
			Statement stmt2 = null;
			Statement stmt3 = null;
			try
		       {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully...");
			     stmt = con.createStatement();
		    	   String qry =  "select show_id,start_time from shows where show_id in (select show_id from movie_show where movie_name = "+"'"+mo_name+"' and show_id in(select show_id from shows where date_of_show = '0"+(i+6)+"-NOV-20' and theatre_id in(select theatre_id from theatre where theatre_name = '"+l1.getText()+"')))" ;
		           System.out.println("movieeeeeee"+mo_name + "   theatre..... "+ l1.getText());
		           stmt = con.createStatement();
		           	ResultSet rs = stmt.executeQuery(qry);
		           	
		           if(rs.next()) {
		        	   s[0] = rs.getString(1);
		           	   b1.setText(rs.getInt(2)+" : 00");
		           }
		           System.out.println("s[0]: "+ s[0]);
		           if(rs.next()) {
		        	    s[1] = rs.getString(1) ;
		           		b2.setText(rs.getInt(2)+" : 00");
		           }
                   qry =  "select show_id,start_time from shows where show_id in (select show_id from movie_show where movie_name = "+"'"+mo_name+"' and show_id in(select show_id from shows where date_of_show = '0"+(i+6)+"-NOV-20' and theatre_id in(select theatre_id from theatre where theatre_name = '"+l2.getText()+"')))" ;
		           
		           stmt1 = con.createStatement();
		           	ResultSet rs2 = stmt1.executeQuery(qry);
		           	
		           if(rs2.next()) {
		        	   s[2] = rs2.getString(1);
		        	   b3.setText(rs2.getInt(2)+" : 00");
		           }
		           if(rs2.next()) {
		        	   s[3] = rs2.getString(1);
		        	   b4.setText(rs2.getInt(2)+" : 00");
		           }
		           
                   qry =  "select show_id,start_time from shows where show_id in (select show_id from movie_show where movie_name = "+"'"+mo_name+"' and show_id in(select show_id from shows where date_of_show = '0"+(i+6)+"-NOV-20' and theatre_id in(select theatre_id from theatre where theatre_name = '"+l3.getText()+"')))" ;
		           
		           stmt2 = con.createStatement();
		           	ResultSet rs3 = stmt2.executeQuery(qry);
		           	
		           if(rs3.next()) {
		        	   s[4] = rs3.getString(1);
		        	   b5.setText(rs3.getInt(2)+" : 00");
		           }
		           if(rs3.next()) {
		        	   s[5] =rs3.getString(1);
		        	   b6.setText(rs3.getInt(2)+" : 00");
		           }
                   qry =  "select show_id,start_time from shows where show_id in (select show_id from movie_show where movie_name = "+"'"+mo_name+"' and show_id in(select show_id from shows where date_of_show = '0"+(i+6)+"-NOV-20' and theatre_id in(select theatre_id from theatre where theatre_name = '"+l4.getText()+"')))" ;
		           
		           stmt3 = con.createStatement();
		           	ResultSet rs4 = stmt3.executeQuery(qry);
		           	
		           if(rs4.next()) {
		        	   s[6] = rs4.getString(1);
		        	   b7.setText(rs4.getInt(2)+" : 00");
		           }
		           if(rs4.next()) {
		        	   s[7] = rs4.getString(1);
		        	   b8.setText(rs4.getInt(2)+" : 00");
		           }
		            setb(b1,s[0]);
					setb(b2,s[1]);
					setb(b3,s[2]);
					setb(b4,s[3]);
					setb(b5,s[4]);
					setb(b6,s[5]);
					setb(b7,s[6]);
					setb(b8,s[7]);
		           
		        
		       }catch(Exception e1){
		       	e1.printStackTrace();
		       }
		}
			
			
		
			
			
			  
			
		
		}
		
		if(e.getSource() == b1)
		{
			
		           new theatre(s[0],sign);
		           f.dispose();
	
			
		}
		

	    if(e.getSource() == b2)
		{
			
		           new theatre(s[1],sign);
		           f.dispose();
	
			
		}

		if(e.getSource() == b3)
		{
			
		           new theatre(s[2],sign);
		           f.dispose();
			
		}

		if(e.getSource() == b4)
		{
			
		           new theatre(s[3],sign);
		           f.dispose();
			
		}

		if(e.getSource() == b5)
		{
			
		           new theatre(s[4],sign);
		           f.dispose();
			
		}

		if(e.getSource() == b6)
		{
			
		           new theatre(s[5],sign);
		           f.dispose();
			
		}

	    if(e.getSource() == b7)
		{
			
		           new theatre(s[6],sign);
		           f.dispose();
			
		}

		if(e.getSource() == b8)
		{
			
		           new theatre(s[7],sign);
		           f.dispose();
			
		}
		if(e.getSource() == back )
		{
			new ChooseCIty().Choose(sign) ;
			f.dispose();
		}
		
		}
		
				
	}

