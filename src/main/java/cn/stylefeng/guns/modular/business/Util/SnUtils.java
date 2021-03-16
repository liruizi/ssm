package cn.stylefeng.guns.modular.business.Util;

import java.text.NumberFormat;

public class SnUtils {
	/**
	 * 生成 0000000000001 格式
	 * 
	 * @param value   传入的数值
	 * @param miniMum 生成的最小位数 不足该为0补足
	 * @return
	 */
	public static String getSn(Integer value, Integer miniMum) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		// 整数显示最少位数不足前面补零
		formatter.setMinimumIntegerDigits(miniMum);
		formatter.setGroupingUsed(false);
		return formatter.format(value);
	}

	public static void main(String[] args) {
		String a = SnUtils.getSn(3, 6);
		System.out.println(a);
	}
}
