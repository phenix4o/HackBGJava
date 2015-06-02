import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Problems2Impl implements Problems2 {

	@Override
	public boolean isOdd(int number) {
		// TODO Auto-generated method stub
		if (number % 2 == 0) {
			return false;
		} else
			return true;
	}

	@Override
	public boolean isPrime(int number) {
		// TODO Auto-generated method stub
		int count = 0;
		if (number <= 1) {
			System.out.println("Please enter number that is greater 1");
		} else {
			for (int i = 2; i < number - 1; i++) {
				if (number % i == 0) {
					count++;
				}
			}
			if (count > 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int min(int... array) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	@Override
	public int kthMin(int k, int[] array) {
		// TODO Auto-generated method stub
		int temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		if (k > 0 && k < array.length) {
			return array[k];
		} else {
			System.out.println("Please enter valid K");
		}
		return 0;

	}

	@Override
	public float getAverage(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		float sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum / n;
	}

	@Override
	public long getSmallestMultiple(int upperBound) {
		// TODO Auto-generated method stub
		long lcm = 1;
		for (int i = 1; i <= upperBound; i++) {
			lcm = lcm(lcm, i);
		}
		return lcm;
	}

	private static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	private static long gcd(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	@Override
	public long getLargestPalindrome(long N) {
		// TODO Auto-generated method stub
		long result = 0;
		long counter = 0;
		for (long i = N - 1; i > 0; i--) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (i > 0) {
				list.add((int) (i % 10));
				i = i / 10;
			}
			if (list.size() % 2 == 0) {
				for (int j = 0; j < list.size() / 2; j++) {
					if (list.get(j) == list.get(list.size() - 1 - j)) {
						counter += 1;
					}
				}
				if (counter == list.size() / 2) {
					result = i;
				}
			} else {
				for (int j = 0; j < ((int) list.size() / 2) + 1; j++) {
					if (list.get(j) == list.get(list.size() - 1 - j)) {
						counter += 1;
					}
				}
				if (counter == (int) list.size() / 2) {
					result = i;
				}
			}
		}
		return result;
	}

	@Override
	public int[] histogram(short[][] image) {
		// TODO Auto-generated method stub
		int[] result = new int[256];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				result[image[i][j]] += 1;
			}
		}
		return result;
	}

	@Override
	public long doubleFac(int n) {
		// TODO Auto-generated method stub
		long result = 1;
		long resultOfFact = 1;
		while (n > 0) {
			result = result * n;
			n--;
		}
		while (result > 0) {
			resultOfFact = resultOfFact * result;
			result--;
		}
		return resultOfFact;
	}

	@Override
	public long kthFac(int k, int n) {
		// TODO Auto-generated method stub
		long result = 1;
		int number = n;
		for (int i = 0; i < k; i++) {
			result *= number;
			number--;
		}
		return result;
	}

	@Override
	public int getOddOccurrence(int[] array) {
		// TODO Auto-generated method stub
		int counter = 0;
		int result = 0;
		int i = 0;
		while (i < array.length) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					counter += 1;
				}
			}
			if ((counter) % 2 != 0) {
				result = array[i];
			}
			counter = 0;
		}
		return result;
	}

	@Override
	public long pow(int a, int b) {
		// TODO Auto-generated method stub
		long result = 1;
		while (b > 0) {
			if (b % 2 == 0) {
				b = b / 2;
				a = a * a;
			} else {
				b--;
				result = result * a;
			}
		}
		return result;
	}

	@Override
	public long maximalScalarSum(int[] a, int[] b) {
		long sum = 0;
		BubbleSort(a);
		BubbleSort(b);
		for (int i = 0; i < a.length; i++) {
			sum += a[i] * b[i];
		}
		return sum;
	}

	public static void BubbleSort(int[] num) {
		int j;
		boolean flag = true;
		int temp;
		while (flag) {
			flag = false;
			for (j = 0; j < num.length - 1; j++) {
				if (num[j] < num[j + 1]) {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true;
				}
			}
		}
	}

	@Override
	public int maxSpan(int[] array) {
		int maxSpan = 0;
		if (array.length != 1) {
			for (int i = 0; i < array.length; i++) {
				for (int j = array.length - 1; j > 0; j--) {
					if (array[i] == array[j] && (j - i + 1) > maxSpan) {
						maxSpan = j - i + 1;
					}
				}
			}
		} else {
			maxSpan = 1;
		}
		return maxSpan;
	}

	@Override
	public boolean canBalance(int[] array) {
		boolean value = false;
		if (array.length % 2 == 0) {
			int sum1 = 0;
			int sum2 = 0;

			for (int i = 0; i < array.length / 2; i++) {
				sum1 += array[i];
			}
			for (int i = array.length / 2; i < array.length; i++) {
				sum2 += array[i];
			}
			if (sum1 == sum2) {
				value = true;
			} else {
				value = false;
			}
		} else {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i <= array.length / 2; i++) {
				sum1 += array[i];
			}
			for (int i = array.length / 2 + 1; i < array.length; i++) {
				sum2 += array[i];
			}
			if (sum1 == sum2) {
				value = true;
			} else {
				value = false;
			}
		}
		return value;
	}

	@Override
	public int[][] rescale(int[][] original, int newWidth, int newHeight) {
		// TODO Auto-generated method stub
		int[] interpolationMatrix = new int[original.length
				* original[0].length];
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[0].length; j++) {
				interpolationMatrix[i * original[0].length + j] = original[i][j];
			}
		}
		int[] result = new int[newWidth * newHeight];
		double x_ratio = original[0].length / newWidth;
		double y_ratio = original.length / newHeight;
		double px, py;
		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				px = Math.floor(j * x_ratio);
				py = Math.floor(i * y_ratio);
				result[(i * newWidth) + j] = interpolationMatrix[(int) ((py * original[0].length) + px)];
			}
		}
		int[][] rescaled = new int[newHeight][newWidth];
		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				rescaled[i][j] = result[(i * newWidth) + j];
			}
		}
		return rescaled;
	}

	@Override
	public String reverseMe(String argument) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--) {
			sb.append(argument.charAt(i));
		}
		return sb.toString();
	}

	@Override
	public String copyEveryChar(String input, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				for (int j = 0; j < k; j++) {

					sb.append(input.charAt(i));
				}
			} else {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}

	@Override
	public String reverseEveryWord(String arg) {
		// TODO Auto-generated method stub
		String str[] = arg.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			for (int i = s.length() - 1; i >= 0; i--) {
				sb.append(s.charAt(i));
			}
			sb.append(" ");
		}
		return sb.toString();
	}

	@Override
	public boolean isPalindrome(String argument) {
		// TODO Auto-generated method stub
		boolean result = false;
		StringBuffer rev = new StringBuffer(argument).reverse();
		String strRev = rev.toString();
		if (argument.equals(strRev)) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isPalindrome(int number) {
		int palindrome = number; // copied number into variable
		int reverse = 0;

		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}
		if (number == reverse) {
			return true;
		}
		return false;
	}

	@Override
	public int getPalindromeLength(String input) {
		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = input.length();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int len = j - i;
				String curr = input.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}
		return maxPalinLength / 2;
	}

	@Override
	public int countOcurrences(String needle, String haystack) {
		// TODO Auto-generated method stub
		return (needle.split(haystack, -1).length - 1);
	}

	@Override
	public String decodeURL(String input) {
		try {
			return URLDecoder.decode(input, "UTF-8").toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int sumOfNumbers(String input) {
		// TODO Auto-generated method stub
		input = input.replaceAll("[\\D]+", " ");
		String[] numbers = input.split(" ");
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			try {
				sum += Integer.parseInt(numbers[i]);
			} catch (Exception e) {
				// Just in case, the element in the array is not parse-able into
				// Integer, Ignore it
			}
		}
		return sum;
	}

	@Override
	public boolean areAnagrams(String A, String B) {
		char[] word1 = A.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = B.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}

	@Override
	public boolean hasAnagramOf(String string, String string2) {
		char[] word1 = string.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = string2.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		String s = new String(word1);
		String s2 = new String(word2);
		return s.toLowerCase().contains(s2.toLowerCase());
		
	}

	public static void convertToGrayScale(BufferedImage img) throws IOException {
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				int r = new Color(img.getRGB(i, j)).getRed();
				int g = new Color(img.getRGB(i, j)).getGreen();
				int b = new Color(img.getRGB(i, j)).getBlue();
				int alpha = new Color(img.getRGB(i, j)).getAlpha();
				int gray = (int) Math.round(0.299 * r + 0.587 * g + 0.114 * b);
				int c = new Color(gray, gray, gray, alpha).getRGB();
				img.setRGB(i, j, c);
			}
		}
		File outputfile = new File("image.png");
		ImageIO.write(img, "png", outputfile);
	}

}
