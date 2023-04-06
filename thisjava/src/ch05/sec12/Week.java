package ch05.sec12;


public enum Week {
	MONDAY,
	TUESDAY,
	WEDSNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY;
	
	int getValue() {
		switch (this) {
		case MONDAY: return 1;
		case TUESDAY: return 2;
		case WEDSNESDAY: return 3;
		case THURSDAY: return 4;
		case FRIDAY: return 5;
		case SATURDAY: return 6;
		case SUNDAY: return 7;
		default: return 0;
		}
}
}
