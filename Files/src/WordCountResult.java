
public class WordCountResult {
	private int countWord,countLine,countChars;
	public int getCountWord() {
		return countWord;
	}
	public void setCountWord(int countWord) {
		this.countWord = countWord;
	}
	public int getCountLine() {
		return countLine;
	}
	public void setCountLine(int countLine) {
		this.countLine = countLine;
	}
	public int getCountChars() {
		return countChars;
	}
	public void setCountChars(int countChars) {
		this.countChars = countChars;
	}
	public WordCountResult(int countWords, int countLine, int countChars) {
		// TODO Auto-generated constructor stub
		this.countWord = countWords;
		this.countLine = countLine;
		this.countChars = countChars;
	}

}
