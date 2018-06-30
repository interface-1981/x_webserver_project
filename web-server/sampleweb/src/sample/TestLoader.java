package sample;

import action.Action;

public class TestLoader {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		try {
			@SuppressWarnings("rawtypes")
			Class c = Class.forName("sample.Sample1");
			@SuppressWarnings("unused")
			Action a = (Action)c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

}
