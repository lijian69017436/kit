package se.se;


	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileFilter;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.io.PrintWriter;
	import java.io.UnsupportedEncodingException;

	/**
	 * 类描述：Linux 下批量转换文件编码格式
	 */
	public class EncodeConverter {
		// 原文件目录
		private static String srcDir = "D:\\work\\workspace1\\3--struts_4_ognl\\src\\main\\java";
		// 转换后的存放目录
		private static String desDir = "D:\\work\\workspace1\\3--struts_4_ognl\\src1";
		// 源文件编码
		private static String srcEncode = "gbk";
		// 输出文件编码
		private static String desEncode = "utf-8";
		/**
		 * 处理的文件过滤,过滤器
		 */
		private static FileFilter filter = new FileFilter() {
			public boolean accept(File pathname) {
				// 只处理：目录 或是 .java文件
				if (pathname.isDirectory()
						||
						(pathname.isFile() && pathname.getName().endsWith(".java"))
//						||(pathname.isFile() && pathname.getName().endsWith(".xml"))
						) {
					return true;
				} else {
					return false;
				}
			}
		};

		/**
		 * @param file
		 */
		public static void readDir(File file) {
			// 以过滤器作为参数
			File[] files = file.listFiles(filter);
			for (File subFile : files) {
				/**
				 * 建立目标目录
				 */
				if (subFile.isDirectory()) { //如果 是目录   创建一个绝对的路径 
					File file3 = new File(desDir+ subFile.getAbsolutePath().substring(srcDir.length() - 5));
					System.out.println("新目录 的 路径名称"+desDir+ subFile.getAbsolutePath().substring(srcDir.length() - 5));
					if (!file3.exists()) { //如果 文件不存在   创建 子目录
						file3.mkdirs();
					}
					file3 = null;
					readDir(subFile);
				}
				/**
				 * 建立目标文件
				 */
				else {
					System.err.println("一源文件：/t"+ subFile.getAbsolutePath()+ "/n目标文件：/t"+ (desDir + subFile.getAbsolutePath().substring(
									srcDir.length() - 5)));
					System.err.println("-----------------------------------------------------------------");
					try {
						convert(subFile.getAbsolutePath(),
								desDir
										+ subFile.getAbsolutePath().substring(
												srcDir.length() - 5), srcEncode,
								desEncode);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		/**
		 * @param infile
		 *            源文件路径
		 * @param outfile
		 *            输出文件路径
		 * @param from
		 *            源文件编码
		 * @param to
		 *            目标文件编码
		 * @throws IOException
		 * @throws UnsupportedEncodingException
		 */
		public static void convert(String infile, String outfile, String from,
				String to) throws IOException, UnsupportedEncodingException {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(infile), from));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile), to)));
			String reading;
			while ((reading = in.readLine()) != null) {
				out.println(reading);
			}
			out.close();
			in.close();
		}

		public static void main(String[] args) {
			// 建立目标文件夹
			File desFile = new File(desDir);
			if (!desFile.exists()) {
				desFile.mkdir();
			}
			desFile = null;
			File srcFile = new File(srcDir);
			// 读取目录 循环转换文件
			readDir(srcFile);
			srcFile = null;
		}
	}
