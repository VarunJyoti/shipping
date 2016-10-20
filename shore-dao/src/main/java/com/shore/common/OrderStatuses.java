package com.shore.common;

/**
 * @author harpreet.billing
 * @since Oct 05, 2016
 */
public final class OrderStatuses {

	public static final Integer DRAFT = 0;
	public static final String DRAFT_VAL = "Created Draft";
	
	public static final Integer NEW = 1;
	public static final String NEW_VAL = "Order Created";
	
	public static final Integer PURPOSE_CHANGE_RECEIVED = 2;
	public static final String PURPOSE_CHANGE_RECEIVED_VAL = "Purpose Change Received";
	
	public static final Integer PURPOSE_CHANGE_ACCEPTED = 3;
	public static final String PURPOSE_CHANGE_ACCEPTED_VAL = "Purpose Change Received";
	
	public static final Integer QUOTE_RECEIVED = 4;
	public static final String QUOTE_RECEIVED_VAL = "Quote Received From Supplier";
	
	public static final Integer ACCEPTED = 5;
	public static final String ACCEPTED_VAL = "Quote Accepted";
	
	public static final Integer SHIPPED = 6;
	public static final String SHIPPED_VAL = "Shipped by Supplier";
	
	public static final Integer RECEIVED = 7;
	public static final String RECEIVED_VAL = "Order Received";
	
	public static final Integer REJECTED = 12;
	public static final String REJECTED_VAL = "Rejected";
	
	public static final Integer DELIVERED = 13;
	public static final String DELIVERED_VAL = "Delivered";
	
}
