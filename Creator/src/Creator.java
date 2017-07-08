import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//�����ļ������������
public class Creator {
	//���³�Ա����Ӧ������ʵ����ֵ֮ǰ���м�鲢ȷ������
	public String author;//�������ɵ�һϵ���ļ�������
	public String filename;//�ļ���������Ϣ���ֶ�����
	public Rule[] rules;//checker�漰�Ĺ����ֶ�����
	public int ccount;//��Ҫ��case�ļ������������˵�ѡ��
	public String checkerpath;//���checker�ļ���λ�ã�ͼ�ν���ѡ��
	public String scriptpath;//��Ų��Խű��ļ���λ�ã�ͼ�ν���ѡ��
	public String casepath;//��Ų���������λ�ã�ͼ�ν���ѡ��
	
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
	
	//�����ļ���д������
	public static void Make(Creator creator)
	{
		MakeCheckerFile4OneRule(creator);
		MakeTestFile4OneRule(creator);
	}

	//Ϊ������������checker�ļ�
	private static void MakeCheckerFile4OneRule(Creator creator)
	{
		//���ļ�
		File checkerexample = Test.checkerexample;
		File newcheckerfile = new File(creator.checkerpath+creator.filename+",java");
		
		//׼��������ı�
		//��1�У�package���
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
			//�򿪸�����
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
					//��1�У�package���
					case 1:
						line=line.replace("inputpath", packagestr);
						newbw.write(line);
						row++;
						break;
					//��4�У�������ź͹�����
					case 4:
						line=line.replace("inputnumber", creator.rules[0].number);
						line=line.replace("inputname", creator.rules[0].name);
						newbw.write(line);
						row++;
						break;
					//��6�У�����
					case 6:
						line=line.replace("inputauthor", creator.author);
						newbw.write(line);
						row++;
						break;
					//��7�У�����
					case 7:
						line=line.replace("inputdescription", creator.rules[0].description);
						newbw.write(line);
						row++;
						break;
					//��12�У�priority, category�� message
					case 12:
						line=line.replace("inputpriority", creator.rules[0].number);
						line=line.replace("inputcategory", creator.rules[0].category);
						line=line.replace("inputmessage", creator.rules[0].message);
						newbw.write(line);
						row++;
						break;
					//��13�У������͸�����
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
			
			//�رո�����
			newbw.close();
			newreader.close();
			fnew.close();
			egbr.close();
			egreader.close();
			feg.close();
		}
		catch (IOException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	//Ϊ������������Test�ű��ļ�
	private static void MakeTestFile4OneRule(Creator creator) {
		
	}
}
