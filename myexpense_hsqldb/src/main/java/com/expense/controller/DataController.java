package com.expense.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expense.services.DataService;

@Controller
@RequestMapping("/filedownload")
public class DataController {

	@Autowired
	private DataService dataService;
	
	@RequestMapping(value = "/action")
	public String loadForm() {
		return "category-page/download";
	}

	@RequestMapping(value = "/download")
	public void doDownload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FileInputStream stream = null;
		try {
			// Get the directory and iterate them to get file by file...
			File file = new File("import.sql");
			System.out.println(file.getCanonicalPath());
			if (!file.exists()) {
				System.out.println("doesn't exist");
			} else {
				response.setContentType("APPLICATION/SQL");
				response.setHeader("Content-Disposition",
						"attachment;filename=" + file);
				stream = new FileInputStream(file);
				response.setContentLength(stream.available());
				OutputStream os = response.getOutputStream();

				int bit = 256;
				try {
					while ((bit) >= 0) {
						bit = stream.read();
						os.write(bit);
					}
				} catch (IOException ioe) {
					ioe.printStackTrace(System.out);
				}

				os.close();
				response.flushBuffer();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@RequestMapping(value = "/writefile")
	public @ResponseBody
	String writeFile() {
		/*BufferedWriter writer = null;
		try {
			String timeLog = "import.sql";
			File logFile = new File(timeLog);

			// This will output the full path where the file will be written
			// to...
			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write("Hello world!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}*/
		dataService.writeSql("import.sql");
		return "true";
	}
}
