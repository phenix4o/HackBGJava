public class Time {
	private int hour, min, sec, day, m, year;

	public Time(int hour, int min, int sec, int day, int m, int year) {
		if(hour<24&&hour>=0&&min>=0&&min<60&&sec>=0&&sec<60&&day>0&&day<=31&&m<13&&m>0&&year>2014&&year<1000000000){
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		this.day = day;
		this.m = m;
		this.year = year;
		}
		else{
			throw new IllegalArgumentException("Please enter correct values for the Time");
		}
	}

	public String toString() {
		year = year % 100;

		return String.format("%02d:%02d:%02d %02d.%02d.%02d", hour, min, sec,
				day, m, year);

	}
	public static void main(String... args){
		Time t = new Time(24, 60, 30, 22, 7, 2007);
	}
	
}
