package semafororecursos;

import java.util.Random;

public class ReservarRecursos extends Thread {
   private RecursoSemaforo RecursoSemaforo;
	public ReservarRecursos(RecursoSemaforo RecursoSemaforo)
	{
		this.RecursoSemaforo=RecursoSemaforo;
		start(); 
		
	} 
	public int Reservar()
	{
		Random rdm=new Random();
		int numrecurso=rdm.nextInt(100-1)+1;		
		int tiemporecurso=rdm.nextInt(500-60+1)+60; 
		
		try {
			sleep (tiemporecurso);
		}catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return numrecurso;
		
	}
	public void run()
	{
		while(true)
		{
			int numrecurso=Reservar();
			if (RecursoSemaforo.getMemoria().size()==RecursoSemaforo.sizeRecursos)
			{
				System.out.println("Estan todos lo recursos selccionados");
			}		
			 
			try
			{
				RecursoSemaforo.getEspacioRecurso().acquire(numrecurso);
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			
			RecursoSemaforo.getMemoria().add(numrecurso);				
			RecursoSemaforo.getRecurso().release(numrecurso);
			System.out.println("Se han reservado "+numrecurso+"recursos");
			
		}
	}
}
