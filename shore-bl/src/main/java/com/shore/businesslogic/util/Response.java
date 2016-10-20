package com.shore.businesslogic.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author harpreet.billing
 */
public class Response {
	
    public static final String OK = "ok";
    public static final String NOK = "nok";
    
	private String status;
	private String reason;
	private Object result;
	
	
	public Response(){
		
	}
	
	public Response(String status, String reason, Object result) {
		super();
		this.status = status;
		this.reason = reason;
		this.result = result;
	}
	
	public Boolean isOK(){
		return StringUtils.equalsIgnoreCase(this.status, OK);
	}
	
	public Response ok(String reason, Object result){
		return okResponse(reason,result);
	}

	public Response fail(String reason, Object result){
		return nokResponse(reason,result);
	}
	
	private Response okResponse(String reason, Object result) {
        Response response = new Response();
        response.setStatus(OK);
        
        if(reason!=null){
        	response.setReason(reason);
        }
        
        if(result!=null){
        	response.setResult(result);
        }
        
        return response;
    }
	
	
	
	private Response nokResponse(String reason, Object result) {
		Response response = new Response();
        response.setStatus(NOK);
        
        if(reason!=null){
        	response.setReason(reason);
        }
        
        if(result!=null){
        	response.setResult(result);
        }
        
        return response;
    }
	
	
	


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
	
}
