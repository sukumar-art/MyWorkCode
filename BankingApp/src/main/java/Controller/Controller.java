package Controller;

import Main.ControllerImpl;

public class Controller implements ControllerImpl {
	public static String userName = null;
	public static Integer pw = 0;
	
	public static Integer balance = 0;
	public static Integer deposit;
	public static Integer withdraw;
	
	@Override
	public int checkBalance() {
		return balance;
	}
	@Override
	public void deposit(Integer deposit) {
		Controller.deposit = deposit;
		balance = balance + deposit;
		
	}
	@Override
	public void withdraw(Integer withdraw) {
		Controller.withdraw = withdraw;
		balance = balance - withdraw;
		
	}
	@Override
	public boolean register(String name, Integer pw) {
		Controller.userName = name;
		Controller.pw = pw;
		return false;
	}
	
}
