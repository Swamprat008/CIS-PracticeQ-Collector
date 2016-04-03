package automationFramework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindQA {

	WebDriver driver;
	String text;
	CheckDuplicates cd;
	ArrayList<String> list = new ArrayList<String>();
	QuestionGetSet gs = new QuestionGetSet();

	public FindQA(WebDriver driver, CheckDuplicates cd, ArrayList<String> list, QuestionGetSet gs) {
		this.driver = driver;
		this.cd = cd;
		this.list = list;
		this.gs = gs;

	}

	public String FindQ(boolean checkDuplicates) {

		try {
			WebElement question = driver.findElement(By.tagName("p"));
			System.out.println("FindQ: " + question.getText());
			String text = question.getText();

			if (checkDuplicates) {

				String value = cd.CheckDuplicats(text, list, gs);
				return value;
			}else{
				return text;
			}
			

		} catch (Exception e) {
			
		}
		return null;
	}

	public String FindA(int speed) {

		String one = "", two = "", three = "", four = "", five = "", six = "";
		int time = speed;

		try {

			List<WebElement> answer = driver.findElements(By.tagName("p"));
			int size = answer.size();

			if (size == 10) {// 6 possible answers

				// save answers to string
				one = answer.get(1).getText();
				two = answer.get(2).getText();
				three = answer.get(3).getText();
				four = answer.get(4).getText();
				five = answer.get(5).getText();
				six = answer.get(6).getText();

				// click first checkbox
				WebElement CheckBox = driver.findElement(By.cssSelector("input[value='1']"));
				CheckBox.click();

				// submit the answer
				WebElement button = driver.findElement(By.name("hash"));
				button.submit();

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong = driver.findElements(By.className("QzHint"));
				if (Wrong.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();
					// System.out.println("clicked back, wrong answer 1");

					// submit answer 2
					Thread.sleep(time);
					WebElement CheckBox2 = driver.findElement(By.cssSelector("input[value='2']"));
					CheckBox2.click();
					Thread.sleep(time);
					WebElement button2 = driver.findElement(By.name("hash"));
					button2.submit();
				} else {

					return one;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong2 = driver.findElements(By.className("QzHint"));
				if (Wrong2.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox3 = driver.findElement(By.cssSelector("input[value='3']"));
					CheckBox3.click();
					;
					Thread.sleep(time);
					WebElement button3 = driver.findElement(By.name("hash"));
					button3.submit();
				} else {

					return two;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong3 = driver.findElements(By.className("QzHint"));
				if (Wrong3.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox4 = driver.findElement(By.cssSelector("input[value='4']"));
					CheckBox4.click();
					Thread.sleep(time);
					WebElement button4 = driver.findElement(By.name("hash"));
					button4.submit();
				} else {

					return three;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong4 = driver.findElements(By.className("QzHint"));
				if (Wrong4.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox5 = driver.findElement(By.cssSelector("input[value='5']"));
					CheckBox5.click();
					Thread.sleep(time);
					WebElement button5 = driver.findElement(By.name("hash"));
					button5.submit();
				} else {

					return four;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong5 = driver.findElements(By.className("QzHint"));
				if (Wrong5.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox6 = driver.findElement(By.cssSelector("input[value='6']"));
					CheckBox6.click();
					Thread.sleep(time);
					WebElement button6 = driver.findElement(By.name("hash"));
					button6.submit();

					return six;
				} else {

					return five;
				}

			} else if (size == 9) {// 5 possible answers

				// save answers to string
				one = answer.get(1).getText();
				two = answer.get(2).getText();
				three = answer.get(3).getText();
				four = answer.get(4).getText();
				five = answer.get(5).getText();

				// click first checkbox
				WebElement CheckBox1 = driver.findElement(By.cssSelector("input[value='1']"));
				CheckBox1.click();

				// submit the answer
				WebElement button1 = driver.findElement(By.name("hash"));
				button1.submit();

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong = driver.findElements(By.className("QzHint"));
				if (Wrong.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 2
					Thread.sleep(time);
					WebElement CheckBox2 = driver.findElement(By.cssSelector("input[value='2']"));
					CheckBox2.click();
					Thread.sleep(time);
					WebElement button2 = driver.findElement(By.name("hash"));
					button2.submit();
				} else {

					return one;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong2 = driver.findElements(By.className("QzHint"));
				if (Wrong2.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();
					// System.out.println("clicked back, wrong answer 2");

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox3 = driver.findElement(By.cssSelector("input[value='3']"));
					CheckBox3.click();
					Thread.sleep(time);
					WebElement button3 = driver.findElement(By.name("hash"));
					button3.submit();
				} else {

					return two;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong3 = driver.findElements(By.className("QzHint"));
				if (Wrong3.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox4 = driver.findElement(By.cssSelector("input[value='4']"));
					CheckBox4.click();
					Thread.sleep(time);
					WebElement button4 = driver.findElement(By.name("hash"));
					button4.submit();
				} else {

					return three;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong4 = driver.findElements(By.className("QzHint"));
				if (Wrong4.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox5 = driver.findElement(By.cssSelector("input[value='5']"));
					CheckBox5.click();
					Thread.sleep(time);
					WebElement button5 = driver.findElement(By.name("hash"));
					button5.submit();

					return five;

				} else {

					return four;
				}

			} else if (size == 8) {// 4 possible answers

				// save answers to string
				one = answer.get(1).getText();
				two = answer.get(2).getText();
				three = answer.get(3).getText();
				four = answer.get(4).getText();

				// click first checkbox
				WebElement CheckBox1 = driver.findElement(By.cssSelector("input[value='1']"));
				CheckBox1.click();

				// submit the answer
				WebElement button1 = driver.findElement(By.name("hash"));
				button1.submit();

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong = driver.findElements(By.className("QzHint"));
				if (Wrong.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 2
					Thread.sleep(time);
					WebElement CheckBox2 = driver.findElement(By.cssSelector("input[value='2']"));
					CheckBox2.click();
					Thread.sleep(time);
					WebElement button2 = driver.findElement(By.name("hash"));
					button2.submit();
				} else {

					return one;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong2 = driver.findElements(By.className("QzHint"));
				if (Wrong2.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox3 = driver.findElement(By.cssSelector("input[value='3']"));
					CheckBox3.click();
					Thread.sleep(time);
					WebElement button3 = driver.findElement(By.name("hash"));
					button3.submit();
				} else {

					return two;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong3 = driver.findElements(By.className("QzHint"));
				if (Wrong3.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 4
					Thread.sleep(time);
					WebElement CheckBox4 = driver.findElement(By.cssSelector("input[value='4']"));
					CheckBox4.click();
					Thread.sleep(time);
					WebElement button4 = driver.findElement(By.name("hash"));
					button4.submit();

					return four;

				} else {

					return three;
				}

			} else if (size == 7) {// 3 possible answers

				// save answers to string
				one = answer.get(1).getText();
				two = answer.get(2).getText();
				three = answer.get(3).getText();

				// click first checkbox
				WebElement CheckBox1 = driver.findElement(By.cssSelector("input[value='1']"));
				CheckBox1.click();

				// submit the answer
				WebElement button1 = driver.findElement(By.name("hash"));
				button1.submit();

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong = driver.findElements(By.className("QzHint"));
				if (Wrong.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 2
					Thread.sleep(time);
					WebElement CheckBox2 = driver.findElement(By.cssSelector("input[value='2']"));
					CheckBox2.click();
					Thread.sleep(time);
					WebElement button2 = driver.findElement(By.name("hash"));
					button2.submit();

				} else {

					return one;
				}

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong2 = driver.findElements(By.className("QzHint"));
				if (Wrong2.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 3
					Thread.sleep(time);
					WebElement CheckBox3 = driver.findElement(By.cssSelector("input[value='3']"));
					CheckBox3.click();
					Thread.sleep(time);
					WebElement button3 = driver.findElement(By.name("hash"));
					button3.submit();

					return three;
				} else {

					return two;
				}

			} else if (size == 6) {// 2 possible answers

				// save answers to string
				one = answer.get(1).getText();
				two = answer.get(2).getText();

				// click first checkbox
				WebElement CheckBox1 = driver.findElement(By.cssSelector("input[value='1']"));
				CheckBox1.click();

				// submit the answer
				WebElement button1 = driver.findElement(By.name("hash"));
				button1.submit();

				// check to see if the "Wrong Answer" screen displays
				List<WebElement> Wrong = driver.findElements(By.className("QzHint"));
				if (Wrong.size() == 1) {

					// if Wrong answer screen displays then return back
					WebElement tryAgain = driver.findElement(By.tagName("a"));
					tryAgain.click();

					// submit answer 2
					Thread.sleep(time);
					WebElement CheckBox2 = driver.findElement(By.cssSelector("input[value='2']"));
					CheckBox2.click();
					Thread.sleep(time);
					WebElement button2 = driver.findElement(By.name("hash"));
					button2.submit();

					return two;
				} else {

					return one;
				}

			} else {
				return null;
			}

		} catch (Exception e) {

		}
		return null;
	}

}
