import javax.swing.JOptionPane;

public class Quiz {
    /**
     * isValid accapts a string and checks to see if it is A, B, or C
     * and returns a boolean value of true or false if it matches
     */
    private static boolean isValid(String a) {
        a = a.toLowerCase();
        if (a.equals("a") || a.equals("b") || a.equals("c")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please pick A, B, or C");
            return false;
        }
    }

    /**
     * askQuestion recieves an array containing the question and all the
     * answers. Returning the user input as a String
     */
    private static String askQuestion(String[] q) {
        String fmtQuestion = ""; // String to hold the formatted question
        String answer = "";

        for (int i = 0; i < q.length; i++)
            fmtQuestion += q[i] + "\n";

        do {
            answer = JOptionPane.showInputDialog(null, fmtQuestion);
            if (answer == null) {
                int quit = JOptionPane.showConfirmDialog(null, "Would you like to quit?", "Quit",
                        JOptionPane.YES_NO_OPTION);
                if (quit == 0)
                    return "ABORT";
                else
                    continue;
            }
        } while (answer == null || !(isValid(answer)));

        return answer;
    }

    /**
     * isCorrect recieves two values a (correct answer) and r (incorrect
     * answer). Returning a boolean value if the answer is correct or not
     */
    private static boolean isCorrect(String a, String r) // a = correct answer, r = user response
    {
        r = r.toUpperCase();
        if (a.equals(r)) {
            JOptionPane.showMessageDialog(null, "Correct!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "The correct answer is: \n" + a);
            return false;
        }
    }

    /**
     * showGrade accepts two values c (total correct answers) and i (total
     * incorrect answers). A message dialog is displayed stating the total
     * coreect, incorrect, and the grade for the test
     */
    public static void showGrade(int c, int i) {
        String fmtGrade = "";
        fmtGrade += "You answered " + c + " correctly and " + i + " incorrectly";

        JOptionPane.showMessageDialog(null, fmtGrade);
    }

    public static void main(String[] args) {
        int i = 0; // iterator to be used later for the askQuestion loop
        int correct = 0; // number of correct answers
        int incorrect = 0; // number of incorrect answers
        String response = ""; // holds the answer the user supplied temporarily

        /*
         * I know multi-dimensional arrays are not till next chapter but
         * I already knew about them and felt that it really was the best
         * option for this assignment
         */

        String[][] question = new String[10][4]; // Array to store questions
        String[] correctAnswer = new String[10]; // Array to store correct answers

        question[0][0] = "In the process of cake baking which of the following is NOT a raising agent?";
        question[0][1] = "A) powdered sugar";
        question[0][2] = "B) yeast";
        question[0][3] = "C) baking powder";
        correctAnswer[0] = "A";

        question[1][0] = "A vanilla sponge cake sandwiched with jam and cream filling is named after what British monarch?";
        question[1][1] = "A) Elizabeth I";
        question[1][2] = "B) Elizabeth II";
        question[1][3] = "C) Victoria";
        correctAnswer[1] = "C";

        question[2][0] = " The classic chocolate brownie consists of butter, sugar, chocolate, flour and what other ingredient?";
        question[2][1] = "A) coffee";
        question[2][2] = "B) milk";
        question[2][3] = "C) egg";
        correctAnswer[2] = "C";

        question[3][0] = "What baking technique breaks up lumps in flour to get a more accurate measurement?";
        question[3][1] = "A) whisking";
        question[3][2] = "B) sifting";
        question[3][3] = "C) mixing";
        correctAnswer[3] = "B";

        question[4][0] = "In bread making, what is the process of folding and pressing dough to create gluten and elasticity?";
        question[4][1] = "A) kneading";
        question[4][2] = "B) leavening";
        question[4][3] = "C) proofing";
        correctAnswer[4] = "A";

        question[5][0] = "What popular Italian dessert made with coffee and ladyfingers translates to “carry me up”?";
        question[5][1] = "A) Panna Cotta";
        question[5][2] = "B) Tiramisu";
        question[5][3] = "C) Cannoli";
        correctAnswer[5] = "B";

        question[6][0] = "What is the more common name for sodium bicarbonate which is often used in baking as a leavening agent?";
        question[6][1] = "A) Baking soda";
        question[6][2] = "B) Baking powder";
        question[6][3] = "C) Cornstarch";
        correctAnswer[6] = "A";

        question[7][0] = "What common dessert and pie topping is created by beating together egg whites and sugar?";
        question[7][1] = "A) Whipped cream";
        question[7][2] = "B) Glazed icing";
        question[7][3] = "C) Meringue";
        correctAnswer[7] = "C";

        question[8][0] = "What is the process in pie baking called when the crust is baked on its own without the filling?";
        question[8][1] = "A) Preparation baking";
        question[8][2] = "B) Blind baking";
        question[8][3] = "C) Sight baking";
        correctAnswer[8] = "B";

        question[9][0] = "What is the special feature of a convection oven that helps cookies and cakes bake more evenly?";
        question[9][1] = "A) Fan that circulates the air";
        question[9][2] = "B) More consistent pre-heating";
        question[9][3] = "C) The creation of steam";
        correctAnswer[9] = "A";

        // loop through the question array asking each one
        do {
            response = askQuestion(question[i]);
            if (response.equals("ABORT"))
                return;
            if (isCorrect(correctAnswer[i], response))
                correct += 1;
            else
                incorrect += 1;

            i++;
        } while (i < question.length);

        showGrade(correct, incorrect);
    }
}