package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Map;

import action.Action;
import template.TemplateEngine;

public class Sample3 implements Action{

	@Override
	public void execute(Map<String, String> arg0, OutputStream arg1) throws IOException {

		//出力ストリームをバッファリング可能な文字列出力ストリームに変換
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(arg1));

		try {
			TemplateEngine t = new TemplateEngine("D:\\webサーバー開発\\template");
			Context c = new Context();
			c.setTitle("test : " + new Date().toString());
			User u = new User();
			u.setName("User1");
			u.setName("User1@iface.jp");
			c.setUser(u);
			try {
				bw.write(t.parse("TemplateSample.txt", c));
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			bw.flush();
		} catch (IOException e) {

			throw e;
		}
	}

	public String getMessage() {
		return "112345";
	}


	private class Context {
		private String title;
		private User user;

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}



	}
	private class User {
		private String name;
		private String mailAddress;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMailAddress() {
			return mailAddress;
		}
		public void setMailAddress(String mailAddress) {
			this.mailAddress = mailAddress;
		}


	}
}
