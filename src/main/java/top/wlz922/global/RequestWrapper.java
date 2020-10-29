package top.wlz922.global;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;

/**
 * @author Eddie
 */
@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {
	/**
	 * 存储body数据的容器
	 */
	private final byte[] body;

	public RequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = inputStreamToByteArray(request.getInputStream());
	}

	private byte[] inputStreamToByteArray(InputStream in) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bytes = new byte[1024];
		int len;
		while ((len = in.read(bytes)) != -1) {
			bos.write(bytes);
		}
		return bos.toByteArray();
	}

	/**
	 * 获取请求Body
	 *
	 * @return String
	 */
	public String getBodyString() {
		final InputStream inputStream = new ByteArrayInputStream(body);

		return inputStream2String(inputStream);
	}

	/**
	 * 将inputStream里的数据读取出来并转换成字符串
	 *
	 * @param inputStream inputStream
	 * @return String
	 */
	private String inputStream2String(InputStream inputStream) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			log.error("", e);
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					log.error("", e);
				}
			}
		}

		return sb.toString();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		final ByteArrayInputStream inputStream = new ByteArrayInputStream(body);

		return new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return inputStream.read();
			}

			@Override
			public boolean isFinished() {
				return inputStream.available() == 0;
			}

			@Override
			public boolean isReady() {
				return inputStream.available() > 0;
			}

			@Override
			public void setReadListener(ReadListener readListener) {
			}
		};
	}
}
