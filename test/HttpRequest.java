

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.net.URLEncoder;

public class HttpRequest {
	
	private static List<String> cookies = new ArrayList<String>();
    /**
     * ��ָ��URL����GET����������
     * 
     * @param url
     *            ���������URL
     * @param param
     *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return URL ������Զ����Դ����Ӧ���
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // �򿪺�URL֮�������
            URLConnection connection = realUrl.openConnection();
            // ����ͨ�õ���������
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            for (String cookie : cookies) {
                connection.addRequestProperty("Cookie",  cookie.split(";", 2)[0]);
             }
            // ����ʵ�ʵ�����
            connection.connect();
            // ��ȡ������Ӧͷ�ֶ�
            Map<String, List<String>> map = connection.getHeaderFields();
            // �������е���Ӧͷ�ֶ�
            for (String key : map.keySet()) {
                //System.out.println(key + "--->" + map.get(key));
            }
            // ���� BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("����GET��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر�������
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * ��ָ�� URL ����POST����������
     * 
     * @param url
     *            ��������� URL
     * @param param
     *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return ������Զ����Դ����Ӧ���
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
        	//url = URLEncoder.encode(url, "UTF-8");
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            for (String cookie : cookies) {
                conn.addRequestProperty("Cookie",  cookie.split(";", 2)[0]);
            }
            
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(conn.getOutputStream());
            // �����������
            out.print(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            //System.out.println(conn.getHeaderFields());
            
            cookies = conn.getHeaderFields().get("Set-Cookie");
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
     public static void main(String[] args) {
        //���� GET ����
        //String s=HttpRequest.sendGet("http://localhost/user/login", "");
        //System.out.println(s);

        
      //���� POST ����
      String sr=HttpRequest.sendPost("http://localhost/user/login", "username=1&password=1");
      System.out.println(sr);
      
      //�����ѯ
      sr=HttpRequest.sendPost("http://localhost/worktype/getworktypeinfos", "");
      System.out.println(sr);
      
      //��������id��ѯ
      sr=HttpRequest.sendPost("http://localhost/worktype/getbyworktypeid", "workid=2");
      System.out.println(sr);
      
       //�������
       	String sr2=HttpRequest.sendPost("http://localhost/worktype/addwork", "workname=test4");
     	 System.out.println(sr2);
        																	
        //����ɾ��
        String sr3=HttpRequest.sendPost("http://localhost/worktype/delwork", "workid=1");
        System.out.println(sr3);
        
      	//�����޸�
   		String sr4=HttpRequest.sendPost("http://localhost/worktype/updatework", "id=2&workname=test4");
        System.out.println(sr4);
        
        
        
        //�������Ȳ�ѯ
        sr=HttpRequest.sendPost("http://localhost/business/getbusinessinfos", "");
        System.out.println(sr);
        //���ݹ�������id��ѯ
        sr=HttpRequest.sendPost("http://localhost/business/getbyid", "id=1");
        System.out.println(sr);
        //����
        sr=HttpRequest.sendPost("http://localhost/business/addbusinessinfo", "worktypeid=2&desc=2��");
        System.out.println(sr);
         //ɾ��
        sr=HttpRequest.sendPost("http://localhost/business/delbusinessinfo", "id=1");
        System.out.println(sr);
         //�޸�
        sr=HttpRequest.sendPost("http://localhost/business/updatebusinessinfo", "workid=3&desc=3");
        System.out.println(sr);
    }

}

