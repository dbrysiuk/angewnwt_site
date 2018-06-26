import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaerIO implements LesenSchreiben {

	String dateiName;
	
	BinaerIO(String dateiName)
	{
		this.dateiName = dateiName;
	}
	
	@Override
	public void schreibeDatei(Student[] studenten) throws IOException {
		FileOutputStream fos = new FileOutputStream(dateiName);
		DataOutputStream dos = new DataOutputStream(fos);
		
		if(studenten != null) {
			dos.writeInt(studenten.length);
			for(int i=0; i < studenten.length; i++) {
				dos.writeInt(studenten[i].matrikelNummer);
				dos.writeUTF(studenten[i].name);
				if(studenten[i].leistungen != null) {
					dos.writeInt(studenten[i].leistungen.length);

					for(int j=0; j < studenten[i].leistungen.length; j++) {
						dos.writeUTF(studenten[i].leistungen[j].modul);
						dos.writeDouble(studenten[i].leistungen[j].note);
					}
				}
				else
					dos.writeInt(0);	
			}
		}
		else
			dos.writeInt(0);
		dos.close();
		fos.close();
	}

	@Override
	public Student[] leseDatei() throws IOException {
		Student[] geleseneStudenten;

		FileInputStream fis = new FileInputStream(dateiName);
		DataInputStream dis = new DataInputStream(fis);

		int studCnt = dis.readInt();
		if(studCnt != 0)
		{
			geleseneStudenten = new Student[studCnt];
			for(int i=0; i < studCnt; i++) {
				geleseneStudenten[i] = new Student();
				geleseneStudenten[i].matrikelNummer = dis.readInt();
				geleseneStudenten[i].name = dis.readUTF();
				int leistCnt = dis.readInt();

				if(leistCnt != 0) {
					geleseneStudenten[i].leistungen = new Leistung[leistCnt];
					for(int j=0; j < leistCnt; j++) {
						geleseneStudenten[i].leistungen[j] = new Leistung();
						geleseneStudenten[i].leistungen[j].modul = dis.readUTF();
						geleseneStudenten[i].leistungen[j].note = dis.readDouble();
					}
				}
				else
					geleseneStudenten[i].leistungen = null;	
			}

		}
		else
			geleseneStudenten = null;

		dis.close();
		fis.close();
		return geleseneStudenten;
	}
	

}
