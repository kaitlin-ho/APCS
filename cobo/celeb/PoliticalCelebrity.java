/*
Erica's Fans and Hugo (Hugo Jenkins, Kaitlin Ho, Ariella Katz)
APCS pd 6
L09: Some Folks Call It A Charades
2022-04-26
time spent: 5 hrs
*/

import java.util.ArrayList;

public class PoliticalCelebrity extends Celebrity {
  /**
   * The list of clues for the Political Celebrity. They can be beliefs, party allignments, quotes, ...s
   */
  private ArrayList<String> clueList;

  /**
   * Builds a PoliticalCelebrity instance with an answer and a series of clues as a String separated by commas.
   * @param answer The Political celebrity
   * @param clues Clues for the Political celebrity
   */
  public PoliticalCelebrity(String answer, String clues)
  {
    super(answer, clues);
    processClues();
  }

  /**
   * Processes the series of clues for the PoliticalCelebrity by adding all the values to an ArrayList<String> by
   * splitting the original clue to an array of String.
   * The original value is not impacted, thus preserving data and inheritance integrity.
   */
  private void processClues()
  {
    String [] clues = super.getClue().split(",");
    clueList = new ArrayList<String>();
    for (String currentClue : clues)
    {
      clueList.add(currentClue);
    }
  }

  /**
   * Overridden version of the getClue() method that cycles through each of the individual clues in the series.
   * It recreates the clueList if the user has finished the series of clues.
   */
  @Override
  public String getClue()
  {
    if (clueList.size() == 0)
    {
      processClues();
    }
    String currentClue = clueList.remove(0);

    return currentClue;
  }
/* Not Necessary
  @Override
  public String getAnswer()
  {
    return _answer;
  }
*/
  @Override
  public String toString()
  {
    String dsc = "This is the Political celebrity: " + getAnswer() + "\nThe clues are:\n";

    for (String word : super.getClue().split(","))
    {
      dsc += word + "\n";
    }

    return dsc;
  }

}
