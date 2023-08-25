package Main;

public interface ControllerImpl {
	public boolean register(String name, Integer pw);
	public int checkBalance ();
	public void deposit (Integer amount);
	public void withdraw (Integer amount);
}
