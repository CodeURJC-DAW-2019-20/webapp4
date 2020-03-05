package es.urjc.daw.urjc_share.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadFileService {

    private String upload_folder = ".//src//main//resources//static//files_users//";
    public void saveFile(MultipartFile file, long id) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            String[] s = file.getOriginalFilename().split("\\.");
            String ruta = upload_folder + id +"."+s[s.length-1];
            Path path = Paths.get(ruta);
            Files.write(path, bytes);
        }
    }
}
