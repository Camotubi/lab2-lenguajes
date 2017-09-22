package dreamteam.parteIII;

public enum Type {
	TOKEN_NUMBER("^\\d+$"),
	TOKEN_KEY("(INICIO|FIN|ESCRIBIR|LEER|MIENTRAS|FIN|PARA|FIN|SI|SINO|CASE|BREAK|DEFAULT|"
	+ "ENTERO|CADENA|FLOAT|*|/|+|-|=)$"),
	TOKEN_ID("^&[A-Za-z]+$");
	
	public final String pattern;
	
	Type(String s)
	{
		this.pattern = s;
	}

}
