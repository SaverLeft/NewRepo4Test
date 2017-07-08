import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	final static String[] rule1str={"1.1.1.1","这条规则名叫测试1","这是用来测试的规则1","开发阶段测试用","TEST","0"};
	final static Rule rule1=new Rule(rule1str);
	final static String[] rule2str={"1.1.1.2","这条规则名叫测试2","这是用来测试的规则2","开发阶段测试用","TEST","1"};
	final static Rule rule2=new Rule(rule2str);
	final static Rule[] rules={rule1,rule2};
	
	final static String[] paths={"./tempfile/checker/","./tempfile/script/","./tempfile/case/"};
	final static Creator createdata=new Creator("xzh","name1",rules,3,paths);
	//固定的模版文件地址
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}*/
		
		中文测试 对象实例=new 中文测试();
		System.out.println(对象实例.中文变量);
		
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
