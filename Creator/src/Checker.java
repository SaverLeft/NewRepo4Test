import java.io.File;

public class Checker {
	
	//������д����ļ�����
	public static void CheckAll(Creator createdata)
	{
		
	}
	
	//��������ļ����ļ������Ƿ���ȷ,������·�������ļ������Ͳ�����׺���ļ���
	public static boolean ValidFileCheck(String inputstr)
	{
		if(inputstr == null) return false;
		
		//ȥ����β�ո�
		while(inputstr.substring(0,1).equals(" ")) inputstr=inputstr.substring(1,inputstr.length());
		while(inputstr.substring(inputstr.length()-1,inputstr.length()).equals(" ")) inputstr=inputstr.substring(0,inputstr.length()-1);
		
		if(inputstr.length()==0) return false;
		
		if(inputstr.indexOf("/")!=-1) return false;
		if(inputstr.indexOf("\\")!=-1) return false;
		if(inputstr.indexOf(":")!=-1) return false;
		if(inputstr.indexOf("?")!=-1) return false;
		if(inputstr.indexOf("\"")!=-1) return false;
		if(inputstr.indexOf("<")!=-1) return false;
		if(inputstr.indexOf(">")!=-1) return false;
		if(inputstr.indexOf("|")!=-1) return false;
		if(inputstr.equalsIgnoreCase("nul")) return false;
		if(inputstr.equalsIgnoreCase("aux")) return false;
		if(inputstr.equalsIgnoreCase("con")) return false;
		if(inputstr.equalsIgnoreCase("com1")) return false;
		if(inputstr.equalsIgnoreCase("lpt1")) return false;
		return true;
	}
	/*
	//��������ļ�ȫ·���Ƿ����
	public static boolean FilePathTooLongCheck(String fullpath)
	{
		
	}
	*/
	//����ļ��Ƿ����,type=1��Ϊ�ļ���checker�ļ���2Ϊ�ű��ļ���3Ϊ�����ļ�,���������ļ�ֻ���_0��׺��Ĭ��_0������ʱ_0��_9��������
	public static boolean FileExistCheck(String folderpath,String filename,int type)
	{
		File file;
		switch(type)
		{
			case 1:file=new File(folderpath+filename+".java");break;
			case 2:file=new File("Test"+folderpath+filename+".java");break;
			case 3:file=new File(folderpath+filename+"_0.c");break;
			default: return false;
		}
		if(!file.exists()) return false;
		else return true;
	}
	
	//�������Ĺ�����Ƿ���ϸ�ʽ
	public static boolean RuleNumberCheck(String number)
	{
		String[] figures=number.split(".");
		for (int i = 0;i < figures.length; i++)
		{
			if (figures[i].length()==0) return false;
			for (int j = 0; i < figures[i].length(); j++)
				if (!Character.isDigit(figures[i].charAt(j))) return false;
		}
		return true;
	}
}
