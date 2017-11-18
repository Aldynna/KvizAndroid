package com.sample.multiplechoicequiz;

// This file contains questions from PitanjaActivity

public class PitanjaActivity {

    // array of questions
    private String textQuestions [][] = {
            {
                    "1. Glavni grad Engleske?",
                    "2. Omiljeni zanr filmova?",
                    "3. Vas bracni status?",
                    "4. Vas Spol i godine?",
                    "5. U kojem ste mjesecu rodjeni?",
                    "6. Na koje slovo pocinje Vase ime?"
                   // "5. Što se dobiva križanjem ježa i zmije?",
                   // "6. Kako se zove London s ugašenim svjetlima? ",
                  //  "7. Kako se zove glavni rom?",
                  //  "8. Koji su vjesnici proljeća u Hrvatskoj?",
                   // "9.Koja je razlika između komarca i žene?",
                  //  "10.Kako se zove muž od zmije?",
                  //  "7. Pristajes li da te peglam do kraja zivota :D?"
            },
            {
                    "1. What is the capital of England?",
                    "2. What is the Atomic sign for water?",
                    "3. How many continents are there?",
                    "4. What wonder of the world is in Italy?",
                    "5. Pasta came from?"
            },

    };

    // array of multiple choices for each question
    private String multipleChoice [][][] = {
            {
                    {"Kent", "New York", "United Kingdom", "London"},
                    {"Komedija","Horor","Dokumentarac","Western"},
                   {"Ozenjen/Udata", "U vezi", "Samac", "Udovac/Udovica"},
                    {"Musko do 30godina", "Zensko do 30godina", "Musko preko 30godina", "Zensko preko 30godina"},
                    {"Mart","Decembar","Juli","Januar"},
                    {"M","A","S","K"}
                  //  {"Puz","Jednorog","Zaba","Tri metra bodljikave žice."},
                  //  {"Sarajevo","Londoff","Pariz","Rajlovac"},
                  //  {"Alfa Romeo!","Cigos","Neki","Nesto"},
                  //  {"Raskopane ceste","slavuj","jagorcevina","gljiva"},
                 //   {"Komarac vam pije krv samo ljeti","Dosade oboje","Oboje samo zuje","Ne mozes zaspati od njih"},
                  //  {"Punac","zirafa","pokemon","lav"},
                   // {"DA", "NARAVNO", "UVIJEK", "ZAUVIJEK"}

            },
            {
                    {"Kent", "New York", "United Kingdom", "London"},
                    {"Ho2", "Heo2", "H2O", "Oh2"},
                    {"8", "4", "5", "7"},
                    {"Big Ben", "Taj Mahal", "The Roman Colosseum", "Eiffel Tower"},
                    {"Italy", "France", "Germany", "USA"}
            }

    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[][] = {
            {"London", "Komedija", "U vezi", "Musko do 30godina","Decembar","M"},
            {"London", "H2O", "7", "The Roman Colosseum", "Italy"}
    };

    // method returns number of questions
    public int getLength(int i){
        return textQuestions[i].length;
    }

    // method returns question from array textQuestions[] based on array index
    public String getQuestion(int a,int b) {
        String question = textQuestions[a][b];
        return question;
    }

    // method return a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int jezik,int index, int num) {
        String choice0 = multipleChoice[jezik][index][num-1];
        return choice0;
    }

    //  method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a,int b) {
        String answer = mCorrectAnswers[a][b];
        return answer;
    }
}