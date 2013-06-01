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
		assertEquals(7, Javersion.parse("JDK7u0").getFamilyNumber());
		assertEquals(0, Javersion.parse("JDK7u0").getUpdateNumber());
		assertEquals(8, Javersion.parse("JDK8u0").getFamilyNumber());
	}

	@Test(expected=ParseException.class)
	public void isValidがtrueでないときparseは例外を投げること() throws ParseException{
		Javersion.parse("hogehoge");
		Javersion.parse(null); //IllegalArgumentException
	}

	@Test
	public void changeToLongは下位32bitにunを振り上位32bitはfnを振ったものを返すこと() throws ParseException{
		assertEquals((7L << 32L) + 1L ,VersionNumber.changeToLong(Javersion.parse("JDK7u1")));
	}

	@Test
	public void gtは引数とバージョンを比較し引数よりバージョンが大きければtrueを返すこと() throws ParseException{
		assertTrue(Javersion.parse("JDK7u1").gt(Javersion.parse("JDK7u0")));
		assertTrue(Javersion.parse("JDK8u1").gt(Javersion.parse("JDK7u1")));
		assertFalse(Javersion.parse("JDK7u1").gt(Javersion.parse("JDK7u3")));
		assertFalse(Javersion.parse("JDK7u1").gt(Javersion.parse("JDK7u1")));
	}

	@Test
	public void ltは引数とバージョンを比較し引数よりバージョンが小さければtrueを返すこと() throws ParseException{
		assertTrue(Javersion.parse("JDK7u0").lt(Javersion.parse("JDK7u1")));
		assertTrue(Javersion.parse("JDK7u1").lt(Javersion.parse("JDK8u1")));
		assertFalse(Javersion.parse("JDK7u3").lt(Javersion.parse("JDK7u1")));
		assertFalse(Javersion.parse("JDK7u1").lt(Javersion.parse("JDK7u1")));
	}

	@Test
	public void nextLimitedUpdateはLUを適用したバージョンのオブジェクトを返すこと() throws ParseException{
		assertEquals(7, Javersion.parse("JDK7u0").nextLimitedUpdate().getFamilyNumber());
		assertEquals(20, Javersion.parse("JDK7u0").nextLimitedUpdate().getUpdateNumber());
	}

	@Test
	public void nextCriticalPatchUpdateはCPUを適用したバージョンのオブジェクトを返すこと() throws ParseException{
		assertEquals(7, Javersion.parse("JDK7u0").nextCriticalPatchUpdate().getFamilyNumber());
		assertEquals(5, Javersion.parse("JDK7u0").nextCriticalPatchUpdate().getUpdateNumber());
		assertEquals(11, Javersion.parse("JDK7u9").nextCriticalPatchUpdate().getUpdateNumber());
	}
}
