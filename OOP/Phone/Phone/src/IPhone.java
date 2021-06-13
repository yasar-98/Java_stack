public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	return "IPhone"+this.versionNumber()+"says"+this.ringTone() ;
    }
    @Override
    public String unlock() {
    	return "Unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
    	System.out.print("IPhone"+this.versionNumber()+"from"+this.carrier()+"\n");
    }
}
