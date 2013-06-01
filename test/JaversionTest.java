import static org.junit.Assert.*;

import org.junit.Test;


public class JaversionTest {

	@Test
	public void JDK_7以上の整数_u_0以上の整数_のときisValidがtrueを返すこと() {
		assertTrue(Javersion.isValid("JDK7u0"));
		assertTrue(Javersion.isValid("JDK8u1"));
		assertFalse(Javersion.isValid("JDK6u6"));
		assertFalse(Javersion.isValid("hogehoge"));
	}

}
