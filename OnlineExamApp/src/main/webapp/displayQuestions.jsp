<%@page import="com.training.exam.model.Option"%>
<%@page import="com.training.exam.model.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.training.exam.model.QuestionBankLoader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
<form method="post" action="ScoreCalculatorServlet">
<%
	QuestionBankLoader qbLoader = new QuestionBankLoader();
	List<Question> list = qbLoader.loadQuestionsOnJava();
	session.setAttribute("listOfQuestions", list);
	
	for(int i=0; i<list.size(); i++) {
		Question q = list.get(i);
		List<Option> ops = q.getOptions();
%>
	
	<div class="q">
		Question No. <%= (i+1) %> : <%= q.getQuestion() %>

	<%
		for(int j=0; j<ops.size(); j++) {
			Option op = ops.get(j);
	%>
		<div class="o">
			<input type="radio" name="ansOfQs<%= i %>" value="<%= j %>" /> <%= op.getOption() %>
		</div>
	
<%
		}
%>
	</div>
<%
	}
%>
	<button>Submit Exam</button>
</form>
</body>
</html>