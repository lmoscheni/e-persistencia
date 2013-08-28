package main;

import java.util.Random;

import email.Email;

import Exceptions.*;

public class VirtualDT {

	protected HomeUser users = new HomeUser();
	
	//********************************************************************************************************************
	private void notifyValidation(String email) {
		String code = this.getCode(7);
		Email emailToSend = new Email(email, "Codigo de validacion: " + code);
	}
	
	public void validatePassword(String userName, String password) throws Exception{
		if (this.users.isSamePassword(userName, password)){
			
		}
		else{
			throw new FailPasswordException();
		}
	}
	
	private String getCode (int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
			char c = (char)r.nextInt(255);
			if ( (c >= '0' && c <= '9') || (c >= 'A' && c <='Z') ){
				cadenaAleatoria += c;
				i ++;
			}
		}
		return cadenaAleatoria;
	}
	//********************************************************************************************************************
	
	public void registrateUser(String userName, String name, String surname, String email, String birth, String password) throws Exception{
		if(!this.users.userExist(userName)){
			this.users.save(userName,name,surname,email,birth,password);
			this.notifyValidation(email);
		}else{
			throw new UserAlreadyExistException();
		}
	}

	public void validationUser(String userName, String codec){
		if (this.users.isSameCode(userName,codec)){
			this.users.validate(userName);
		}
		else{
			throw new FailCodeValidationException();
		}
	}
	
	public void login(String userName, String password) throws Exception{
		if(this.users.isSamePassword(userName, password)){
			System.out.print("Usuario logueado");
		}else{
			throw new FailPasswordException();
		}
	}
	
	public void changePassword(String userName, String password) throws Exception{
		try{
			//this.validatePassword(userName,password);
			this.users.changeUserPassword(userName,password);
		}catch(FailPasswordException e){
			
		}
	}
	
}
