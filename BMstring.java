public class BMstring{ 
	
	static int NO_OF_CHARS = 256; 
	
	//Fungsi utility untuk mendapatkan maksimum dua bilangan bulat 
	static int max (int a, int b) { return (a > b)? a: b; } 

	//Fungsi preprocessing untuk Boyer Moore's 
	//karakter buruk heuristik 
	static void badCharHeuristic( char []str, int size,int badchar[]) 
	{ 
	int i; 

	// Inisialisasi semua kejadian sebagai -1
	for (i = 0; i < NO_OF_CHARS; i++) 
		badchar[i] = -1; 

	// Isi nilai aktual dari kejadian terakhir
	// karakter
	for (i = 0; i < size; i++) 
		badchar[(int) str[i]] = i; 
	} 

	/* Fungsi pencarian pola yang menggunakan Bad
    Karakter Heuristik dari Algoritma Boyer Moore*/
	static void search( char txt[], char pat[]) 
	{ 
	int m = pat.length; 
	int n = txt.length; 

	int badchar[] = new int[NO_OF_CHARS]; 

	/* Isi array karakter yang buruk dengan menelepon
     fungsi preprocessing badCharHeuristic ()
     untuk pola yang diberikan */
	badCharHeuristic(pat, m, badchar); 

	int s = 0; // s adalah pergeseran pola dengan
				// respect teks 
	while(s <= (n - m)) 
	{ 
		int j = m-1; 

		/*Terus kurangi indeks j dari pola sementara
     karakter pola dan teks cocok di shift ini s */
		while(j >= 0 && pat[j] == txt[s+j]) 
			j--; 

		/* Jika polanya hadir pada saat ini
		bergeser, maka indeks j akan menjadi -1 setelah
		loop di atas */
		if (j < 0) 
		{ 
			System.out.println("Pola terjadi secara bergiliran = " + s); 

			/* Geser pola sehingga yang berikutnya
		karakter dalam teks sejajar dengan yang terakhir
		terjadinya itu dalam pola.
		Kondisi s + m <n diperlukan untuk
		kasus ketika pola terjadi di akhir
		teks */
			s += (s+m < n)? m-badchar[txt[s+m]] : 1; 

		} 

		else
			/* Geser polanya sehingga karakternya buruk
			dalam teks sejajar dengan kemunculan terakhir dari
			itu dalam pola. Fungsi maks digunakan untuk
			pastikan kita mendapat perubahan positif.
			Kami mungkin mendapat perubahan negatif jika yang terakhir
			Terjadinya karakter buruk dalam pola
			ada di sisi kanan arus karakter. */
			s += max(1, j - badchar[txt[s+j]]); 
	} 
	} 

	/* menjalankan program sesuai dengan fungsi di atas */
	public static void main(String []args) { 
		
		char txt[] = "ABAAABCDDCC".toCharArray(); 
		char pat[] = "ABCD".toCharArray(); 
		search(txt, pat); 
	} 
} 
