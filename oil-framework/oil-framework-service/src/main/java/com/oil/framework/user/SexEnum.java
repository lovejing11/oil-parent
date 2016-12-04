package com.oil.framework.user;

public enum SexEnum {
																					WOMEN("女"), MAN("男"), NONE("未设置");
				private String label;

				private SexEnum(String label) {
								this.label = label;
				}

				public static String getName(String label) {
								for (SexEnum c : SexEnum.values()) {
												if (c.label.equals(label)) {
																return c.name();
												}
								}
								return null;
				}

				// 覆盖方法
				@Override
				public String toString() {
								return this.label;
				}

				public String getLabel() {
								return this.label;
				}

				public void setLabel(String label) {
								this.label = label;
				}
}