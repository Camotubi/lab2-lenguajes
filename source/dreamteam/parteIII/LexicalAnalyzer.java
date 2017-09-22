package dreamteam.parteIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class LexicalAnalyzer {
	
	
	public static ArrayList<Token> analyze(String input) throws Exception
	{
		StringTokenizer tokenizer = new StringTokenizer(input);
		ArrayList<Token> knownTokens = commonTokens();
		ArrayList<Token> tokens = new ArrayList<Token>();
		while(tokenizer.hasMoreTokens())
		{
			boolean found = false;
			String value=tokenizer.nextToken();
			for(Token knownToken : knownTokens)
			{
				Pattern pattern = Pattern.compile(knownToken.name);
				if(pattern.matcher(value).matches())
				{
					tokens.add(new Token(knownToken.id,value,knownToken.type));
					found = true;
					break;
					
				}
				
			}
			if(!found)
			{
				throw new Exception("lexema no encontrado: "+ value);
			}
		}
		return tokens;
		
	}
	public  static ArrayList<Token> commonTokens()
	{
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token(1,"INICIO","TOKEN_KEY"));
		tokens.add(new Token(2,"FIN","TOKEN_KEY"));
		tokens.add(new Token(3,"ENTERO","TOKEN_KEY"));
		tokens.add(new Token(4,"DECIMAL","TOKEN_KEY"));
		tokens.add(new Token(5,"CADENA","TOKEN_KEY"));
		tokens.add(new Token(13,"MIENTRAS","TOKEN_KEY"));
		tokens.add(new Token(16,"ESCRIBIR","TOKEN_KEY"));
		tokens.add(new Token(14,"HACER","TOKEN_KEY"));
		
		tokens.add(new Token(23,"[;]","TOKEN_KEY"));
		tokens.add(new Token(26,"[=]","TOKEN_KEY"));
		tokens.add(new Token(30,"[/]","TOKEN_KEY"));
		tokens.add(new Token(31,"[+]","TOKEN_KEY"));
		tokens.add(new Token(32,"[-]","TOKEN_KEY"));
		tokens.add(new Token(33,"[*]","TOKEN_KEY"));
		tokens.add(new Token(34,"[(]","TOKEN_KEY"));
		tokens.add(new Token(35,"[)]","TOKEN_KEY"));
		tokens.add(new Token(38,"[<=]","TOKEN_KEY"));
		tokens.add(new Token(100,"^[A-Za-z]+$","TOKEN_ID"));
		tokens.add(new Token(101,"^\\d+$","TOKEN_NUM"));
		return tokens;
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		while(true)
		{
			String inputLine =read.readLine();
			if(inputLine.equals("&"))break;
			else input= input +"\n"+ inputLine; 
			
		}
		ArrayList<Token> detectedTokens =LexicalAnalyzer.analyze(input);
		for(Token token: detectedTokens)
		{
			System.out.println(token.type+" "+token.id+ " "+ token.name);
		}
	}

}
