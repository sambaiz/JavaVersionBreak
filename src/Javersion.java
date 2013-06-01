import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Javersion {
	private static final String VERSION_STRING = "^JDK([1-9]?[0-9])+u[1-9]?[0-9]+$";
	private static final Pattern VERSION_PATTERN = Pattern.compile(VERSION_STRING);

	public static boolean isValid(String version) {
		Matcher matcher = VERSION_PATTERN.matcher(version);
		if(matcher.find() && Integer.parseInt(matcher.group(1)) >= 7) return true; 
		return false;
	}

}
