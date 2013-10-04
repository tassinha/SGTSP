/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnviarEmail;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class MailTester {
    public static void enviarEmail(Map<String, String> map, String mensagem, String tipo) throws UnsupportedEncodingException, MessagingException {
        MailJava mj = new MailJava();
        //configuracoes de envio
        mj.setSmtpHostMail("smtp.gmail.com");
        mj.setSmtpPortMail("587");
        mj.setSmtpAuth("true");
        mj.setSmtpStarttls("true");
        mj.setUserMail("gefurtuoso@gmail.com");
        mj.setFromNameMail("SGTSP");
        mj.setPassMail("sucodelaranjacomlimao");
        mj.setCharsetMail("ISO-8859-1");
        mj.setSubjectMail(tipo);
        mj.setBodyMail(mensagem);
        mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);
 
        //sete quantos destinatarios desejar
       
        
        
 
        mj.setToMailsUsers(map);
 
        //seta quatos anexos desejar
        List<String> files = new ArrayList<String>();
        // files.add("D:\\a.htm");
        //files.add("D:\\a.pdf");
        // files.add("C:\\images\\hover_next.png");
        // files.add("C:\\images\\hover_prev.png");
 
        mj.setFileMails(files);
 
      //  try {
            new MailJavaSender().senderMail(mj);
      //  } catch (UnsupportedEncodingException e) {
       //     e.printStackTrace();
     //   } catch (MessagingException e) {
      //      e.printStackTrace(); 
      //  } catch(Exception e){
       //     System.out.println("Erro: "+e.toString());
       // }
    }
 
    
 
    
    
}