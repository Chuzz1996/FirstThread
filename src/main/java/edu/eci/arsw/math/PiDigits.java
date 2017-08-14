package edu.eci.arsw.math;

///  <summary>
///  An implementation of the Bailey-Borwein-Plouffe formula for calculating hexadecimal
///  digits of pi.
///  https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
///  *** Translated from C# code: https://github.com/mmoroney/DigitsOfPi ***
///  </summary>
public class PiDigits {

    /**
     * Returns a range of hexadecimal digits of pi.
     * @param start The starting location of the range.
     * @param count The number of digits to return
     * @return An array containing the hexadecimal digits.
     */
    public static byte[] getDigits(int start, int count, int N) {
        if(start < 0 || count < 0 || N < 0){
            throw new RuntimeException("Invalid Interval");
        }
        byte[] digits = new byte[count];
        int size = count/N;
        ThreadLive[] hilos = new ThreadLive[N];
        for (int i = 0; i < N; i++) {
            if(i!=N-1)
                hilos[i]=new ThreadLive(start, size);
            else
                hilos[i]=new ThreadLive(start, size+(count%N));
            hilos[i].start();
            start+=size;
        }
        for (int i = 0; i < N; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {}
        }
        int indice = 0;
        
        for (int i = 0; i < hilos.length; i++) {
            for (int j = 0; j < hilos[i].getSize(); j++) {             
                digits[indice]=hilos[i].getDigit(j);
                indice++;
            }
        }
        
        return digits;
    }

}
