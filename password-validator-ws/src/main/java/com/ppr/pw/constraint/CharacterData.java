package com.ppr.pw.constraint;



/**
 * Enum of lowercase and numerical character data set
 * @author Parthi
 */
public enum CharacterData {
	
	
	  LowerCase("INSUFFICIENT_LOWERCASE", "abcdefghijklmnopqrstuvwxyz"),
	  Digit("INSUFFICIENT_DIGIT", "0123456789");

	  
	  private final String errorCode;
	  private final String characters;


	  /**
	   * Creates a new character data.
	   *
	   * @param  code  Error code.
	   * @param  charString  Characters as string.
	   */
	  CharacterData(final String code, final String charString)
	  {
	    errorCode = code;
	    characters = charString;
	  }


	  /**
	   * Returns the error code.
	   *
	   * @return  errorCode
	   */
	  public String getErrorCode()
	  {
	    return errorCode;
	  }

	  /**
	   * Returns the characters data.
	   *
	   * @return  characters
	   */
	  public String getCharacters()
	  {
	    return characters;
	  }


}
