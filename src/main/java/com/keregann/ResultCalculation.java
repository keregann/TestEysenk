package com.keregann;

public class ResultCalculation {
    private int extraversion = 0;
    private int nevrotism = 0;
    private int sincerity = 0;
    private int extroversionLevel = 0;
    private int nevroticismLevel = 0;

    private Integer[] extArray = {1, 3, 5, 8, 10, 13, 15, 17, 20, 22, 25, 27, 29, 32, 34, 37, 39, 42, 44, 46, 49, 51, 53, 56};
    private Integer[] nevArray = {2, 4, 9, 11, 14, 16, 19, 21, 23, 26, 28, 31, 33, 35, 38, 40, 43, 45, 47, 50, 52, 55, 57};
    private Integer[] sincerityArray = {6, 12, 18, 24, 30, 36, 42, 48, 54 };

    public static String finalRezult(Questionaire questionaire){
        ResultCalculation resultCalculation = new ResultCalculation();
        if(resultCalculation.isHonest(questionaire)){
            return  resultCalculation.result(questionaire);
        }
        return "Ati fost nesincer in raspunsuri si rezultatul testului v-a fi eronat. " +
                "Din acest motiv rugam sa reporniti testul si fiti cit mai sinceri posibil";
    }//end method

    public  String result(Questionaire questionaire){
        for (int i = 0; i < extArray.length; i++) {
            Item item = questionaire.getItems().get(extArray[i]);
            if (item.getAnsweredValue() == (item.getConsideredValue())) {
                extraversion++;
            }
        }

        for (int i = 0; i < nevArray.length; i++) {
            Item item = questionaire.getItems().get(nevArray[i]);
            if (item.getAnsweredValue() == (item.getConsideredValue())) {
                nevrotism++;
            }
        }

        if (extraversion >= 1 && extraversion <=7 ){
            extroversionLevel = 1;
        } else if(extraversion >= 8 && extraversion <=11){
            extroversionLevel = 2;
        } else if(extraversion >= 12 && extraversion <= 18){
            extroversionLevel = 3;
        } else if(extraversion >= 19 && extraversion <= 24){
            extroversionLevel = 4;
        }

        if (nevrotism >= 1 && nevrotism <= 10){
            nevroticismLevel = 1;
        } else if (nevrotism >= 11 && nevrotism <= 14){
            nevroticismLevel =  2;
        } else if (nevrotism >= 15 && nevrotism <= 18){
            nevroticismLevel = 3;
        } else if (nevrotism >= 19 && nevrotism <= 24){
            nevroticismLevel = 4;
        }
        // TODO change sout expresions with ENUMS or Strings from TemperamentTypes Class
        if(extroversionLevel == 1 && nevroticismLevel == 1){
            return "introversiune considerabila - stabilitate emotionala ridicata";
        } else if (extroversionLevel == 1 && nevroticismLevel == 2){
            return "introversiune considerabila - stabilitate emotionala medie";
        } else if (extroversionLevel == 1 && nevroticismLevel == 3){
            return "introversiune considerabila - instabilitate emotionala ridicata";
        } else if (extroversionLevel == 1 && nevroticismLevel == 4){
            return "introversiune considerabila - instabilitate emotionala foarte ridicata";
        } else if (extroversionLevel == 2 && nevroticismLevel == 1){
            return "introversiune moderata - stabilitate emotionala ridicata ";
        } else if (extroversionLevel == 2 && nevroticismLevel == 2){
            return "introversiune moderata - stabilitate emotionala medie";
        } else if (extroversionLevel == 2 && nevroticismLevel == 3){
            return "introversiune moderata - instabilitate emotionala ridicata";
        } else if (extroversionLevel == 2 && nevroticismLevel == 4){
            return "introvesiune moderata - instabilitate emotionala foarte ridicata";
        } else if (extroversionLevel == 3 && nevroticismLevel == 1){
            return "extraversiune moderata - stabilitate emotionala ridicata";
        } else if (extroversionLevel == 3 && nevroticismLevel == 2){
            return "extraversiune moderata - stabilitate emotionala medie";
        } else if (extroversionLevel == 3 && nevroticismLevel == 3){
            return "extraversiune moderata - instabilitate emotionala ridicata";
        } else if (extroversionLevel == 3 && nevroticismLevel == 4){
            return "extraversiune moderata - instabilitate emotionala foarte ridicata";
        } else if (extroversionLevel == 4 && nevroticismLevel == 1){
            return "extraversiune considerabila - stabilitate emotionala ridicata";
        } else if (extroversionLevel == 4 && nevroticismLevel == 2){
            return "extraversiune considerabila - stabilitate emotionala medie";
        } else if (extroversionLevel == 4 && nevroticismLevel == 3){
            return "extraversiune cconsiderabila - instabilitate emotionala ridicata";
        } else if (extroversionLevel == 4 && nevroticismLevel == 4){
            return "extraversiune considerabila - instabilitate emotionala foarte ridicata";
        }
        return "rezultat null";
    }


    public  boolean isHonest(Questionaire questionaire){
        for (int i = 0; i < sincerityArray.length; i++) {
            Item item = questionaire.getItems().get(extArray[i]);
            if (item.getAnsweredValue() == (item.getConsideredValue())){
                sincerity++;
            }
        }

        if(sincerity >= 0 && sincerity <=3){
            return true;
        } else if (sincerity >= 4 && sincerity <= 6){
            return true;
        } else if (sincerity >= 7 && sincerity <= 9) {
            System.out.println("Sunteti nesincer in raspunsuri si rezultatul testului v-a fi eronat. Din acest motiv rugam sa reporniti testul si fiti cit mai sinceri posibil");
            return false;
            // TODO here: Create function witch will ask the user if he want to repeat the test, if yes - program return to begin, if no - say thank you and close the program
        }
         return false;
    }


}
