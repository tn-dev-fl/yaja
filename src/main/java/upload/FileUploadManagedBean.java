package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class FileUploadManagedBean {
	UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String dummyAction(){
		System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
		   try {
	            // Define the directory to save the uploaded file
	            String uploadDir = "/home/htb/Downloads/";
	            File dir = new File(uploadDir);

	            // If the directory does not exist, create it
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }

	            // Copy the uploaded file to the destination directory
	            String fileName = file.getFileName();
	            InputStream input = file.getInputStream();
	            OutputStream output = new FileOutputStream(new File(dir, fileName));

	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = input.read(buffer)) != -1) {
	                output.write(buffer, 0, bytesRead);
	            }

	            // Close streams
	            input.close();
	            output.close();

	            System.out.println("File saved to: " + uploadDir + File.separator + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "";
	}
}