import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON_IO implements LesenSchreiben {
	
	String dateiName;
	Gson gson;
	
	JSON_IO(String dateiName) {
		this.dateiName = dateiName;
		gson = new GsonBuilder().create();
	}
	
	@Override
	public void schreibeDatei(Student[] studenten) throws IOException {
		FileOutputStream fos = new FileOutputStream(dateiName);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		
		gson.toJson(studenten,osw);
		
		osw.close();
		fos.close();
	}

	@Override
	public Student[] leseDatei() throws IOException {
		Student[] geleseneStudenten;
		FileInputStream fis = new FileInputStream(dateiName);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		
		geleseneStudenten = gson.fromJson(isr,Student[].class);
		
		isr.close();
		fis.close();
		
		return geleseneStudenten;
	}
	
}
