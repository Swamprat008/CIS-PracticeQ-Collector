package automationFramework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizFill {

	WebDriver driver;
	private BufferedReader br;
	private String text;

	public QuizFill(WebDriver driver) {
		this.driver = driver;
	}

	public String QuizQA(String fileName, int speed) throws IOException {

		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement question = driver.findElement(By.tagName("p"));
		text = question.getText();
		String userName = System.getProperty("user.name");

		try {
			br = new BufferedReader(new FileReader("C:\\Users\\"+userName+"\\Documents\\" + fileName + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String line;
		Pattern pattern = Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE);
		while ((line = br.readLine()) != null) {

			Matcher matcher = pattern.matcher(line);
			if (matcher.matches()) {
				// return the answer to the question, located on the next line
				System.out.println("question found: " + matcher.group());
		        String answer = br.readLine().toString();
		        //System.out.println("answer found: " + answer);
		        
		        return answer;
			}
		}
		br.close();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean QuizAFill(String answer, int speed) {

		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> match = driver.findElements(By.tagName("p"));
		WebElement CheckBox;
		WebElement button;

		for (int i = 0; i < match.size(); i++) {
			if (match.get(i).getText().equals(answer)) {
				// click first checkbox
				CheckBox = driver.findElement(By.cssSelector("input[value='" + (i) + "']"));
				CheckBox.click();

				// submit the answer
				button = driver.findElement(By.name("hash"));
				button.submit();

				//System.out.println("submitted right answer: " + answer);
				return true;
			}
		}
		WebElement end = driver.findElement(By.name("main"));
		end.click();

		System.out.println("no match on HTML page");
		return false;

	}

}
