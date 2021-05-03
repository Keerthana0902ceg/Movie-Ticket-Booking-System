import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.regex.Pattern;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class FrontPage  implements ActionListener
{
	
	JFrame f ;
	Timer t ;
	static final String DB_URL = "jdbc:oracle:thin:@//localhost/oracle";

	  static final String USER = "java_project";
	  static final String PASS = "pass";
	JLabel poster , uname , password ,logo , mail , cnt,user,psd,m,phn ;
	JButton signin , signup , submit ;
	JTextField em , email ,  contact ;  /** em will take the user-name 
	                                       
	                                          email will take e-mail address
	                                       contact will take contact no   */
	JPasswordField pass ;
	static int  po , pop = 0 ;
	String pcheck =  "^[0-9]{10}$" , mcheck = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	String ema , un ;
	FrontPage() 
	{
		pop = 0 ;
		f = new JFrame("WELCOME TO YOUR TICKET-Book seats of your choice") ;
		f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		f.setLayout(null);
		Color mycolor = new Color(79,8,9);
		f.getContentPane().setBackground(mycolor);
	
		logo = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\text_logo.png"));
	  	f.add(logo);
	  	logo.setBounds(50, 5, 350, 250);
	  	
	  	logo = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\pic_logo.png"));
	  	f.add(logo);
	  	logo.setBounds(1550, 5, 350, 250);
		
	  
		
		uname = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\username.png")) ;   
        f.add(uname);
   	    uname.setBounds(500, 50 ,100, 110);
   	    
   	    Font fo = new Font("Cambria",Font.ITALIC,26);
	    user = new JLabel("Enter username");
	    user.setBounds(650,40,190,30);
	    user.setForeground(Color.white);
	    user.setFont(fo);
	    f.add(user);
	    em = new JTextField();
	    f.add(em);
	    em.setBounds(650, 75, 240, 45);
	    em.setFont(new Font("Baskerville",Font.BOLD,16));
	    em.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));
	    
	    
	   
	
   	    
   	    
   	    password = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\password.png"));
	    f.add(password);
	    password.setBounds(1000, 50, 100, 110);
	    
	    psd = new JLabel("Enter password");
	    psd.setBounds(1150,40,190,30);
	    psd.setForeground(Color.white);
	    psd.setFont(fo);
	    f.add(psd);
	    pass = new JPasswordField();
	    f.add(pass);
	    pass.setBounds(1150, 75, 240, 45);
	    pass.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));
	    
	    
	    
	    
	    mail = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\mail.png"));
	    f.add(mail);
	    mail.setBounds(500, 180, 100, 110);
	    mail.setVisible(false);
	    
	    
	    m = new JLabel("Enter mail-id");
	    m.setBounds(650,180,190,30);
	    m.setForeground(Color.white);
	    m.setFont(fo);
	    f.add(m);
	    email = new JTextField();
	    f.add(email);
	    email.setBounds(650, 219, 240, 45);
	    email.setFont(new Font("Baskerville",Font.BOLD,16));
	    email.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));
	    email.setVisible(false);
	    m.setVisible(false);
	    
	    
	    cnt = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\phone.png"));
	    f.add(cnt);
	    cnt.setBounds(1000, 180, 100, 110);
	    cnt.setVisible(false);
	    
	    phn = new JLabel("Enter phone no.");
	    phn.setBounds(1150,180,190,30);
	    phn.setForeground(Color.white);
	    phn.setFont(fo);
	    f.add(phn);
	    contact = new JTextField();
	    f.add(contact);
	    contact.setBounds(1150, 219, 240, 45);
	    contact.setFont(new Font("Baskerville",Font.BOLD,16));
	    contact.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));
	    contact.setVisible(false);
	    phn.setVisible(false);
	    
	      
	    signin = new JButton("LOGIN") ;
	    f.add(signin);
	    signin.setBackground(Color.black);
	    signin.setForeground(Color.white);
	    signin.setFont(new Font("Arial", Font.BOLD, 20));
	    signin.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
	    signin.setBounds(764, 200, 128, 53);
	    signin.addActionListener(this);
	    
	    signup = new JButton("REGISTER") ;
	    f.add(signup);
	    signup.setBackground(Color.black);
	    signup.setForeground(Color.white);
	    signup.setFont(new Font("Arial", Font.BOLD, 20));
	    signup.setBounds(970,200,128,53);
	    signup.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
	    signup.addActionListener(this);
		
	    
	    submit = new JButton("SUBMIT") ;
	    f.add(submit);
	    submit.setBackground(Color.black);
	    submit.setForeground(Color.white);
	    submit.setFont(new Font("Arial", Font.BOLD, 20));
	    submit.setBounds(1430,280,128,53);
	    submit.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
	    submit.addActionListener(this);
	    submit.setVisible(false);
	    
	    
	    poster = new JLabel(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\welcomee.jpg"));
		
		poster.setBounds(0, 350, 2001,732);
	//	poster.setSize(2350, 700);
		f.add(poster);
		
	
	
		
		po = 1 ;
		t = new Timer(3000, new ActionListener()
				{
			

					@Override
					public void actionPerformed(ActionEvent e) {
						
						// TODO Auto-generated method stub
						if(po == 1)
						{
							poster.setIcon(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\kkkk.jpg"));
							po++ ;
						}
						else if(po == 2)
						{
							poster.setIcon(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\kaithi.jpg"));
							po++ ;
							
						}
						else if(po == 3)
						{
							poster.setIcon(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\kabalii.jpg"));
							po++ ;
							
						}
						else if(po == 4)
						{
							poster.setIcon(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\mala.jpg"));
							po++ ;
							
						}
						else if(po == 5)
						{
							poster.setIcon(new ImageIcon("C:\\Users\\svjk0\\OneDrive\\Desktop\\SEM 5\\java\\movie time\\avengerss.png"));
							po = 1 ;
							
						}
						
					}
			
				}) ;
		t.start();
		
		
	   
		f.setVisible(true);
		
				
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource() == signup)  // signup is the register button
		{
		    mail.setVisible(true);
		    email.setVisible(true);
		    cnt.setVisible(true);
		    m.setVisible(true);
		    submit.setVisible(true);
		    contact.setVisible(true);
		    signup.setVisible(false);
		    signin.setVisible(false);
		    em.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
			pass.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
			email.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
			contact.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
       	}
       	
		
		
		if(e.getSource() == signin)
		{
			
	//		 em.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		//	 pass.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			 
			 
			 Connection con = null;
			  Statement stmt = null;
			 try
		       {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(DB_URL, USER, PASS);
			     System.out.println("Connected database successfully for front page...");
			     stmt = con.createStatement();
		    	   String qry = "select username,password from customer where username = " + "'"+em.getText()+"'"+ "and password ="+"'"+pass.getText()+"'";
		           
		           ResultSet rs = stmt.executeQuery(qry);
		           	if(rs.next())
		           	{
		           	    
		           		new ChooseCIty().Choose(em.getText()) ;
		           		f.dispose();
		           	}
		           	else
		           	{
		           		em.setText("");
		           		pass.setText("");
		           		em.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		   			    pass.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		           	}
		         
		        
		       }catch(Exception e1)
			 {
		       	e1.printStackTrace();
		      }
			
		}
		
		
	    if(e.getSource() == submit)
	    {
	    	Pattern ma = Pattern.compile(mcheck);
            Pattern ph = Pattern.compile(pcheck);	    	
	    	if(ma.matcher(email.getText()).matches() && ph.matcher(contact.getText()).matches())
	    	{
	    		
	    		
	    		Connection con = null;
	    		  Statement stmt = null;
	    		try
		        {
	    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			 con = DriverManager.getConnection(DB_URL, USER, PASS);
	    		     System.out.println("Connected database successfully for register...");
	    		     stmt = con.createStatement();
		            PreparedStatement ps2 = con.prepareStatement("insert into customer values(?,?,?,?)");
		            ps2.setString(1, em.getText());
		            ps2.setString(2, pass.getText());
		            ps2.setString(3, email.getText());
		            ps2.setString(4, contact.getText());
		            ps2.executeUpdate() ;
		            
		            mail.setVisible(false);
				    email.setVisible(false);
				    cnt.setVisible(false);
				    submit.setVisible(false);
				    m.setVisible(false);
				    contact.setVisible(false);
				    signup.setVisible(true);
				    signin.setVisible(true);
				    
				    String msg = "Thank You " + em.getText()+" for using Your Ticket . We will try to make your experience of booking movie tickets much better than before . " ;
					String sub = "WELCOME TO YOUR-TICKET" ;
					String from = "shrukoals@gmail.com" ;  
					String to = email.getText() ;
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
					// default session 
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
					   
		          
		         
		        }catch(Exception e1){
		        	e1.printStackTrace();
		        }
	    			
	    		
	    	}
	    	if(ma.matcher(email.getText()).matches() == false)
	    	{
	    		  email.setText("");
	    		  email.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
	    		
	    	}
	    	if(ph.matcher(contact.getText()).matches() == false)
	    	{
	    		  contact.setText("");
	    		  contact.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
	    	}
	    	
	    		
	    }
		
		
	}
	
	public static void main(String args[]) 
	{
		new FrontPage();
		
		

}
	}
