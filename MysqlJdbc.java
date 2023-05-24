import java.sql.*;
import java.util.*;
public class MysqlJdbc
{
    public static void main(String Args[])
    {
        try 
        {
            int ch;
            Scanner sc= new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
            Statement stmt = cn.createStatement();  
            stmt.execute(" create table if not exists books(bno int,bnm varchar(20),bpr int,bpb varchar(20));");
            while(true)
            {
                System.out.println("1.Insert\n2.Delete\n3.Update\n4.Display\n5.Exit\nEnter your choice : ");
                ch = sc.nextInt();
                switch(ch)
                {
                    case 1:
                        int bno,bpr;
                        String bnm,bpb;
                        System.out.println("Enter Book no : ");
                        bno=sc.nextInt();
                        System.out.println("Enter Book Name : ");
                        bnm = sc.next();
                        System.out.println("Enter Book Price : ");
                        bpr = sc.nextInt();
                        System.out.println("Enter Book Publication : ");
                        bpb = sc.next();
                        PreparedStatement pst=cn.prepareStatement("insert into books values(?,?,?,?)");
                        pst.setInt(1,bno);
                        pst.setString(2,bnm);
                        pst.setInt(3,bpr);
                        pst.setString(4,bpb);
                        pst.executeUpdate();
                        break;
                    case 2:
                        boolean st;
                        int dbno;
                        System.out.println("Enter Book no to delete : ");
                        dbno=sc.nextInt();
                        st = stmt.execute("delete from books where bno="+dbno);
                        if(st)
                        {
                                System.out.println("Deleted");
                        } else{
                            System.out.println("Book Not found");
                        }
                        break;
                    case 3: 
                        int ubno,ubpr,uch;
                        String ubnm,ubpb;
                        System.out.println("Enter Book no to Updated : ");
                        ubno=sc.nextInt();
                        ResultSet rs1=stmt.executeQuery("select * from books where bno="+ubno);  
                        System.out.println("\n--------------------------------------");
                        while(rs1.next())  
                        {
                            System.out.println("\nBook Name : "+rs1.getString(2)+"\nPrice : "+rs1.getInt(3)+"\nPublication : "+rs1.getString(4));
                            System.out.println("\n--------------------------------------");  
                        }
                        System.out.println("Enter What to UPDATE\n1.Name\n2.Price\n3.Publication\nEnter choice : ");
                        uch = sc.nextInt();
                        switch(uch)
                        {
                            case 1:
                                System.out.println("Enter Book Name : ");
                                ubnm = sc.next();
                                stmt.execute("update books set bnm='"+ubnm+"' where bno="+ubno);
                                break;
                            case 2:
                                System.out.println("Enter Book Price : ");  
                                ubpr = sc.nextInt();
                                stmt.execute("update books set bpr="+ubpr+" where bno="+ubno);
                                break;
                            case 3 :
                                System.out.println("Enter Book Publication : ");
                                ubpb = sc.next();
                                stmt.execute("update books set bpb='"+ubpb+"' where bno="+ubno);
                                break;
                        }
                        break;
                    case 4:
                        ResultSet rs=stmt.executeQuery("select * from books");  
                        System.out.println("\n--------------------------------------");
                        while(rs.next())  
                        {
                            System.out.println("Bookno : "+rs.getInt(1)+"\nBook Name : "+rs.getString(2)+"\nPrice : "+rs.getInt(3)+"\nPublication : "+rs.getString(4));
                            System.out.println("\n--------------------------------------");  
                        }
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Wrong choice !!!");
                }
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}