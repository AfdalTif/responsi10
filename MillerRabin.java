import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class MillerRabin {
    /** Berfungsi untuk memeriksa apakah prima atau tidak **/
    public boolean isPrime(long n, int iteration)
    {
        /** base case **/
        if (n == 0 || n == 1)
            return false;
        /** base case - 2 adalah prima **/
        if (n == 2)
            return true;
        /** angka genap selain 2 adalah gabungan **/
        if (n % 2 == 0)
            return false;
 
        long s = n - 1;
        while (s % 2 == 0)
            s /= 2;
 
        Random rand = new Random();
        for (int i = 0; i < iteration; i++)
        {
            long r = Math.abs(rand.nextLong());            
            long a = r % (n - 1) + 1, temp = s;
            long mod = modPow(a, temp, n);
            while (temp != n - 1 && mod != 1 && mod != n - 1)
            {
                mod = mulMod(mod, mod, n);
                temp *= 2;
            }
            if (mod != n - 1 && temp % 2 == 0)
                return false;
        }
        return true;        
    }
    /** fungsi untuk menghitung(a ^ b) % c **/
    public long modPow(long a, long b, long c)
    {
        long res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c; 
        }
        return res % c;
    }
    /** Fungsi untuk hitung (a * b) % c **/
    public long mulMod(long a, long b, long mod) 
    {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }
    /** fungsi utama **/
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Tes Algoritma Miller Rabin Primality\n");
        /** Buat objek dari kelas MillerRabin **/
        MillerRabin mr = new MillerRabin();
        /** menerima angka **/
        System.out.println("masukan angka\n");
        long num = scan.nextLong();
        /** masukan jumlah iterasi**/
        System.out.println("\nmasukan angka iterasi");
        int k = scan.nextInt();
        /** mengecek jika prima **/
        boolean prime = mr.isPrime(num, k);
        if (prime)
            System.out.println("\n"+ num +" adalah prima");
        else
            System.out.println("\n"+ num +" adalah gabungan");
 
    }
}