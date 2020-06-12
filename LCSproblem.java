public class LCSproblem
{
	// Berfungsi untuk menemukan substring umum terpanjang dalam urutan
	// X[0..m-1] dan Y[0..n-1]
	public static String LCS(String X, String Y, int m, int n)
	{
		int maxlen = 0; 		// menyimpan panjang maksimum LCS
		int endingIndex = m;	// menyimpan indeks terakhir LCS di dalam variabel X

		// jalankan[i][j] menyimpan panjang LCS dari substring
		// X[0..i-1], Y[0..j-1]
		int[][] lookup = new int[m + 1][n + 1];

		// isi tabel pencarian dengan cara bottom-up
		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				// jika karakter X dan Y saat ini cocok
				if (X.charAt(i - 1) == Y.charAt(j - 1))
				{
					lookup[i][j] = lookup[i - 1][j - 1] + 1;

					// perbarui panjang maksimum dan indeks terakhir
					if (lookup[i][j] > maxlen)
					{
						maxlen = lookup[i][j];
						endingIndex = i;
					}
				}
			}
		}

		// jalankan Substing umum terpanjang yang memiliki panjang maksimal
		return X.substring(endingIndex - maxlen, endingIndex);
	}

	public static void main(String[] args)
	{
		String X = "ABCD", Y = "AFDAL GHOZALI";
		int m = X.length(), n = Y.length();

		// Temukan substring terpanjang
		System.out.print("Substring umum terpanjang adalah = "
						+ LCS(X, Y, m, n));
	}
}