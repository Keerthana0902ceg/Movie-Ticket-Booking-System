import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class theatre extends MainClass implements ActionListener
{
	static final String DB_URL = "jdbc:oracle:thin:@//localhost/oracle";

	  static final String USER = "java_project";
	  static final String PASS = "pass";
	JFrame f ;
	JButton b[][] = new JButton[7][8] ;
	int x , y = 250   ;
	static int count = 1  , NoTicket = 0 , price = 250;
	JButton confirm , back  , back1 , payment , discount ;
	JLabel screen ,l, amount , am , veh, logo , scr , paypal , visa , maes , gpay , card , coup , nc , password , bill , pprice, suser ;
	String qry , sh;

	JPanel payment_p ;
	JRadioButton r1 , r2 ;
	int payid = 0 ;
	JTextField  c , co , n  , bil ;
	JPasswordField p ;
	String sign_user , user_email , payd ;
	
	
	
	
	
	
	String ticket(int a[])
	{
		String t = "";
		for(int i = 0 ; i < NoTicket ; i++)
		{
			t = t + String.valueOf(a[i]) + " ," ;
		}
		
		return t ;
	}
	
	void payid(int pr , String user , String type)
	{
		Connection con = null;
		Statement stmt = null;
		try
        {
			payid = 0 ;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 
		     con = DriverManager.getConnection(DB_URL, USER, PASS);
		     System.out.println("Connected database successfully...");
		     stmt = con.createStatement();
     	    String qry = "select count(*) from payment " ;
            
                stmt = con.createStatement();
            	ResultSet rs = stmt.executeQuery(qry);
            	rs.next();
            	payid += rs.getInt(1); 
            	
            	 PreparedStatement ps2 = con.prepareStatement("insert into payment values(?,?,?,?)");
            	 ps2.setString(1, "P01YUT991"+String.valueOf(payid));
            	 ps2.setString(2, user);
            	 ps2.setInt(3, pr);
            	 ps2.setString(4, type);
            	 ps2.executeUpdate();
            	 payd = "P01YUT991"+String.valueOf(payid) ;
     
        }catch(Exception e1){
        	e1.printStackTrace();
        }
	}
	
	
	    theatre(String show, String cuser)
	{
		sh = show ;
		sign_user = cuser ;
		
		f = new JFrame("Easiest way to book tickets !!! ");
		
		f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        f.setLayout(null);
      //  f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\t_back.jpg")));
        f.getContentPane().setBackground(Color.WHITE);
        
        logo = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\ticket1.jpg"));
	  	f.add(logo);
	  	logo.setBounds(10, 5, 350, 250);
        
        back1 = new JButton(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\back_.jpg"));
		f.add(back1);
		back1.setBounds(1810, 10, 64, 64);
		back1.addActionListener(this);
		back1.setContentAreaFilled(false);
		back1.setFocusPainted(false);
		back1.setBorderPainted(false);
		l = new JLabel("back");
	    l.setBounds(1810,80,90,30);
	    l.setForeground(Color.black);
	    l.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
	    l.setVisible(true);
	    f.add(l);
      
		count = 1 ;
        for(int i = 0 ; i < 7 ;i++)
        {
        	for(int j = 0 ; j < 8 ; j++)
        	{
        		
        		b[i][j] = new JButton(String.valueOf(count));
        		f.add(b[i][j]);
        		b[i][j].setBackground(Color.LIGHT_GRAY);
        		b[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE,2,true));
        		b[i][j].addActionListener(this);
        		b[i][j].setFocusPainted(false);
        		if(j >= 4)
        		{
        			x = 120 ;
        		}
        		else if( j < 4)
        		{
        			x = 80 ;
        		}
        		
        		b[i][j].setBounds(x + 50*j,y + 50*i, 30, 29);
        		count++ ;
        	}
        }
        confirm = new JButton("Confirm") ;
        back = new JButton("Back");
        f.add(confirm);
        f.add(back);
        confirm.setBounds(600,500,110,40);
        confirm.setBackground(Color.black);
	    confirm.setForeground(Color.white);
	    confirm.setFont(new Font("Arial", Font.BOLD, 20));
	    confirm.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
	    confirm.setOpaque(true);
        confirm.addActionListener(this);
        
        back.setBounds(770, 500, 110, 40);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
	    back.setFont(new Font("Arial", Font.BOLD, 20));
        
        
        confirm.setBorder(BorderFactory.createLineBorder(Color.blue,2,true));
        back.setBorder(BorderFactory.createLineBorder(Color.blue,2,true));
        
        
       
       
       screen = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\screen.png"));
       f.add(screen);
       screen.setBounds(74,620,450,40);
       
       suser = new JLabel("CHOOSE YOUR SEATS "+ cuser);
       f.add(suser);
       suser.setBounds(800, 30, 400 , 40); 
       Font fo = new Font(Font.SANS_SERIF,Font.BOLD,22);
       suser.setForeground(Color.black);
       suser.setFont(fo);
       am = new JLabel("Amount : ");
       f.add(am);
       am.setBounds(600, 150, 100, 40);
       am.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       am.setForeground(Color.black);
      
       
       amount = new JLabel();
       f.add(amount);
       amount.setBounds(690, 150, 80, 40);
       amount.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       
  	   veh = new JLabel();
  	   f.add(veh);
  	   veh.setBounds(520, 150, 460,400);
  	   
  	scr = new JLabel("SCREEN");
  	   f.add(scr);
  	   scr.setBounds(265, 660, 70,30);
  	   
  	   veh.setVisible(true);
  	   am.setVisible(true);
  	   amount.setVisible(true);
  	   confirm.setVisible(true);
  	   back.setVisible(true);
  	   
  	   payment_p = new JPanel();
  	   f.add(payment_p);
  	   payment_p.setLayout(null);
  	   payment_p.setBounds(1070,170, 440, 520);
  	   payment_p.setBorder(BorderFactory.createLineBorder(Color.ORANGE,3,true));
  	   
  	   
  	   r1 = new JRadioButton("Credit Card");
  	   payment_p.add(r1);
  	   r1.setFocusPainted(false);
  	   r1.setBounds(30, 50, 150, 40);
  	 r1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
  	   
  	   r2 = new JRadioButton("Debit Card");
	   payment_p.add(r2);
	   r2.setFocusPainted(false);
	   r2.setBounds(200, 50, 150, 40);
	   r2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
  	   
  	   
       card = new JLabel("Card No");
       payment_p.add(card);
       card.setBounds(10, 100, 70, 40);
       card.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       
       nc = new JLabel("Name On The Card");
       payment_p.add(nc);
       nc.setBounds(10, 150, 170, 40);
       nc.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
       
       n = new JTextField(); // n is card no 
       payment_p.add(n);
       n.setBounds(100, 100, 290, 40);
       
       co = new JTextField(); // co is name on the card
       payment_p.add(co);
       co.setBounds(160, 150, 230, 40);      
        
       coup = new JLabel("Offer Code");
       payment_p.add(coup);
       coup.setBounds(10, 200, 150, 40);
       coup.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
       
       c = new JTextField();
       payment_p.add(c);
       c.setBounds(90, 200, 100, 40);
      
       bill = new JLabel("Bill No");
       payment_p.add(bill);
       bill.setBounds(200, 200, 100, 40);
       bill.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       
       bil = new JTextField();
       payment_p.add(bil);
       bil.setBounds(270, 200, 120, 40);
       
     
       
       
       password = new JLabel("Enter PIN");
       payment_p.add(password);
       password.setBounds(10, 250, 150, 40);
       password.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       
       p = new JPasswordField();
       payment_p.add(p);
       p.setBounds(190, 250, 200, 40);
       
       paypal = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\paypal.png"));
       payment_p.add(paypal);
       paypal.setBounds(40, 310, 64, 41);
       
       visa = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\visa.png"));
       payment_p.add(visa);
       visa.setBounds(124, 310, 64, 41);
       
       gpay = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\gpay.jpg"));
       payment_p.add(gpay);
       gpay.setBounds(208, 310, 64, 41);
       
       maes = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\citi.jpg"));
       payment_p.add(maes);
       maes.setBounds(292, 310, 64, 41);
       
       payment = new JButton("PAY") ;
       discount = new JButton("DISCOUNT");
       payment_p.add(payment);
       payment_p.add(discount);
       payment.setBounds(250,390,110,40);
       payment.addActionListener(this);
       payment.setBackground(Color.black);
       payment.setForeground(Color.white);
       
       discount.setBounds(60, 390, 110, 40);
       discount.addActionListener(this);
       discount.setBackground(Color.black);
       discount.setForeground(Color.white);
       
       
       payment.setBorder(BorderFactory.createLineBorder(Color.cyan,2,true));
       discount.setBorder(BorderFactory.createLineBorder(Color.cyan,2,true));
 pprice = new JLabel("Amount : " + String.valueOf(price*NoTicket) );
       pprice.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       payment_p.add(pprice);
       pprice.setBounds(30, 4, 200, 30);
       
       
       payment_p.setVisible(false);
       discount.setVisible(false);
       payment.setVisible(false);
       
       
      
       
       Connection con = null;
       Statement stmt = null;
       try
       {
    	   Class.forName("oracle.jdbc.driver.OracleDriver");
    	   con = DriverManager.getConnection(DB_URL, USER, PASS);
    	     System.out.println("Connected database successfully...");
    	     stmt = con.createStatement();
    	   qry = "select rowss,columnss from seats_booked where show_id = " + "'"+show+"'" ;
           
           System.out.println("Showww:" + show);
    	   stmt = con.createStatement();
           	ResultSet rs = stmt.executeQuery(qry);
           	
           	
           	while(rs.next())
           	{
           		b[rs.getInt(1)][rs.getInt(2)].setEnabled(false);
           		b[rs.getInt(1)][rs.getInt(2)].setBackground(Color.DARK_GRAY);
           	}          	
         
        
       }catch(Exception e1){
       	e1.printStackTrace();
       }
        
       
       f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		 ImageIcon im2 = new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\bike.jpg");
		 ImageIcon im3 = new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\auto.jpg");
		 ImageIcon im4 = new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\small_car.jpg");
		 ImageIcon im5 = new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\big_car.jpg");
		 ImageIcon im6 = new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\van.jpg");
		 ImageIcon im7 = new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\bus.jpg");
		 
		
		
		
	    for(int i = 0 ; i < 7 ; i++)
	    {
	    	for(int j = 0 ; j < 8 ; j++)
	    	{
	    		if(e.getSource() == b[i][j])
	    		{
	    			if(b[i][j].getBackground() == Color.green)
	    			{
	    				b[i][j].setBackground(Color.LIGHT_GRAY);
	    				NoTicket-- ;
	    				amount.setText(String.valueOf(price*NoTicket));
	    				pprice.setText("Amount : "+String.valueOf(price*NoTicket));
	    				
	    			}
	    			else if(b[i][j].getBackground() == Color.LIGHT_GRAY)
	    			{
	    				b[i][j].setBackground(Color.green);
	    				NoTicket++ ;
	    				amount.setText(String.valueOf(price*NoTicket));
	    				pprice.setText("Amount : "+String.valueOf(price*NoTicket));
	    			}
	    			
	    			
	    		    if(NoTicket == 1 || NoTicket == 2)
	    			{
	    				veh.setIcon(im2);
	    			}
	    			else if(NoTicket == 3)
	    			{
	    				veh.setIcon(im3);
	    			}
	    			else if(NoTicket == 4)
	    			{
	    				veh.setIcon(im4);
	    			}
	    			else if(NoTicket == 5)
	    			{
	    				veh.setIcon(im5);
	    			}
	    			else if(NoTicket > 5 && NoTicket < 9)
	    			{
	    				veh.setIcon(im6);
	    			}
	    			else if(NoTicket >= 9)
	    			{
	    				veh.setIcon(im7);
	    			}
	    		}
	    		
	    	}
	    }
	    
	    
	    
	    if(e.getSource() == payment )
	    {
	    	int ti[] = new int[56] ;
    		 int h = 0 ;
	    	
    		 Connection con = null;
    		 Statement stmt = null;
    		 try
	    	{
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	    		 con = DriverManager.getConnection(DB_URL, USER, PASS);
	    	     System.out.println("Connected database successfully...");
	    	     stmt = con.createStatement();
	    		for(int i = 0 ; i < 7 ; i++)
	    		 {
	    			 for(int j = 0 ; j < 8 ; j++)
	    			 {
	    				 if(b[i][j].getBackground() == Color.green)
	    				 {
	    					 PreparedStatement ps1 = con.prepareStatement("insert into seats_booked(show_id,rowss,columnss) values(?,?,?)");
	    					 ps1.setString(1, sh);
	    					 ps1.setInt(2,i);
	    					 ps1.setInt(3,j);
	    					 ps1.executeUpdate();
	    					 ti[h] = (i)*8 + j + 1 ;
	    					 h++ ;
	    				 }
	    			 }
	    		 }
	    		 JOptionPane.showMessageDialog(null, "Payment done! Please wait your receipt is getting generated..."); 
	    		 
	    		 
	    		
	    		
	    	}
	    	catch(Exception e1)
	    	{
	    		e1.printStackTrace();
	    		
	    	}
	    	
	    	payid(NoTicket*price , sign_user , r1.isSelected() ? r1.getText() : r2.getText());
	    	try{
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	    		 con = DriverManager.getConnection(DB_URL, USER, PASS);
	    	     System.out.println("Connected database successfully for customer...");
	    	     stmt = con.createStatement();
		    	   String qry = "select email_id from customer where username = '"+sign_user+"'"  ;
		           
		           stmt = con.createStatement();
		           	ResultSet rs = stmt.executeQuery(qry);
		           	
		           	rs.next();
		           	user_email = rs.getString(1);
		           
		        
		       }catch(Exception e1){
		       	e1.printStackTrace();
		       }
	    	
	    	    String msg = "Thank You " + sign_user +" for using Your Ticket . Your Payment Id is : "+payd+" . Your Seat Nos are " + ticket(ti)+" . Enjoy the Show . Have a Great Day ." ;
	    	    
	    	    String sub = "BOOKING CONFIRMATION" ;
				String from = "shrukoals@gmail.com" ;
				String to = user_email ;
				String password = "koala@koala" ;
				Properties properties = new Properties(); 
				properties.put("mail.smtp.host","smtp.gmail.com");
				properties.put("mail.smtp.socketFactory.port","465");
				properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				properties.put("mail.smtp.auth","true");
				properties.put("mail.smtp.port","465");
				
				
				Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(from,password);
					}
				});
				
				try { 
					MimeMessage message = new MimeMessage(session); // email message 
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
					message.setSubject(sub); // subject line 
					
					message.setText(msg); 
					Transport.send(message);
					
					} 
			catch (MessagingException mex)
					{
					mex.printStackTrace();
					} 
				JOptionPane.showMessageDialog(null, "Thank You " + sign_user +" for using Your Ticket . Your Payment Id is : "+payd+" . Your Seat Nos are " + ticket(ti));
				new FrontPage();
				f.dispose();
	 	
	    }
		
	    if(e.getSource() == confirm)
	    {
	    	if(price*NoTicket == 0) {
	    		JOptionPane.showConfirmDialog(null, "Please select atleast one seat!");
	    		payment_p.setVisible(false);
		    	payment.setVisible(false);
		    	discount.setVisible(false);
		    	confirm.setVisible(true);
		    	back.setVisible(true);
	    }
	    	else {
	    		payment_p.setVisible(true);
		    	payment.setVisible(true);
		    	discount.setVisible(true);
		    	confirm.setVisible(false);
		    	back.setVisible(true);
	    	}
	    	
	    }
	    
	    if(e.getSource() == discount)
	    {
	    	if((c.getText().matches("AB9876YZ54")) && (bil.getText().matches("12345")))
	    	{
	    		pprice.setText("Amount : "+String.valueOf(NoTicket*200));
	    		price = 200 ;
	    	}
	    	else if((c.getText().matches("LM0864UV23")) && (bil.getText().matches("23456")))
	    	{
	    		pprice.setText("Amount : "+String.valueOf(NoTicket*price));
	    		price = 200 ;
	    	}
	    	else if((c.getText().matches("CD5432WX32")) && (bil.getText().matches("67890")))
	    	{
	    		pprice.setText("Amount : "+String.valueOf(NoTicket*200));
	    		price = 200 ;
	    	}
	    	else if((c.getText().matches("MN4587CD87")) && (bil.getText().matches("78901")))
	    	{
	    		pprice.setText("Amount : "+String.valueOf(NoTicket*200));
	    		price = 200 ;
	    	}
	    	else if((c.getText().matches("PQ4567AB56")) && (bil.getText().matches("88002")))
	    	{
	    		pprice.setText("Amount : "+String.valueOf(NoTicket*200));
	    		price = 200 ;
	    	}
	       	else 
	    	{
	       		 pprice.setText("Amount : "+String.valueOf(NoTicket*price));
	    		    c.setBorder(BorderFactory.createLineBorder(Color.RED,2,true));
	    	       bil.setBorder(BorderFactory.createLineBorder(Color.RED,2,true));
	    		
	    	}
	    	
	    }
	    
	    if(e.getSource() == back1)
	    {
	    	new FrontPage();
	    	NoTicket = 0;
	    	f.dispose();
	    }
	    
	    if(e.getSource() == back )
	    {
	    	NoTicket = 0;
	    	new ChooseCIty().Choose(sign_user);
	    }
	}

}
