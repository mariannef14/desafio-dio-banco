import java.util.Scanner;

public class ValidaCpf {

	protected static int[] verificaDigitos(String cpf){
		int[] digitosCpf = new int[11];
		
       //Retirando espaços . e -
       cpf = cpf.trim().replace(".", "").replace("-", "").replace(" ", "");
             
       boolean digitosIguais = false;
       
       while(!cpf.matches("[0-9]{11}") || digitosIguais) {
    	   System.out.println("CPF inválido!! Digite seu CPF novamente: ");
           Scanner teclado = new Scanner(System.in);
           cpf = teclado.nextLine().trim().replace(".", "").replace("-", "").replace(" ", "");
           
           if(cpf.matches("[0-9]{11}")) {
        	   digitosIguais = cpf.charAt(0) == cpf.charAt(1) && cpf.charAt(1) == cpf.charAt(2) && cpf.charAt(2) == cpf.charAt(3) && cpf.charAt(3) == cpf.charAt(4) && cpf.charAt(4) == cpf.charAt(5)
                   && cpf.charAt(5) == cpf.charAt(6) && cpf.charAt(6) == cpf.charAt(7) && cpf.charAt(7) == cpf.charAt(8) && cpf.charAt(8) == cpf.charAt(9) && cpf.charAt(9) == cpf.charAt(10);
           }
       }
       
       //Adicionando os dígitos no array
       for(int i = 0; i <= cpf.length() - 1; i++){
    	   int n = Integer.parseInt((Character.toString(cpf.charAt(i))));
           digitosCpf[i] = n;
       }
	       
	   return digitosCpf;
	}
	
	protected static boolean eValido(String cpf){
		
        //Verificando os dígitos
		int[] digitosCpf = new int[11];
        digitosCpf = verificaDigitos(cpf);
        
		int m = 10;
	    int s = 0;
	    int digito1;
	    int digito2;
	    boolean valido;
	    
        //Calculando o 1º dígito
        for(int i = 0; i <= 8; i++){
         s += digitosCpf[i] * m;
         m--;
        }  

        int res1 = s % 11;
        if(res1 < 2){
         digito1 = 0; 
        }else{
         digito1 = 11 - res1;
        }
        
        m = 11;
        s = 0;
        
        //Calculando o 2º dígito
        for(int i = 0; i <= 8; i++){ 
            s += digitosCpf[i] * m;
            m--;
        }
        
        s += digito1 * m;
        
        int res2 = s % 11;
        
        if(res2 < 2){
            digito2 = 0;
        }else{
            digito2 = 11 - res2;
        }
        
        valido = digitosCpf[9] == digito1 && digitosCpf[10] == digito2 ? true : false;
 
        return valido;
    }
}
