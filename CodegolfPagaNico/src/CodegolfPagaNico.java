
public class CodegolfPagaNico {
	//0<n<1000
	
	public int pagaNico(int n) {
		n = n<500 ? n : n-500;
		return n > 200 ? (n/3 > 120 ? n-120 : n-(n/3)) : n;
	}
	
	
	
}	
	
/**	
	public int pagaNico(int n) {
		//Recursivo
		//Este caso sirve si Joa paga cada vez que se suman 500... si sale 1300, ella paga 1000 y el resto se divide 
		//return n<=200 ? n : (n<500 ? (n/3 <= 120 ? n - (n/3): n-120): pagaNico(n-500));
	
	//No recursivo
	//Este caso sirve si Joa solo aporta 500, aun cuano la pizza valga un múltiplo de 500 o más
	n = n<500 ? n : n-500;
	return n > 200 ? (n/3 > 120 ? n-120 : n-(n/3)) : n;
	}

}
**/