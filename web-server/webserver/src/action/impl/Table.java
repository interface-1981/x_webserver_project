package action.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import action.Action;



public  class Table implements Action{

	//http://localhost/action.impl.Sample1?name=yasuda
	@Override
	public void execute(Map<String, String> arg0, OutputStream arg1) throws IOException {

		//出力ストリームをバッファリング可能な文字列出力ストリームに変換
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(arg1));

		try {
			bw.write("<html>");
			bw.write("<body>");
			//リクエストパラメータ(name)の値を出力
			bw.write("<h1> Output GET parameter</h1>");
			bw.write("<table border = \"1\">");
			bw.write("<tr><th>key</th><th>value</th></tr>");

			for(String key :arg0.keySet()) {
				bw.write("<tr><td>" + key + "</td><td>" + arg0.get(key) + "</td></tr>");
			}
			bw.write("</table>");

			bw.write("</body>");
			bw.write("</html>");

			bw.flush();
		} catch (IOException e) {

			throw e;
		}
	}

}