package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudentReport {

	public static void main(String[] args) {
		
		String sname = null;
		String sgender = null;
		String sdob = null;
		String sgrade = null;
		String rollno = null ;
		String scount=null;
		int total=2;
		
		try
		{
			//  int total1 =0;
			//	total1 =total;
				
for(int i=1; i< total;i++) 
{
	
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(ir);

			File f = new File("F:/vino--programs-2021/student.txt/");
			Path p = Paths.get(f.toString());
			OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, APPEND));
			//OutputStream out = new BufferedOutputStream(Files.newOutputStream(p));
			
			
			System.out.println("Student Name:");
			sname = br.readLine();
			byte[] dataname = sname.getBytes();
			out.write(dataname);

			System.out.println("Student Gender:");
			sgender = br.readLine();
			byte[] datagender = sgender.getBytes();
			out.write(datagender);
				
		
			System.out.println("Student Date Of Birth:");
			sdob = br.readLine();
			byte[] datasdob = sdob.getBytes();
			out.write(datasdob);

			System.out.println("Student Grade:");
			sgrade = br.readLine();
			byte[] datasgrade = sgrade.getBytes();
			out.write(datasgrade);
			
		     rollno= br.readLine();
			 rollno=rollno+i;        // here roll no will get auto generated
			byte[]dataroll = rollno.getBytes();
			out.write(dataroll);
			
			out.close();

			
		BufferedReader in = new BufferedReader(new FileReader(f));
			String line = null;
			while ((line = in.readLine()) != null) 
			{
				System.out.println("Student Rollno:" + line);
				line = in.readLine();
				
				
			}
			
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader brs = new BufferedReader(isr);

			File scountfile = new File("F:/vino--programs-2021/student_count.txt/");
			Path p1 = Paths.get(scountfile.toString());
			OutputStream os = new BufferedOutputStream(Files.newOutputStream(p1)); // file should not in append mode

			System.out.println("Press Enter:");
			scount= brs.readLine();
			
			scount = scount +rollno;
			byte[] datascount = scount.getBytes();
			os.write(datascount);
			os.close(); 

			BufferedReader brcount = new BufferedReader( new FileReader(scountfile));
			String totalcount=null;
			while((totalcount = brcount.readLine()) != null) 
					{
				System.out.println(" STUDENT COUNT :"+ totalcount); 
					}  
			
		}




	}
			
	catch (Exception e)
		{

		}

	}

}



