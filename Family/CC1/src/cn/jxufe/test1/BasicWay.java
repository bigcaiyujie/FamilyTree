package cn.jxufe.test1;
import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import cn.jxufe.data.Data_xml;

public class BasicWay {
	private Data_xml data = new Data_xml("xml/name1.xml");
	private ArrayList<String> relative = this.data.getList();
	private ArrayList<ArrayList<String>> term = new ArrayList<>();
	public  void main(){
		String string="��飺��С����ԭ�����񷪣�1940��������������ݾɽ�ɽ���漮�й��㶫˳�¾������������������������ߡ����������ҡ�������ѧ�ҡ�UFC�����ߡ�MMA֮����������ʦ�������Ӱ�Ŀ����ߺͽ�ȭ����ʼ�ˡ���������Ӱ��Ա���й�������λȫ���ƹ��ߡ���������λ������Ա��������۵��Ĳ����Ӱ3�δ��ƶ����飺��С����ԭ�����񷪣�1940��������������ݾɽ�ɽ���漮�й��㶫˳�¾������������������������ߡ����������ҡ�������ѧ�ҡ�UFC�����ߡ�MMA֮����������ʦ�������Ӱ�Ŀ����ߺͽ�ȭ����ʼ�ˡ���������Ӱ��Ա���й�������λȫ���ƹ��ߡ���������λ������Ա��������۵��Ĳ����Ӱ3�δ��ƶ����¼�����С��������������������޵�ӰƱ����¼���������������ġ�����������ȫ����Ʊ����2.3����Ԫ��1962����С�����조�񷪹����ݡ���1967���Դ���ȭ����1973��7��20����С�����������������32���ꡣ1979�꣬������ɼ�����������������Ϸ���Ŀ�ӳ�գ�7��8�ն�Ϊ����С���ա���1993�꣬����������С������20������Ʊ�����������˴��������С�������ǻա�ͬ�꣬����۵�Ӱ���񽱴��䷢������ɾͽ�����1998��11�£����й�����Э��䷢��������Ӱ���ǽ�����1999�꡶ʱ���ܿ����г�20����Ӣ����ż��������������С����Ӣ���ѹ������찲�ȡ�������ͳ����ϵ�һͬ�ϰ���    ���մ��Ī�� ��    Ů �����������Ů�������� Ů��:�����������������Ů��������  Ů��:������  ������������Ȫ(������)";
		List<Term> parse = ToAnalysis.parse(string);
	}
	/*
	 * ���ף������ or ����������� or ���������
	 */
	public  void way(List<Term> parse){
		for(int i=0;i<parse.size();i++){
		if(relative.contains(parse.get(i).toString())){
			int a=i,b=i+1,c=i+2;
			//���������
			if(c<parse.size())
			if(Attri_peo(parse.get(c).toString())&&Attri(parse.get(b).toString())){
				//System.out.print(parse.get(a).toString()+parse.get(b).toString()+parse.get(c).toString());
				ArrayList<String> list=new ArrayList<>();
				list.add(parse.get(a).toString());
				list.add(parse.get(c).toString());
				check(list);
			}
			//���ף�/��/Ϊ�����
			if(b<parse.size())
			if(Attri_peo(parse.get(b).toString())){
				//System.out.print(parse.get(a).toString()+parse.get(b).toString());
				ArrayList<String> list=new ArrayList<>();
				list.add(parse.get(a).toString());
				list.add(parse.get(b).toString());
				check(list);
			}
		}
		}
	}
	

	/*
	 * ȡ��/������ַ�
	 */
	public  ArrayList<ArrayList<String>> splite(ArrayList<ArrayList<String>> list) {
		ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			ArrayList<String> arrayList1 = new ArrayList<>();
			for(int n=0; n<list.get(i).size();n++){
				if (list.get(i).get(n).contains("/")) {
					arrayList1.add(new String(list.get(i).get(n).substring(0, list.get(i).get(n).indexOf('/'))));
				}
			}
			arrayList.add(arrayList1);
		}
		return arrayList;
	}
	
	/*
	 * attribute_��
	 */
	public  boolean Attri_peo(String word) {
		if (word.contains("/nr")&&word.length()>4) {
			return true;
		} else
			return false;
	}
	/*
	 * attribute_����
	 */
	public  boolean Attri_rela(String word) {
		if (word.contains("/n")) {
			return true;
		} else
			return false;
	}
	/*
	 * �м��
	 */
	public  boolean Attri(String word) {
		if (word.contains("��/w")||word.contains(":")||word.contains("��")||word.contains("Ϊ")) {
			return true;
		} else
			return false;
	}
	/*
	 * ȥ���ظ���
	 */
	public void check(ArrayList<String> list) {
		boolean check = true;
		for (int i = 0; i < term.size(); i++) {
			if (list.equals(term.get(i))) {
				check = false;
			}
		}
		if(check)
			term.add(list);
	}
	
	public ArrayList<ArrayList<String>> getTerm() {
		return splite(term);
	}
}
