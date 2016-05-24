package buffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMDReader {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

	public static String readCmd() {
		try {
			return reader.readLine();
		} catch (IOException err) {
			err.printStackTrace();
		}
		return null;
	}
}
