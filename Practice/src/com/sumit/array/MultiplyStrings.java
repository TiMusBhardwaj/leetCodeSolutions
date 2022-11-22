package com.sumit.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyStrings {

	public static void main(String[] args) {

		System.out.println(new Solution().multiply("100", "0"));
	}

	static class Solution {
		public String multiply(String num1, String num2) {

			List<Integer> chars = new ArrayList<>();
			if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) {
				return "0";
			}

			int index = 0;
			int carry = 0;
			for (int i = 0; i < num2.length(); i++) {

				char m = num2.charAt(num2.length() - 1 - i);
				int mul = m - '0';

				for (int j = 0; j < num1.length(); j++) {
					index = i + j;
					char n = num1.charAt(num1.length() - 1 - j);
					int number = n - '0';

					if (index == chars.size()) {
						chars.add(0);
					}

					int a = ((mul * number) + carry + chars.get(index)) % 10;
					carry = ((mul * number) + carry + chars.get(index)) / 10;
					chars.set(index, a);
				}

				index++;
				int existingVal = (index == chars.size()) ? 0 : chars.get(index);
				int a = (carry + existingVal) % 10;
				carry = (carry + existingVal) / 10;
				if (a > 0 || carry > 0) {
					if (index == chars.size()) {
						chars.add(a);
					} else {
						chars.set(index, a);
					}
				}

			}

			Collections.reverse(chars);

			String res = chars.stream().map(String::valueOf).collect(Collectors.joining());

			return res;
		}
	}

}
