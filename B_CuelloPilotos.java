package final2018;

import java.util.Scanner;

public class B_CuelloPilotos {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int amplada;
		int altura;
		byte coordXInici = 0;
		byte coordYInici = 0;
		byte coordX = 0;
		byte coordY = 0;
		StringBuilder sortida = new StringBuilder();
		
		boolean trobat;
		int esquerra;
		int dreta;
		byte direccio;
		
		while(s.hasNext())
		{
			amplada = s.nextInt();
			altura = s.nextInt();
			s.nextLine();
			trobat = false;
			esquerra = 0;
			dreta = 1;
			direccio = 0;
			coordX = 0;
			coordY = 0;
			
			char[][] circuit = new char[altura][amplada];
			
			//COPIAR CIRCUIT
			for(int linia = 0;linia<circuit.length;linia++) 
			{
				circuit[linia] = s.nextLine().toCharArray();
			}
			
			//BUSCAR CIRCUIT
			while(!trobat && coordY < circuit.length) 
			{
				coordX = 0;
				while(!trobat && coordX < circuit[0].length) 
				{
					if(circuit[coordY][coordX] == '#' || circuit[coordY][coordX] == 'O') 
					{
						coordXInici = coordX;
						coordYInici = coordY;
						trobat = true;
					}
					else 
					{
						coordX++;
					}					
				}
				if(!trobat) 
				{
					coordY++;
				}				
			}
			
			//FER UNA VOLTA
			trobat = false;
			
			while(!trobat) 
			{
				switch (direccio) {
				case 0:
					if(coordX < circuit[0].length - 1 && (circuit[coordY][coordX+1] == '#' || circuit[coordY][coordX+1] == 'O')) 
					{
						coordX++;
					}
					else if(coordY > 0 && (circuit[coordY-1][coordX] == '#' || circuit[coordY-1][coordX] == 'O')) 
					{
						coordY--;
						esquerra++;
						direccio = 3;
					}
					else if(coordY < circuit.length - 1 && (circuit[coordY+1][coordX] == '#' || circuit[coordY+1][coordX] == 'O')) 
					{
						coordY++;
						dreta++;
						direccio = 1;
					}
					break;
				case 1:
					if(coordY <circuit.length - 1 && (circuit[coordY+1][coordX] == '#' || circuit[coordY+1][coordX] == 'O')) 
					{
						coordY++;
					}
					else if(coordX <circuit[0].length - 1 && (circuit[coordY][coordX+1] == '#' || circuit[coordY][coordX+1] == 'O')) 
					{
						coordX++;
						esquerra++;
						direccio = 0;
					}
					else if(coordX > 0 && (circuit[coordY][coordX-1] == '#' || circuit[coordY][coordX-1] == 'O')) 
					{
						coordX--;
						dreta++;
						direccio = 2;
					}
					break;
				case 2:
					if(coordX > 0 && (circuit[coordY][coordX-1] == '#' || circuit[coordY][coordX-1] == 'O')) 
					{
						coordX--;
					}
					else if(coordY <circuit.length - 1 && (circuit[coordY+1][coordX] == '#' || circuit[coordY+1][coordX] == 'O')) 
					{
						coordY++;
						esquerra++;
						direccio = 1;
					}
					else if(coordY > 0 && (circuit[coordY-1][coordX] == '#' || circuit[coordY-1][coordX] == 'O')) 
					{
						coordY--;
						dreta++;
						direccio = 3;
					}
					break;
				default:
					if(coordY > 0 && (circuit[coordY-1][coordX] == '#' || circuit[coordY-1][coordX] == 'O')) 
					{
						coordY--;
					}
					else if(coordX > 0 && (circuit[coordY][coordX-1] == '#' || circuit[coordY][coordX-1] == 'O')) 
					{
						coordX--;
						esquerra++;
						direccio = 2;
					}
					else if(coordX <circuit[0].length - 1 && (circuit[coordY][coordX+1] == '#' || circuit[coordY][coordX+1] == 'O')) 
					{
						coordX++;
						dreta++;
						direccio = 0;
					}
					break;
				}				
				if(coordX == coordXInici && coordY == coordYInici) 
				{
					trobat = true;
				}
			}
			
			sortida.append(esquerra);
			sortida.append(" ");
			sortida.append(dreta);
			System.out.println(sortida.toString());
			sortida.setLength(0);			
		}
		s.close();
	}
}
