package com.keregann;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



    /**
     * Created by Alex Corghencea on 18 July 2017.
     */
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
          //  System.out.println(questionaire);
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
            Questionaire questionaire = QuestionaireService.findBySubject("Ion");
            System.out.println(questionaire);
            QuestionaireService.insertNewQuestionaireRecord(7, "Misha", "null");
            QuestionaireService.insertNewQuestionaireRecord(8, "Ana", "null");
            QuestionaireService.insertNewQuestionaireRecord(9, "Aliona", "null");
            questionaire = QuestionaireService.findBySubject("Ana");
            System.out.println(questionaire);
            questionaire = QuestionaireService.findBySubject("Aliona");
            System.out.println(questionaire);
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

