package com.ppr.pw.constraint;


/**
 * ValidationRule for determining if a password contains at least one of lowercase letters and numerical digits
 * @author Parthi
 */
public class CharacterRule implements ValidationRule {
	
	 
	  protected final CharacterData characterData;
	  protected int numCharacters = 1;


	  /**
	   * Creates a new character rule.
	   *
	   * @param  data  character data for this rule
	   */
	 /* public CharacterRule(final CharacterData data)
	  {
	    this(data, 1);
	  } */


	  /**
	   * Creates a new character rule.
	   *
	   * @param  data  character data for this rule
	   * @param  num  of characters to check
	   */
	  public CharacterRule(final CharacterData data, final int num)
	  {
	    setNumberOfCharacters(num);
	    characterData = data;
	  }


	  /**
	   * Sets the number of characters to present in a password.
	   *
	   * @param  n  number of characters to require
	   */
	  public void setNumberOfCharacters(final int n)
	  {
	    if (n > 0) {
	      numCharacters = n;
	    } else {
	      throw new IllegalArgumentException("argument must be greater than zero");
	    }
	  }


	  /**
	   * Returns the number of characters which must exist in password.
	   *
	   * @return  number of characters to require
	   */
	  public int getNumberOfCharacters()
	  {
	    return numCharacters;
	  }


	  /**
	   * Returns the character data for this rule.
	   *
	   * @return  character data
	   */
	  public CharacterData getCharacterData()
	  {
	    return characterData;
	  }

	  
	  /**
	   * Returns the characters that are considered valid for this rule.
	   *
	   * @return  valid characters
	   */
	  public String getValidCharacters()
	  {
	    return characterData.getCharacters();
	  }
	  
	 /**
	 * Validates the input password for required Characters are present.
	 *
	 * @param  passwordData  to validate
	 *
	 * @return  rule result
	 */   
	@Override
	public RuleResult validate(String passwordData) {
		 final String matchingChars = getMatchingCharacters(
			      String.valueOf(characterData.getCharacters()),
			      passwordData,
			      numCharacters);
			    if (matchingChars.length() < numCharacters) {
			      return new RuleResult(false,"letter should contail atleast one lowercare and numerical digit");
			    }
			    return new RuleResult(true, "valid");
	}
	
	  /**
	   * Returns all the characters in the input string that are also in the characters string.
	   *
	   * @param  characters  that contains characters to match
	   * @param  input 	to search for matches
	   * @param  maximumLength 	maximum length of matching characters
	   *
	   * @return  matching characters
	   */
	public static String getMatchingCharacters(final String characters, final String input, final int matchLength)
	  {
	    final StringBuilder sb = new StringBuilder(input.length());
	    for (int i = 0; i < input.length(); i++) {
	      final char c = input.charAt(i);
	      if (characters.indexOf(c) != -1) {
	        if (sb.length() < matchLength) {
	          sb.append(c);
	        } else {
	          break;
	        }
	      }
	    }
	    return sb.toString();
	  }


}
