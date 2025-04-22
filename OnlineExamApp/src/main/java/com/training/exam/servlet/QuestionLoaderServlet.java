package com.training.exam.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.exam.model.Question;
import com.training.exam.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	int qNo = 0; //TODO: Store qno in session

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		QuestionBankLoader qbLoader = new QuestionBankLoader();
		List<Question> list = qbLoader.loadQuestionsOnJava();
		
		if(qNo < list.size()) {
			Question q = list.get(qNo++);
			session.setAttribute("currentQs", q);
			
			response.sendRedirect("displayQuestion.jsp");
		}
		else
			response.sendRedirect("displayScore.jsp");
		
	}

}
