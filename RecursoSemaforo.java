package semafororecursos;
import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;
public class RecursoSemaforo {
	public final int sizeRecursos=1000;
    private Queue<Integer> memoria = new LinkedList<Integer>();
    private Semaphore espaciorecurso= new Semaphore (sizeRecursos,true);
    private Semaphore recurso = new Semaphore (0,true);
  
	
	 
	public Semaphore getEspacioRecurso()
	{
		
		return espaciorecurso;
	}

	public Semaphore getRecurso()
	{
		return recurso;
	}
	
	public Queue<Integer> getMemoria()
	{
		return memoria;
	}
}
