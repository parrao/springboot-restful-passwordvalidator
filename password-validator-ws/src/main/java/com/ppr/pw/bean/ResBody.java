package com.ppr.pw.bean;

/**
 * Response Body data for client
 *  @author Parthi
 */
public class ResBody {
	private  String message;
	private  String responseCode;
	
	  /**
	   * Creates a new Response Body.
	   *
	   * @param  message  response message 
	   * @param responseCode 
	   */
	public ResBody(String message,String responseCode){
		this.message=message;
		this.responseCode=responseCode;
	}
	
	  /**
	   * sets message.
	   *
	   * @param  message  response message 
	   */
	public void setMessage(String message){
		this.message=message;
	}
	
	
	 /**
	  * returns message.
	 */
	public String getMessage(){
		return message;
	}
	
	  /**
	   * sets Response code.
	   *
	   * @param  responseCode
	   */
	public void setResponseCode(String responseCode){
		this.responseCode=responseCode;
	}
	
	
	/**
	  * returns responseCode.
	 */
	public String getResponseCode(){
		return responseCode;
	}
	

}
