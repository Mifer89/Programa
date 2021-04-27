package final2016;

import java.util.Scanner;

public class C_SieteDeUnGolpe {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int ampleTaula = s.nextInt();
		int altTaula = s.nextInt();
		int ampleMataMosques = s.nextInt();
		int altMataMosques = s.nextInt();
		s.nextLine();
		int mosques;		
		StringBuilder liniaResultats = new StringBuilder();
		
		while(ampleTaula != 0 && altTaula != 0 && ampleMataMosques != 0 && altMataMosques != 0)
		{
			char[][] taula = new char[altTaula][];
			
			for(int linia = 0;linia < taula.length;linia++)
			{
				taula[linia] = s.nextLine().toCharArray();
			}
			
			//CREAR ARRAYS			
			int[] resultats = new int[8];
			int[] valorsColumna = new int[ampleMataMosques];
			int[] filaCentre = new int[ampleTaula];
			
			//INICIALITZAR RESULTATS
			for(int resultat = 0;resultat < resultats.length;resultat++)
				resultats[resultat] = 0;
			mosques = 0;
			
			//MATAMOSQUES DE 1 x 1
			if(ampleMataMosques == 1 && altMataMosques == 1) 
			{
				for(int posicioY = 0;posicioY < taula.length;posicioY++) 
				{
					for(int posicioX = 0;posicioX < taula[0].length;posicioX++) 
					{
						if(taula[posicioY][posicioX] == 'X') 													
							resultats[1]++;							
						
						else
							resultats[0]++;	
					}
				}
			}
			//RESTA DE MIDES
			else 
			{				
				//PRIMERES FILES
				//BLOC INICIAL
				for(int posicioY = 0;posicioY < altMataMosques;posicioY++) 
				{
					for(int posicioX = 0;posicioX < ampleMataMosques;posicioX++) 
					{
						if(taula[posicioY][posicioX] == 'X') 
						{
							valorsColumna[posicioX % ampleMataMosques]++;
							mosques++;
							filaCentre[posicioX]++;													
						}
					}
				}
				ActualitzarComptador(resultats, mosques);
				
				//RESTA COLUMNES
				if(ampleTaula > ampleMataMosques) 
				{
					for(int posicioX = ampleMataMosques;posicioX < taula[0].length;posicioX++) 
					{
						mosques -= valorsColumna[posicioX % ampleMataMosques];
						valorsColumna[posicioX % ampleMataMosques] = 0;
						
						for(int posicioY = 0;posicioY < altMataMosques;posicioY++) 
						{							
							if(taula[posicioY][posicioX] == 'X') 
							{
								valorsColumna[posicioX % ampleMataMosques]++;
								mosques++;	
								filaCentre[posicioX]++;								
							}
						}
						ActualitzarComptador(resultats, mosques);
					}
				}
				
				//RESTA FILES
				if(altTaula > altMataMosques) 
				{					
					for(int filaTaula = altMataMosques;filaTaula < taula.length;filaTaula++)
					{
						mosques = 0;
						
						//BLOC INICIAL
						for(int posicioX = 0;posicioX < ampleMataMosques;posicioX++) 
						{
							if(taula[filaTaula - altMataMosques][posicioX] == 'X') 
							{
								filaCentre[posicioX]--;								
							}							
							
							valorsColumna[posicioX % ampleMataMosques] = filaCentre[posicioX];
							mosques += filaCentre[posicioX];
							
							if(taula[filaTaula][posicioX] == 'X') 
							{
								valorsColumna[posicioX % ampleMataMosques]++;
								mosques++;	
								filaCentre[posicioX]++;								
							}
						}
						ActualitzarComptador(resultats, mosques);
						
						//RESTA COLUMNES
						if(ampleTaula > ampleMataMosques) 
						{
							for(int posicioX = ampleMataMosques;posicioX < taula[0].length;posicioX++) 
							{
								mosques -= valorsColumna[posicioX % ampleMataMosques];
								valorsColumna[posicioX % ampleMataMosques] = 0;
								
								if(taula[filaTaula - altMataMosques][posicioX] == 'X') 
								{
									filaCentre[posicioX]--;								
								}							
								
								valorsColumna[posicioX % ampleMataMosques] = filaCentre[posicioX];
								mosques += filaCentre[posicioX];
								
								if(taula[filaTaula][posicioX] == 'X') 
								{
									valorsColumna[posicioX % ampleMataMosques]++;
									mosques++;	
									filaCentre[posicioX]++;								
								}
								ActualitzarComptador(resultats, mosques);
							}
						}
					}				
				}
			}	
			
			liniaResultats.setLength(0);
			liniaResultats.append(resultats[0]);
			liniaResultats.append(" ");
			liniaResultats.append(resultats[1]);
			liniaResultats.append(" ");
			liniaResultats.append(resultats[2]);
			liniaResultats.append(" ");
			liniaResultats.append(resultats[3]);
			liniaResultats.append(" ");
			liniaResultats.append(resultats[4]);
			liniaResultats.append(" ");
			liniaResultats.append(resultats[5]);
			liniaResultats.append(" ");
			liniaResultats.append(resultats[6]);
			liniaResultats.append(" ");
			liniaResultats.append(resultats[7]);			
			System.out.println(liniaResultats.toString());
			
			ampleTaula = s.nextInt();
			altTaula = s.nextInt();
			ampleMataMosques = s.nextInt();
			altMataMosques = s.nextInt();
			s.nextLine();
		}
		s.close();
	}
	public static void ActualitzarComptador(int[] resultats, int mosques) 
	{
		switch (mosques) {
		case 0:
			resultats[0]++;
			break;
		case 1:
			resultats[1]++;
			break;
		case 2:
			resultats[2]++;
			break;
		case 3:
			resultats[3]++;
			break;
		case 4:
			resultats[4]++;
			break;
		case 5:
			resultats[5]++;
			break;
		case 6:
			resultats[6]++;
			break;
		case 7:
			resultats[7]++;
			break;		
		}
	}
}
