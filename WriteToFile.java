package automationFramework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class WriteToFile {

	WebDriver driver;
	String fileName;

	public WriteToFile(WebDriver driver) {
		this.driver = driver;
	}

	public void write(String question, String answer, String fileName) {
		String userName = System.getProperty("user.name");

		File file = new File("C:\\Users\\"+ userName +"\\Documents\\" + fileName + ".txt");

		try {
			if (!file.isFile()) {
				file.createNewFile();

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(question);
				bw.newLine();
				bw.write(answer);
				bw.newLine();
				bw.newLine();
				bw.close();
			}else{
				BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\"+ userName +"\\Documents\\" + fileName + ".txt", true));
				bw.append(question);
				bw.newLine();
				bw.append(answer);
				bw.newLine();
				bw.newLine();
				bw.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
