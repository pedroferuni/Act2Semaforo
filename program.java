package semafororecursos;

public class program {
	static RecursoSemaforo RecursoSemaforo=new RecursoSemaforo();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("hola");
     new ReservarRecursos(RecursoSemaforo);
     new LiberarRecurso(RecursoSemaforo);
	}

}
