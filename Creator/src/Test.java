import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	final static String[] rule1str={"1.1.1.1","�����������в���1","�����������ԵĹ���1","�����׶β�����","TEST","0"};
	final static Rule rule1=new Rule(rule1str);
	final static String[] rule2str={"1.1.1.2","�����������в���2","�����������ԵĹ���2","�����׶β�����","TEST","1"};
	final static Rule rule2=new Rule(rule2str);
	final static Rule[] rules={rule1,rule2};
	
	final static String[] paths={"./tempfile/checker/","./tempfile/script/","./tempfile/case/"};
	final static Creator createdata=new Creator("xzh","name1",rules,3,paths);
	//�̶���ģ���ļ���ַ
	final static File checkerexample=new File("./example/checkerexample.java");
	final static File scriptexample=new File("./example/scriptexample.java");
	final static File caseexample=new File("./example/caseexample.c");
	
	public static void main(String[] args)
	{
		//Checker.CheckAll(createdata);
		/*try
		{
			File checkerfile = new File(createdata[1]+createdata[0]+".java");
			if(!checkerfile.exists()) checkerfile.createNewFile();
			
			File scriptfile = new File(createdata[2]+createdata[0]+".java");
			if(!scriptfile.exists()) scriptfile.createNewFile();
			
			File casefile = new File(createdata[3]+createdata[0]+".c");
			if(!casefile.exists()) casefile.createNewFile();
		} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}*/
		
		���Ĳ��� ����ʵ��=new ���Ĳ���();
		System.out.println(����ʵ��.���ı���);
		
	}
	
	
	public String makestr(int length)
	{
		String res="";
		for(int i=0;i<length;i++)
		{
			res+="abs";
		}
		return res;
	}
}
