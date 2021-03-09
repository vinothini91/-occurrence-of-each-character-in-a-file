package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CharacterTest {

	public static void main(String[] args) {
		try

		{

			String user = null;

			String fileName = null;

			Path p = Paths.get("C:/Users/Brahmanandam/eclipse-workspace/hello/");

			System.out.println("path:" + p);

			File f = new File(p.toString()); // It contains file

			File[] listOfFiles = f.listFiles();

			System.out.println("List of files:");

			for (int i = 0; i < listOfFiles.length; i++)

			{

				// System.out.println(listOfFiles[i]);

				if (listOfFiles[i].isFile())

				{

					fileName = listOfFiles[i].getName();

					if (fileName.endsWith(".txt"))

					{

						System.out.println(fileName);

					}

				}

			}

			InputStreamReader in = new InputStreamReader(System.in);

			BufferedReader br = new BufferedReader(in);

			System.out.println("Enter file name:");

			user = br.readLine();

			user = user + ".txt";

			boolean present = f.exists();

			System.out.println("File exists:" + user);

			Path path = Paths.get("C:/Users/Brahmanandam/eclipse-workspace/hello/" + user);

			File file = new File(path.toString());

			InputStream input = new FileInputStream(file);

			BufferedReader reader1 = new BufferedReader(new InputStreamReader(input));

			String line = null;

			while ((line = reader1.readLine()) != null)

				// {

				System.out.println("Read File:" + line);

			// line=reader1.readLine();

			// }

			Path path1 = Paths.get("C:/Users/Brahmanandam/eclipse-workspace/hello/" + user);

			File file1 = new File(path1.toString());
			FileInputStream fis = new FileInputStream(file1);
			InputStreamReader incount = new InputStreamReader(fis);
			BufferedReader readercount = new BufferedReader(incount);
			String linee;
			String linecheck;
			String linecheck1;
			int linecount = 0;
			int charcount = 0;
			int vowelcount = 0;
			String longestword = "";

			while ((linecheck = readercount.readLine()) != null) {
				linecount++;

				charcount += linecheck.length();
				for (int i = 0; i < linecheck.length(); i++) {
					if (linecheck.charAt(i) == 'a' || linecheck.charAt(i) == 'e' || linecheck.charAt(i) == 'i'
							|| linecheck.charAt(i) == 'o' || linecheck.charAt(i) == 'u') {
						vowelcount++;
					}
				}
				Scanner sc = new Scanner(new File("C:/Users/Brahmanandam/eclipse-workspace/hello/" + user));
				while (sc.hasNext()) {
					linecheck = sc.next();
					if (linecheck.length() > longestword.length()) {
						longestword = linecheck;
					}
				}

			}

			System.out.println("line count:" + linecount);
			System.out.println("chartr count:" + charcount);
			System.out.println("vowels count:" + vowelcount);
			System.out.println("longest word:" + longestword);

			HashMap<Integer, Integer> hash = new HashMap<>();

			// Load this text file.
			BufferedReader readerchar = new BufferedReader(
					new FileReader("C:/Users/Brahmanandam/eclipse-workspace/hello/" + user));

			while ((linee = readerchar.readLine()) != null) {

				linee = linee.toLowerCase().replaceAll("[^a-zA-Z]", " ");

				for (int i = 0; i < linee.length(); i++) {
					char c = linee.charAt(i);
					if (c != ' ') {
						// Increment existing value in HashMap.
						// ... Start with zero if no key exists.
						int value = hash.getOrDefault((int) c, 0);
						hash.put((int) c, value + 1);
					}
				}
			}

			// Close object.
			readerchar.close();

			// Display values of all keys.
			for (int key : hash.keySet()) {
				System.out.println((char) key + ": " + hash.get(key));
			}

		}

		catch (Exception e) {

		}

	}

}
