import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class main {

	public static void main(String[] args) {
		String patron = ("(do|if|while|else|array|for|foreach|bool|int|double|char|string)|([a-zA-Z])|([+|-|*|/|<|>|=])|([0-9])|([(|)])|([{|}])|(;)");
		String text = "x=1;"
				+ "do{"
				+ "if (w==1)"
				+ "{"
				+ "while(x<5)"
				+ "{"
				+ "z++;"
				+ "}"
				+ "}"
				+ "else{"
				+ "array[i] = 7"
				+ "}"
				+ "}while(j==0);";
		
		Pattern p = Pattern.compile(patron);
		Matcher matcher = p.matcher(text);
		
		System.out.println("Guia de Compiladores");
		while(matcher.find()){
			String tokenTipo1 = matcher.group(1);
			if(tokenTipo1 != null){
				System.out.println("Palabra reservada: "+tokenTipo1);
			}
			
			String tokenTipo2 = matcher.group(2);
			if(tokenTipo2 != null){
				System.out.println("Variables: "+tokenTipo2);
			}
			
			String tokenTipo3 = matcher.group(3);
			if(tokenTipo3 != null){
				System.out.println("Operador: "+tokenTipo3);
			}
			
			String tokenTipo4 = matcher.group(4);
			if(tokenTipo4 != null){
				System.out.println("Numeros: "+tokenTipo4);
			}
			
			String tokenTipo5 = matcher.group(5);
			if(tokenTipo5 != null){
				System.out.println("Parentesis "+tokenTipo5);
			}
			
			String tokenTipo6 = matcher.group(6);
			if(tokenTipo6 != null){
				System.out.println("Llaves "+tokenTipo6);
			}
			
			String tokenTipo7 = matcher.group(7);
			if(tokenTipo7 != null){
				System.out.println("Punto y coma "+tokenTipo7);
			}
		}

	}

}
