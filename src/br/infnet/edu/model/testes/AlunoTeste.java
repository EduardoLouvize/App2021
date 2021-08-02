package br.infnet.edu.model.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.model.domain.Aluno;

public class AlunoTeste {

	public static void main(String[] args) {
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		String[] disciplinas = new String[2];
		disciplinas[0] = "java";
		disciplinas[1] = "python";
		
		Aluno a1 = new Aluno("Eduardo", "eduardo@louvize.com");
		a1.setCurso("G");
		a1.setDisciplinas(disciplinas);
		a1.setIdade(41);
		a1.setRegiao("Sudeste");
		a1.setMensalidade(450);
		
		listaAlunos.add(a1);
		
		System.out.println(a1);
		
		for(Aluno aluno : listaAlunos) {
			System.out.println("Aluno: " + aluno.getNome());
		}
		

	}

}
