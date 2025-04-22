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
@WebServlet("/SingleQuestionScoreCalculatorServlet")
public class SingleQuestionScoreCalculatorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Question q = (Question) session.getAttribute("currentQs");
		
		Integer score = (Integer) session.getAttribute("score");
		if(score == null)
			score = 0;
		
		int op = Integer.parseInt(request.getParameter("ansOfQs"));
		Option selectedOp = q.getOptions().get(op);
		if(selectedOp.isRightAnswer())
			score ++;
		session.setAttribute("score", score);
		
		response.sendRedirect("QuestionLoaderServlet");
	}

}
