package com.Reservation;
import java.util.regex.*;
import java.lang.Thread;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.sql.*;
public class booking 
{
    public Connection getconn()
    {
        Connection con = null;
        try
        {
            String url= "jdbc:mysql://localhost:3306/b_ticket";
            String usernm="root";
            String pass="vijay@123456";
            con = DriverManager.getConnection(url,usernm,pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }


    Scanner sc1 = new Scanner(System.in);

    public String admin() throws SQLException
    {
        System.out.println("You have Choosen the 1st Option ");
        

        boolean flag = true;
        do
        {

        	Scanner sc = new Scanner(System.in);
    		System.out.println("Enter username");
    		String str = sc1.next();
    		System.out.println("Enter password");
    		String str1 = sc1.next();

    		Pattern p = Pattern.compile("(vijay)");
    		Pattern p1 = Pattern.compile("(prasad)");
    		
    		Matcher m = p.matcher(str);
    		Matcher m1 = p1.matcher(str1);
         
         if(m.matches()&&m1.matches())
         {
        	 System.out.println("*********Your Authentication Was Successfull********");
        	 flag = false;
         }
         else
         {

               System.out.println("######  Access Denied | Access Denied ######");
               System.out.println("%%%%%%%%% Please Enter Correct Details %%%%%%%%%%%");
         
         }
         //System.out.println("Enter password");
         //String password = sc1.next();

         //Connection con =getconn();
         //Statement stmt= con.createStatement();
         //ResultSet rs=stmt.executeQuery("select username,password from admin");




       //  if (rs.next()) {

             //if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) 
             //{
               //System.out.println("*********Your Authentication Was Successfull********");
             //  flag = false;
           //}

           //else  
           //{
             //  System.out.println("######  Access Denied | Access Denied ######");
           //    System.out.println("%%%%%%%%% Please Enter Correct Details %%%%%%%%%%%");
         //  }
       //}

   }
   while(flag);
        return "success";
}
    



public void user() throws SQLException
{

    boolean flag1 =true;

    System.out.println("**********ThankYou For Choosing the 2nd Option************");
    do 
    {
        System.out.println("Enter Username");
        String username = sc1.next();

        System.out.println("Enter password");
        String password = sc1.next();

        Connection con =getconn();
        Statement stmt= con.createStatement();
        ResultSet rs=stmt.executeQuery("select username,password from user");




        if (rs.next()) {

         if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) 
         {
           System.out.println("*********Your Authentication Was Successfull********");
           flag1 = false;
       }

       else  
       {
           System.out.println("######  Access Denied | Access Denied ######");
           System.out.println("%%%%%%%%% Please Enter Correct Details %%%%%%%%%%%");
       }
   }
}while(flag1);        

boolean flag3 = true;
do 
{
 System.out.println("press 1 if your the bus passenger");
 System.out.println("press 2 if your the train passenger");
 System.out.println("press 3 if your the flight passenger");
 System.out.println("press 4 to EXIT");


 int v = sc1.nextInt();


 Connection con = getconn();
 Statement stmt = con.createStatement();

 switch(v)
 {
 case 1:
	
    System.out.println("---Enter Your Aadharid---");
    int aa = sc1.nextInt();
    ResultSet rs1 = stmt.executeQuery("select * from bus where aadharid="+aa);
    if(rs1.next())
    {
    	System.out.println("Please wait 3 seconds for security results...");
    	      System.out.println("");
    	      try {
    	    	  Thread.sleep(3000);
    		  System.out.println("name: "+rs1.getString(1));
    		  Thread.sleep(3000);
    		  System.out.println("aadharid: "+rs1.getString(2));
    		  Thread.sleep(3000);
    		  System.out.println("source: "+rs1.getString(3));
    		  Thread.sleep(3000);
    		  System.out.println("destination: "+rs1.getString(4)); 
    		  Thread.sleep(3000);
    		  System.out.println("");
    	      }
    	      catch(Exception e)
    	      {
    	    	  System.out.println(e);
    	      }
    	      }
  else{
      System.out.println("SORRY NO RECORD FOUND");  
  }
	 
  break;

case 2: 
 System.out.println("---Enter Your Aadharid---");
 int aa1 = sc1.nextInt();
 ResultSet rs2 = stmt.executeQuery("select * from train where aadharid="+aa1);
 if(rs2.next())
 {

 	System.out.println("Please wait 3 seconds for security results...");
 	      System.out.println("");
 	      try {
 	    	  Thread.sleep(3000);
 		  System.out.println("name: "+rs2.getString(1));
 		  Thread.sleep(3000);
 		  System.out.println("aadharid: "+rs2.getString(2));
 		  Thread.sleep(3000);
 		  System.out.println("source: "+rs2.getString(3));
 		  Thread.sleep(3000);
 		  System.out.println("destination: "+rs2.getString(4)); 
 		 Thread.sleep(3000);
 		  System.out.println("");
 	      }
 	      catch(Exception e)
 	      {
 	    	  System.out.println(e);
 	      }
 	      }


else{
    System.out.println("SORRY NO RECORD FOUND");
}
break;
case 3: 
 System.out.println("---Enter Your Aadharid---");
 int aa2 = sc1.nextInt();
 ResultSet rs3 = stmt.executeQuery("select * from flight where aadharid="+aa2);
 if(rs3.next())
 {

 	System.out.println("Please wait 3 seconds for security results...");
 	      System.out.println("");
 	      try {
 	    	  Thread.sleep(3000);
 		  System.out.println("name: "+rs3.getString(1));
 		  Thread.sleep(3000);
 		  System.out.println("aadharid: "+rs3.getString(2));
 		  Thread.sleep(3000);
 		  System.out.println("source: "+rs3.getString(3));
 		  Thread.sleep(3000);
 		  System.out.println("destination: "+rs3.getString(4)); 
 		  Thread.sleep(3000);
 		  System.out.println("");
 	      }
 	      catch(Exception e)
 	      {
 	    	  System.out.println(e);
 	      }
 	      }

 else {
    System.out.println("SORRY NO RECORD FOUND");
}
break;
case 4:
    System.exit(0);
default : System.out.println("You Have Entered the Wromg Number");
 System.out.println("@@@@@@@@ Please Choose Under the OPtions.ThankYou @@@@@@@@@@@");
 break;

}

}while(flag3);
}




public void Bus() throws SQLException
{
    
    System.out.println("******THANKS FOR CHOOSING BUS********");
   
    try
    {
    Connection con = getconn();
    String s1 = "insert into Bus(name,aadharid,source,destination) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
   
    	System.out.println("Enter ur AadharID:");
        int id =sc1.nextInt();
        	
    
    
    System.out.println("Enter ur Source:");
    String soc = sc1.next   (); 
    System.out.println("Enter ur Destination");
    String des = sc1.next();  

    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setString(3,soc);
    stmt.setString(4,des);
    int a = stmt.executeUpdate();  

    }catch(InputMismatchException ex)
    {
    	System.out.println("please enter the correct INPUT_TYPE DETAILS "+ex);
    }

}


public void Train() throws SQLException
{
    
    System.out.println("******THAKS FOR CHOOSING TRAIN********");
    try
    {
    Connection con = getconn();
    String s1 = "insert into Train(name,aadharid,source,destination) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur Source:");
    String soc2 = sc1.next();
    System.out.println("enter ur destination");
    String des = sc1.next();


    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setString(3,soc2);
    stmt.setString(4,des);
    int b = stmt.executeUpdate(); 
    }
    catch(InputMismatchException ex)
    {
    	System.out.println("please enter the correct INPUT_TYPE DETAILS "+ex);
    }
}


public void Flight() throws SQLException
{

    System.out.println("******THANKS FOR CHOOSING FLIGHT********");
    try
    {
    Connection con = getconn();
    String s1 = "insert into Flight(name,aadharid,source,destination) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur Source:");
    String soc1 = sc1.next(); 
    System.out.println("Enter ur Destination");
    String des = sc1.next();

    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setString(3,soc1);
    stmt.setString(4,des);
    int c = stmt.executeUpdate();
    }
    catch(InputMismatchException ex)
    {
    	System.out.println("please enter the correct INPUT_TYPE DETAILS "+ex);
    }
}

