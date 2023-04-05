import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Tree_R_Black treeRBlack = new Tree_R_Black();
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				try {
					String inp = bufferedReader.readLine();
					if (is_numeric(inp)) {
						treeRBlack.add(Integer.parseInt(inp));
						System.out.println("ready");
					} else {
						throw new Exception();
					}
				} catch (Exception ignored) {
					System.out.println(ignored.getMessage());
					System.out.println("Repeat your enter");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static boolean is_numeric(String string) {
		return string.matches("^\\d+$");
	}
}