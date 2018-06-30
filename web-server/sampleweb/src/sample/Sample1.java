package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import action.Action;



public  class Sample1 implements Action{

	@Override
	public void execute(Map<String, String> arg0, OutputStream arg1) throws IOException {

		//出力ストリームをバッファリング可能な文字列出力ストリームに変換
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(arg1));

		try {
			bw.write("<html>");
			bw.write("<body>");
			//リクエストパラメータ(name)の値を出力
			bw.write("<h1>GETパラメータのnameを出力する</h1>");
			bw.write("<h1>" + arg0.get("name")+ "</h1>");
			bw.write("</body>");
			bw.write("</html>");

			bw.flush();
		} catch (IOException e) {

			throw e;
		}
	}

}