package com.keregann;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


   @WebServlet("/questionaireservlet")
    public class QuestionaireServlet extends HttpServlet {

        public QuestionaireServlet() {
            super();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            Questionaire questionaire = QuestionaireService.findBySubject("Ion");
            String htmlCode = getHtmlCode(questionaire);

            printWriter.println(htmlCode);
        }

        private String getHtmlCode(Questionaire questionaire) {
            return "<!DOCTYPE html>\n" +
                    "<html>\n<head>\n" +
                    "<title>Questionaire Servlet</title>\n" +
                    "</head>\n<body>\n\n" +
                    "<h1>QuestionaireServlet HTML heading</h1>\n" +
                    "<p>QuestionaireServlet HTML paragraph.</p>\n" +
                    "<p>" + questionaire + "</p>\n" +
                    "</body>\n\n</html>";
        }

        public static void main(String[] args) {

            Questionaire q1 = QuestionaireService.createNewQuestionareRecord( "Misha", "null", QuestionaireDao.getEysenckQuiestionaireItems_A());

            System.out.println("From java : " + q1);

            //raspund la intrebari
         //   QuestionaireService.inputQuestionaireAnswers(q1);


            //printeaza toata informatia despre qestionar
         //   QuestionaireService.printQuestionaireInfo(q1);

            //se realizeaza calculul rezultatului si il atribuie variabilei rezult din obiectul qestionar
          //  QuestionaireService.setQuestionaireResult(q1);

          //  System.out.println("Rezolvare : " + q1);

            //obiectul qestionar pleaca pe DB (raspunsurile nu pleaca inca)
            QuestionaireService.insertQuestionaireRecord(q1);

            //obiectul questionar vine de pe DB
            System.out.println("From DB : " + QuestionaireService.findBySubject(q1.getSubject()));


        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // read form fields
            //poate trebu setcontent
            String subject = req.getParameter("subjectName");
            Questionaire questionaire = QuestionaireService.findBySubject(subject);
            // do some processing here...

            // get response writer
            PrintWriter writer = resp.getWriter();

            // build HTML code
            String htmlRespons = "<html>";
            htmlRespons += "<h2>" + questionaire + "<br/>";
            htmlRespons += "</html>";

            // return response
            writer.println(htmlRespons);
        }
    }

