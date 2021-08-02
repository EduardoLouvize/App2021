package br.edu.infnet.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.Aluno;


public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Aluno> alunos;
 
    public AlunoController() {
        super();
        alunos = new ArrayList<Aluno>();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aluno aluno = new Aluno(
				request.getParameter("nome"),
				request.getParameter("email"));
				
		aluno.setCurso(request.getParameter("curso"));
		aluno.setIdade(Integer.valueOf(request.getParameter("idade")));
		aluno.setMensalidade(Float.valueOf(request.getParameter("mensalidade")));
		aluno.setRegiao(request.getParameter("regiao"));
		aluno.setDisciplinas(request.getParameterValues("disciplinas"));		
		aluno.impressao();
		
		alunos.add(aluno);
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Confirmação</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "	<div class=\"container\">\r\n"
				+ "<a href='aluno'>Voltar</a>\r\n"
				+ "	  <h2>Aluno: " + aluno.getNome() + " cadastrado com sucesso!</h2>\r\n"
				+ "	  <h3>E-mail: " + aluno.getEmail() + "</h3>\r\n"
				+ "	  <h3>Quantidade de alunos cadastrados: " + alunos.size() + "</h3>\r\n"
				+ "<hr>\r\n"
				+ "	</div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		for(Aluno a : alunos) {
			out.println("<h3>Aluno: " + a.getNome() + "</h3>");
		}
		
//		request.getRequestDispatcher("confirmacao.html").forward(request, response);
	}

}
