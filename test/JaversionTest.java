import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;


public class JaversionTest {

	@Test
	public void JDK_7以上の整数_u_0以上の整数_のときisValidがtrueを返すこと() {
		assertTrue(Javersion.isValid("JDK7u0"));
		assertFalse(Javersion.isValid("JDK6u6"));
		assertFalse(Javersion.isValid("hogehoge"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void _isValidはNullを渡された時例外を投げること(){
		Javersion.isValid(null);
	}
	
	@Test
	public void JDK_Nu_MのときfamilyNumberがNupdateNumberがMのオブジェクトを返すこと() throws ParseException{
		assertEquals(7, Javersion.parse("JDK7u0").familyNumber);
		assertEquals(0, Javersion.parse("JDK7u0").updateNumber);
		assertEquals(8, Javersion.parse("JDK8u0").familyNumber);
	}

	@Test(expected=ParseException.class)
	public void isValidがfalseのときparseは例外を投げること() throws ParseException{
		Javersion.parse("hogehoge");
		Javersion.parse(null);
	}

}
