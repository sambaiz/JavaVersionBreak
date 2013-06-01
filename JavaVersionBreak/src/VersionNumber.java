
public class VersionNumber {

	//unsignedが使えないのでsetterで規制
	private int familyNumber;
	private int updateNumber;

	public VersionNumber(int familyNumber, int updateNumber) {
		super();
		setFamilyNumber(familyNumber);
		setUpdateNumber(updateNumber);
	}

	public int getFamilyNumber() {
		return familyNumber;
	}

	public void setFamilyNumber(int num) {
		if(num<0) throw new IllegalArgumentException();
		this.familyNumber = num;
	}

	public int getUpdateNumber() {
		return updateNumber;
	}

	public void setUpdateNumber(int num) {
		if(num<0) throw new IllegalArgumentException();
		this.updateNumber = num;
	}

	public static long changeToLong(VersionNumber versionnum) {
		return (((long) versionnum.getFamilyNumber() << 32L) + (long) versionnum.getUpdateNumber());
	}

	public boolean gt(VersionNumber version){
		return changeToLong(version) < changeToLong(this);
	}

	public boolean lt(VersionNumber version){
		return changeToLong(version) > changeToLong(this);
	}

	public VersionNumber nextLimitedUpdate() {
		return new VersionNumber(this.familyNumber, 20 * ((this.updateNumber / 20) + 1));
	}

	public VersionNumber nextCriticalPatchUpdate() {
		int tmp = (this.updateNumber / 5) + 1;
		if(this.nextLimitedUpdate().getUpdateNumber() == (5 * tmp) - (tmp % 2)) throw new IllegalStateException();
		return new VersionNumber(this.familyNumber, (5 * tmp) - (tmp % 2) + 1);
	}

	public VersionNumber nextSecurityUpdate() {
		if(this.nextLimitedUpdate().getUpdateNumber() == this.updateNumber + 1) throw new IllegalStateException();
		if(this.nextCriticalPatchUpdate().getUpdateNumber() == this.updateNumber + 1) throw new IllegalStateException();
		return new VersionNumber(this.familyNumber, this.updateNumber + 1);
	}

}
