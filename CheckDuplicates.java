package automationFramework;

import java.util.ArrayList;

public class CheckDuplicates {

	public String CheckDuplicats(String question, ArrayList<String> list, QuestionGetSet gs) {

		gs.setQuestion(question);
		list.add(gs.getQuestion());

		System.out.println("Amount of questions in list " + list.size());

		for (int i = 0; i < list.size(); i++) {
			// Loop over all following elements.
			for (int x = i + 1; x < list.size(); x++) {
				// If two elements equal, there is a duplicate.
				if (list.get(i).equals((list.get(x)))) {
					list.remove(i);
					System.out.println("DUPLICATE FOUND: PROGRAM COMPLETE");
					return null;
				}
			}
		}
		// No duplicates found.
		return question;

	}

}
