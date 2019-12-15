/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author bibo_121
 */
public class Paypal implements PaymentMethod {

	private String emailId;
	private String password;
	
	public Paypal(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	

	@Override
public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}

}