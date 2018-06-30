package webserver;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RunServer {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		ServerSocket ss;
		int port = Integer.parseInt(args[0]);
		String rootDir = args[1];

		System.out.println("サーバーを起動しました。 ポート番号：" + port + " ルートディレクトリ：" + rootDir);
		try {
			ss = new ServerSocket(port);

			while(true) {
				//サーバー側ソケット作成
		        Socket sc = ss.accept();

		        //ソケットから入力ストリームを取得
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));

				String requestFileName = "";
				String line = br.readLine();
				while(line != null && !line.equals("")) {

					System.out.println(line);
					if (line.startsWith("GET /")
							&& line.endsWith(" HTTP/1.1")) {
						//GET /[RequestURL] HTTP/1.1
						//上記パラメータの[RequestURL]部分を取得する
						requestFileName = line.replaceAll("GET /", "").replaceAll(" HTTP/1.1", "");
					}
					line = br.readLine();
				}



				//リクエストURLから取得したファイルを読み込む
				File file = new File (rootDir + "/" + requestFileName);
				if (file.exists() && !requestFileName.equals("")) {

					//ソケットから出力ストリームを取得
					BufferedOutputStream bo = new BufferedOutputStream(sc.getOutputStream());

					FileInputStream fi = new FileInputStream(file);

					//bo.write("HTTP/1.1 200 OK".getBytes());
					while(fi.available() > 0) {
						byte[] b = new byte[fi.available()];
						fi.read(b);
						bo.write(b);
					}
					bo.flush();
					bo.close();
					fi.close();
				}else {
					//ソケットから出力ストリームを取得
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));

					bw.write("HTTP/1.1 404 Not Found");
					bw.flush();
					bw.close();
				}

				br.close();
				System.out.println("resopnse " + requestFileName);
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
