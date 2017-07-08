import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//创建文件所需的数据类
public class Creator {
	//以下成员变量应在生成实例或赋值之前进行检查并确认无误
	public String author;//本次生成的一系列文件的作者
	public String filename;//文件名基础信息，手动输入
	public Rule[] rules;//checker涉及的规则，手动输入
	public int ccount;//需要的case文件数量，下拉菜单选择
	public String checkerpath;//存放checker文件的位置，图形界面选择
	public String scriptpath;//存放测试脚本文件的位置，图形界面选择
	public String casepath;//存放测试用例的位置，图形界面选择
	
	public Creator(String author,String filename,Rule[] rules,int ccount,String[] paths)
	{
		this.author=author;
		this.filename=filename;
		this.rules=rules;
		this.ccount=ccount;
		this.checkerpath=paths[0];
		this.scriptpath=paths[1];
		this.casepath=paths[2];
	}
	
	//创建文件并写入内容
	public static void Make(Creator creator)
	{
		MakeCheckerFile4OneRule(creator);
		MakeTestFile4OneRule(creator);
	}

	//为单个规则生成checker文件
	private static void MakeCheckerFile4OneRule(Creator creator)
	{
		//打开文件
		File checkerexample = Test.checkerexample;
		File newcheckerfile = new File(creator.checkerpath+creator.filename+",java");
		
		//准备填入的文本
		//第1行，package语句
		String[] packagestrgroup=creator.checkerpath.split("/");
		String packagestr="";
		for(int i=packagestrgroup.length;i>=0;i--)
		{
			if(packagestrgroup[i]!=null&&packagestrgroup[i].length()>0)
				packagestr=packagestr+packagestrgroup[i]+".";
		}
		packagestr=packagestr.substring(0, packagestr.length()-1);
		
		try
		{
			//打开各种流
			FileInputStream feg=new FileInputStream(checkerexample);
			InputStreamReader egreader=new InputStreamReader(feg, "UTF-8");
			BufferedReader egbr = new BufferedReader(egreader);
			FileOutputStream fnew=new FileOutputStream(newcheckerfile);
			OutputStreamWriter newreader=new OutputStreamWriter(fnew, "UTF-8");
	        BufferedWriter  newbw=new BufferedWriter(newreader);
			
			int row=1;
			String line;
			while((line=egbr.readLine())!=null)
			{
				switch(row)
				{
					//第1行，package语句
					case 1:
						line=line.replace("inputpath", packagestr);
						newbw.write(line);
						row++;
						break;
					//第4行，规则序号和规则名
					case 4:
						line=line.replace("inputnumber", creator.rules[0].number);
						line=line.replace("inputname", creator.rules[0].name);
						newbw.write(line);
						row++;
						break;
					//第6行，作者
					case 6:
						line=line.replace("inputauthor", creator.author);
						newbw.write(line);
						row++;
						break;
					//第7行，描述
					case 7:
						line=line.replace("inputdescription", creator.rules[0].description);
						newbw.write(line);
						row++;
						break;
					//第12行，priority, category和 message
					case 12:
						line=line.replace("inputpriority", creator.rules[0].number);
						line=line.replace("inputcategory", creator.rules[0].category);
						line=line.replace("inputmessage", creator.rules[0].message);
						newbw.write(line);
						row++;
						break;
					//第13行，类名和父类名
					case 13:
						line=line.replace("inputcheckername", creator.filename);
						line=line.replace("inputsuperclass", "AbstractRuleAndRuleChecker");
						newbw.write(line);
						row++;
						break;
					default:
						newbw.write(line);
						row++;
						break;
				}
			}
			
			//关闭各种流
			newbw.close();
			newreader.close();
			fnew.close();
			egbr.close();
			egreader.close();
			feg.close();
		}
		catch (IOException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	//为单个规则生成Test脚本文件
	private static void MakeTestFile4OneRule(Creator creator) {
		
	}
}
