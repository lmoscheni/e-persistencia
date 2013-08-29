package main;

import java.util.Random;

import email.Email;

import Exceptions.*;

public class VirtualDT {

	protected HomeUser users;
	
	public VirtualDT(){
		this.users = new HomeUser();
	}
	//********************************************************************************************************************
	//********************************************************************************************************************
	
	/*
	 * Envia el codigo de validacion por mail al usuario.
	*/
	private void notifyValidation(String email,String code) {
		Email emailToSend = new Email(email, "Codigo de validacion: " + code);
		//emailToSend.send();
	}
	
	public void validatePassword(String userName, String password) throws Exception{
		if (this.users.isSamePassword(userName, password)){
			
		}
		else{
			throw new FailPasswordException();
		}
	}
	
	/*
	 * Genera un codigo alfanumerico, que luego se envia por mail.
	 */
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
	//********************************************************************************************************************
	
	public void registrateUser(String name, String userName, String surname, String email, String birth, String password){
		if(!this.users.userExist(userName)){
			String code = this.getCode(7);
			this.users.save(name,userName,surname,email,birth,password,code,false);
			this.notifyValidation(email,code);
		}else{
			throw new UserAlreadyExistException();
		}
	}

	public void validationUser(String userName, String codec){
		if (this.users.isSameCode(userName,codec)){
			this.users.validate(userName);
		}else{
			throw new FailCodeValidationException();
		}
		
	}
	
	public void login(String userName, String password){
		if(this.users.isSamePassword(userName, password)){
			System.out.print("Usuario logueado");
		}else{
			throw new FailPasswordOrUserException();
		}
	}
	
	public void changePassword(String userName, String password){
		this.users.changeUserPassword(userName,password);
	}
	//********************************************************************************************************************
}
