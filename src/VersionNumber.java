
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



}
