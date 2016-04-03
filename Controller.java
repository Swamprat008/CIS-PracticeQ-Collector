package automationFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Controller {

	WebDriver driver;
	String fileName;

	GUI gui;
	int speed;
	String quizName;
	CheckDuplicates cd;
	FindQA findqa;
	WriteToFile writetofile;
	QuizFill qf;
	int numTimes;
	Thread threadMain;

	public Controller(WebDriver driver, String fileName, GUI gui, int speed, String quizName, CheckDuplicates cd,
			FindQA findqa, WriteToFile writetofile, QuizFill qf, int numTimes) {

		this.driver = driver;
		this.fileName = fileName;
		this.gui = gui;
		this.speed = speed;
		this.quizName = quizName;
		this.cd = cd;
		this.findqa = findqa;
		this.writetofile = writetofile;
		this.qf = qf;
		this.numTimes = numTimes;

	}

	public void login(String username, String passwrd) {

		// create new instance of login class
		Login login = new Login(driver);

		// if login is successful, continue
		if (login.WebLogin(username, passwrd)) {
			Quiz();
		} else {
			gui.setTextArea("Unable to login, please check username and password, then try again.");
		}
	}

	public void Quiz() {

		FindQuiz findquiz = new FindQuiz(driver);

		// if it found the quiz, continue
		if (findquiz.QuizPick(quizName)) {
			QA(false);
		}
	}

	public void QA(boolean secondTime) {

		String question;
		String answer;
		if (secondTime == false) {
			gui.setTextArea("Finding all correct answers");
		}
		for (;;) {
			question = findqa.FindQ(true);
			answer = findqa.FindA(speed);
			System.out.println("answer received QA: " + answer);

			if (question == null) {
				gui.setTextArea("Creating text File in Documents");
				QuizFiller();
				break;
			}

			Write(question, answer, fileName);

		}

	}

	public void Write(String question, String answer, String fileName) {

		writetofile.write(question, answer, fileName);
		// fileName = writetofile.fileName;
	}

	public void QuizFiller() {

		gui.setTextArea("Answering remaining questions, using text file.");
		try {

			for (;;) {
				String answer = qf.QuizQA(fileName, speed);
				System.out.println("answer received: " + answer);

				if (answer == null) {
					gui.setTextArea("Answer missing from text file. Adding it!");
					System.out.println("\nAnswer missing from text file. Adding it!");
					QA(true);
				}
				if (qf.QuizAFill(answer, speed)) {
					continue;
				} else {
					gui.setTextArea("Done!!");
					if (numTimes > 1) {
						numTimes -= 1;
						Quiz();
					} else {
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
