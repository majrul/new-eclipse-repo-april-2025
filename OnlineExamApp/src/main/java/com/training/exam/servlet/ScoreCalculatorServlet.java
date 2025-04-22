package com.training.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.exam.model.Option;
import com.training.exam.model.Question;

/**
 * Servlet implementation class ScoreCalculatorServlet
 */
@WebServlet("/ScoreCalculatorServlet")
public class ScoreCalculatorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Question> list = (List<Question>) session.getAttribute("listOfQuestions");
		
		int score = 0;
		
		for(int i=0; i<list.size(); i++) {
			int op = Integer.parseInt(request.getParameter("ansOfQs"+i));
			Question q = list.get(i);
			Option selectedOp = q.getOptions().get(op);
			if(selectedOp.isRightAnswer())
				score ++;
		}
		
		PrintWriter out = response.getWriter();
		out.write("<h1>Congratulations, you have scored  " + score + " marks</h1>");
	}

}
