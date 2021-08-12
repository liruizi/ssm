package cn.stylefeng.guns.modular.business.Enum;

import lombok.Getter;

@Getter
public enum ActivityUitl {
	dcq("dcq", "东城区"), xcq("cxq", "西城区"), hdq("hdq", "海淀区"), cyq("cyq", "朝阳区"), mtg("mtg", "门头沟"), tz("tz", "通州区"),
	bj("bj", "北京市"), xk("xk", "小康"), dxhd("dxhd", "大型活动"), dzjg("dzjg", "党政机关"), cghd("cghd", "参观活动"),
	sqpx("sqpx", "社区培训"), xx("xx", "学校"),jyjd("jyjd", "教育基地");

	// 成员变量
	private String index;
	private String name;

	// 构造方法
	private ActivityUitl(String name, String index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(String name) {
		for (ActivityUitl c : ActivityUitl.values()) {
			if (c.getName().equalsIgnoreCase(name)) {
				return c.index;
			}
		}
		return null;
	}

}
