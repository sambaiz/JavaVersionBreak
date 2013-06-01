import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Javersion {
	private static final String VERSION_STRING = "^JDK([1-9]?[0-9]+)u([1-9]?[0-9]+)$";
	private static final Pattern VERSION_PATTERN = Pattern.compile(VERSION_STRING);

	public static boolean isValid(String version) {
		if(version == null) throw new IllegalArgumentException();
		Matcher matcher = VERSION_PATTERN.matcher(version);
		if(matcher.find() && Integer.parseInt(matcher.group(1)) >= 7) return true;
		return false;
	}

	public static VersionNumber parse(String version) throws ParseException {
		try{
			if (! isValid(version)) throw new ParseException(version, 0);
		}catch(IllegalArgumentException e){
			throw new ParseException(version, 0);
		}
		Matcher matcher = VERSION_PATTERN.matcher(version);
		matcher.find();
		return new VersionNumber(Integer.parseInt(matcher.group(1)) ,Integer.parseInt(matcher.group(2)));
	}

	public static long changeToLong(VersionNumber versionnum) {
		return (long) (((long) versionnum.getFamilyNumber() << 32l) + (long) versionnum.getUpdateNumber());
	}

}
