package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindQuiz {

	WebDriver driver;

	public FindQuiz(WebDriver driver) {

		this.driver = driver;
	}

	public boolean QuizPick(String quizName) {

		try {

			WebElement quizLink = driver.findElement(By.name("quizzes"));
			quizLink.click();

			WebElement pickQuiz = this.driver.findElement(By.name(quizName));
			Thread.sleep(500);
			pickQuiz.click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
