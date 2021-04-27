//factorial !
	long[] factorial = new long[21];
	factorial[0] = 1;
	factorial[1] = 1;
	factorial[2] = 2;
	factorial[3] = 6;
	factorial[4] = 24;
	factorial[5] = 120;
	factorial[6] = 720;
	factorial[7] = 5040;
	factorial[8] = 40320;
	factorial[9] = 362880;
	factorial[10] = 3628800;
	factorial[11] = 39916800;
	factorial[12] = 479001600;
	factorial[13] = 6227020800L;
	factorial[14] = 87178291200L;
	factorial[15] = 1307674368000L;
	factorial[16] = 20922789888000L;
	factorial[17] = 355687428096000L;
	factorial[18] = 6402373705728000L;
	factorial[19] = 121645100408832000L;
	factorial[20] = 2432902008176640000L;
		
//fibonacci
	static long Fibo(int n){
        long ant = 1;
        long seg = 1;
        long temp;

        for (int i=2; i < n; i++) {
            temp = seg;
            seg = ant + seg;
            ant = temp;
        }

        return seg;
    }

//MCD MCM
	static long MCD(long a, long b) {
        long temp;
        while (a % b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return b;
    }

    static long MCM(long a, long b) {
        return (a*b)/MCD(a,b);
    }
	
//Cerca Binaria
	public int CercaBinaria(int[] array, int valor, int baix, int alt) {
        int index = -1;
        while (baix <= alt) {
            int mig = (baix + alt) / 2;
            if (array[mig] < valor) {
                baix = mig + 1;
                //if (baix == alt) index = alt;
            } else if (array[mig] > valor) {
                alt = mig - 1;
                //if (baix == alt) index = alt;
            } else if (array[mig] == valor) {
                index = mig;
                break;
            }
        }
        return index;
    }
	
//llegir caracter a caracter
Scanner sc = new Scanner(System.in);
sc.useDelimiter("");
sc.next()charAt(0)) != '\n')

//llegir i check
while ((c=sc.read)!='\n'){}
	
