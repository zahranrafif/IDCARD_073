/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B.IDCARD;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Zahran Rafif Pc
 */
@Controller
public class myController {
    @RequestMapping("/sendData")
//    @ResponseBody
    public String getData(@RequestParam("mytext") String getText,
                            @RequestParam("nik") String getNik,
                            @RequestParam("tanggal")    
                            @DateTimeFormat(pattern="yyyy-MM-dd") Date date, 
                            @RequestParam("myimage") MultipartFile image, Model model)
            throws IOException{
        
        SimpleDateFormat tanggal = new SimpleDateFormat("dd-MM-yyyy");    
        String newTanggal = tanggal.format(date);     
        String img = Base64.encodeBase64String(image.getBytes());
        String blob = "data:image/jpeg;base64,".concat(img);
        
        model.addAttribute("mytext", getText);
        model.addAttribute("nik", getNik);
        model.addAttribute("tanggal", newTanggal);
        model.addAttribute("img", blob);

        return  "view"; 
    }
}
