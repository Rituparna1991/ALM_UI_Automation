package com.alm.automation.globalvariables;

public class EnumDeclarations {

	public static enum WindowTitles{
		LOGINPAGETITLE("OFSAA Login Screen"),WELCOMEPAGETITLE("Oracle Financial Services Analytical Applications"),MRMMPAGETITLE("MRMM");

		private String WindowTitles;

		WindowTitles(String WindowTitles) {
			this.WindowTitles=WindowTitles;
		}

		public  String getValue() {
			return WindowTitles;
		}
	}

	public static enum SleepPeriod{
		SMALLSLEEP(1000),SHORTSLEEP(2000),NORMALSLEEP(5000),LONGSLEEP(10000),EXPLICTSHORTWAITINSECONDS(30);

		private int sleepPeriod;

		SleepPeriod(int sleepPeriod) {
			this.sleepPeriod=sleepPeriod;
		}

		public int getValue() {
			return sleepPeriod;
		}
	}

	public static enum InstrumentType{
		AMORTIZINGBOND("Amortizing Bond");

		private String instrumentype;

		InstrumentType(String instrumentype) {
			this.instrumentype=instrumentype;
		}
		public String getValue() {
			return instrumentype;
		}
	}
	
	public static enum Currency{
		USDOLLAR("US Dollar"),DUTCHGUIDER("Dutch Guilder");

		private String currency;

		Currency(String currency) {
			this.currency=currency;
		}
		public String getValue() {
			return currency;
		}
	}
	
	public static enum EntityName{
		MISSING("Missing"),OTHERS("Others");

		private String entity;

		EntityName(String entity) {
			this.entity=entity;
		}
		public String getValue() {
			return entity;
		}
	}
	
	public static enum CounterPartyName{
		MISSING("Missing"),OTHERS("Others");

		private String counterPartyName;

		CounterPartyName(String counterPartyName) {
			this.counterPartyName=counterPartyName;
		}
		public String getValue() {
			return counterPartyName;
		}
	}


}
