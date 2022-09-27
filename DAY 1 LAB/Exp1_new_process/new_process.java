package Exp1_new_process;
public class new_process{
	public static void main(String[] args)
	{
		try {

			System.out.println("Creating Process");

			ProcessBuilder builder = new ProcessBuilder("notepad.exe");
			Process pro = builder.start();

			System.out.println("Waiting");
			Thread.sleep(10000);

			pro.destroyForcibly();
			System.out.println("Process destroyed");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
