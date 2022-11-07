package character;

public class SavingThrows {
	private int strSave;
	private int dexSave;
	private int conSave;
	private int intSave;
	private int wisSave;
	private int chaSave;
	
	public static class Builder{
		private int strSave = 0;
		private int dexSave = 0;
		private int conSave = 0;
		private int intSave = 0;
		private int wisSave = 0;
		private int chaSave = 0;
		
		public Builder() {
			
		}
		
		public SavingThrows Build() {
			return new SavingThrows(this);
		}
		
	}
	
	private SavingThrows(Builder builder) {
		strSave = builder.strSave;
		dexSave = builder.dexSave;
		conSave = builder.conSave;
		intSave = builder.intSave;
		wisSave = builder.wisSave;
		chaSave = builder.chaSave;
	}
}