public void update() throws SQLException
{
   try
   {
   Connection con = getconn();
   
System.out.println("which passenger your(bus,train,flight) ?");
           String pa = sc1.next();
           
        System.out.println("Which one Do You want an update. Choose ONE(name,source and destination)");
        String up1 = sc1.next();
        System.out.println("Drop a value You want Update");
        String up2 = sc1.next();
        System.out.println("Enter ur Aadahrid");
        String up3 = sc1.next();

        String s2 = "update " +pa+" set " +up1+"='"+up2+"'  where  aadharid="+up3;
        Statement stmt1 = con.createStatement();
        stmt1.executeUpdate(s2);
        System.out.println("Your Query was Successfully Updated");
        
   }
   catch(InputMismatchException ex)
   {
	   System.out.println("please enter the correct INPUT_TYPE DETAILS "+ex);
   }
   catch(SQLException e)
   {
	   System.out.println("please enter the correct SYNTAX_TYPE DETAILS "+e);
	      
   }


}
public void delete() throws SQLException
{
   try
   {
    Connection con = getconn();

        System.out.println("which passenger yor(bus,train,flight)");
            String pa1 = sc1.next();
            System.out.println("*** please delete your Account with ur Unique Aadhar_id ***");
            int dl1 = sc1.nextInt();

            String s5 = "delete from " +pa1+ " where aadharid="+dl1;
            Statement stmt4 = con.createStatement();
            stmt4.executeUpdate(s5);

            System.out.println(" YOUR ACCOUNT WAS DELETED SUCCEFULLY ");
        

   }
   catch(InputMismatchException ex)
   {
	   System.out.println("please enter the correct INPUT_TYPE DETAILS "+ex);
   }
   catch(SQLException e)
   {
	   System.out.println("please enter the correct SYNTAX_TYPE DETAILS "+e);
	      
   }

}

}