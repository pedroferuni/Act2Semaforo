package semafororecursos;

import java.util.Random;

public class LiberarRecurso extends Thread {

   private RecursoSemaforo RecursoSemaforo;
		public LiberarRecurso(RecursoSemaforo RecursoSemaforo)
		{
			this.RecursoSemaforo=RecursoSemaforo;
			start(); 
			
		} 
		public void Liberar()
		{
			Random rdm=new Random();					
			int tiemporecurso=rdm.nextInt(800-60+1)+60;
			
			try {
				sleep (tiemporecurso);
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			
		}
		public void run()
		{
			while(true)
			{
				Liberar();
				if (RecursoSemaforo.getMemoria().size()==0)
				{
					System.out.println("Estan liberados todos los recursos");
				}		
				int codrecurso=RecursoSemaforo.getMemoria().element();
				try
				{
					
					RecursoSemaforo.getRecurso().acquire(codrecurso);
					
				}catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				
				RecursoSemaforo.getMemoria().poll();
				
				RecursoSemaforo.getEspacioRecurso().release(codrecurso);
				System.out.println("Se han Liberado "+codrecurso + "recursos");
				
			}
		}
	}

