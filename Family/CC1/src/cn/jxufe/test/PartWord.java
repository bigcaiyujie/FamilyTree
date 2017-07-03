package cn.jxufe.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import cn.jxufe.data.CatchTxt;
import cn.jxufe.data.Data_xml;


public class PartWord {
	public static final int  BOUND=3;
	private String url ;
	private People people;
	private char first='��';
	private CatchTxt txt=new CatchTxt();
	private Family family = new Family();
	private Data_xml data = new Data_xml("xml/name.xml");
	private ArrayList<String> relative = this.data.getList();
	
//	public PartWord(People people){
//		this.people=people;
//		first='��';
//		this.spider=new Spider(people);
//	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	
	/*
	 * ����Ӧ���˳ƣ����� ���뵽����
	 */
	public  ArrayList<String> word() {
		HashMap<String, Integer> map = this.data.getMap();
		
		String context = txt.readTxtFile();
//		List<Term> parse = ToAnalysis.parse(context);
//		System.out.print(parse+"/n");
//		
//		ArrayList<Map<String, Object>> clearWord = clear(parse);
		ArrayList<ArrayList<Map<String, Object>>> clearword1 = clear1(context);
		ArrayList<String> pword = new ArrayList<>();
		ArrayList<String > allPeo = new ArrayList<>();
		for(int a=0;a<clearword1.size();a++){
			ArrayList<Map<String, Object>> clearWord = clearword1.get(a);
		for (int i = 0; i < clearWord.size(); i++) {
			if(relative.contains((String)(clearWord.get(i).get("word"))))
			switch (map.get((String)(clearWord.get(i).get("word")))) {
			case 0:   //����
				int n=i;
				i++;
				System.out.println("���ӹ���"+"  "+i+"  "+clearWord.size());
				while(i<clearWord.size()-1) {
					if(((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
						if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND){
						this.family.setSon(new People(((String)clearWord.get(i).get("word"))));
						//System.out.print((String)clearWord.get(i).get("word"));
						//System.out.print((int)clearWord.get(i).get("index"));
						}
						i++;
					}else break;
				}
				i--;
				break;
			case 1:   //Ů��
				n=i;
				i++;
				System.out.println("Ů������"+"  "+i+"  "+clearWord.size());
				while(i<clearWord.size()-1) {
					System.out.println("Ů������"+"  "+i+"  "+clearWord.size());
					if(((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
						if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND){
						this.family.setDaughter(new People(((String)clearWord.get(i).get("word"))));
						//System.out.print((String)clearWord.get(i).get("word")+" ");
						//System.out.print((int)clearWord.get(i).get("index")+" ");
						}	
						i++;
					}else break;
					
				}		
				i--;
				break;
//			case 2:   //��Ů
//				n=i;
//				i++;
//				while (((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					this.family.setGranddaughter(new People(((String)clearWord.get(i).get("word"))));
//					i++;
//				}
//				i--;
//				break;
//			case 3:   //����
//				n=i;
//				i++;
//				while (((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					this.family.setGrandson(new People(((String)clearWord.get(i).get("word"))));
//					i++;
//				}
//				i--;
//				break;
//			case 4:   //����
//				n=i;
//				i++;
//				if(((String)clearWord.get(i).get("word")).charAt(0) == '��'&&((String)clearWord.get(i).get("word")).length()!=1)
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					allPeo.add(((String)clearWord.get(i).get("word")));
//					family.setFather(new People(select(allPeo)));
//					allPeo.clear();
//				break;
//			case 5:   //ĸ��
//				n=i;
//				i++;
//				if(((String)clearWord.get(i).get("word")).length()!=1)
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					allPeo.add(((String)clearWord.get(i).get("word")));
//					family.setMather(new People(select(allPeo)));
//					allPeo.clear();
//				break;
//			case 6:   //��ĸ
//				n=i;
//				i++;
//				if(((String)clearWord.get(i).get("word")).length()!=1)
//					family.setGrandFather(new People(((String)clearWord.get(i).get("word"))));
//				else{
//					family.setGrandMather(new People(new String(((String)clearWord.get(i).get("word")))+((String)clearWord.get(++i).get("word"))));
//				}
//				break;
//			case 7:   //�游
//				n=i;
//				i++;
//				if(((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1)
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					allPeo.add(((String)clearWord.get(i).get("word")));
//					family.setGrandFather(new People(select(allPeo)));
//				break;
//			case 8://����
//				n=i;
//				i++;
//				if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//				if(((String)clearWord.get(i).get("word")).length()!=1)
//					allPeo.add(((String)clearWord.get(i).get("word")));
//					family.setWife(new People(select(allPeo)));
//					allPeo.clear();
//				break;
//			case 9:   //���
//				n=i;
//				i++;
//				while (((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					this.family.setOlderBrother(new People(((String)clearWord.get(i).get("word"))));
//					i++;
//				}
//				i--;
//				break;
//			case 10:   //���
//				n=i;
//				i++;
//				while (((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					this.family.setOlderSister(new People(((String)clearWord.get(i).get("word"))));
//					i++;
//				}
//				i--;
//				break;
//			case 11:   //����
//				n=i;
//				i++;
//				while (((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					this.family.setYoungerBrother(new People(((String)clearWord.get(i).get("word"))));
//					i++;
//				}
//				i--;
//				break;
//			case 12:   //�ܵ�
//				n=i;
//				i++;
//				while (((String)clearWord.get(i).get("word")).charAt(0) == first&&((String)clearWord.get(i).get("word")).length()!=1){
//					if((int)(clearWord.get(i).get("index"))-(int)(clearWord.get(n).get("index"))<BOUND)
//					this.family.setYoungerSister(new People(((String)clearWord.get(i).get("word"))));
//					i++;
//				}
//				i--;
//				break;
			default:
				break;
			}
		}
		}
		return pword;
	}
	
	/*
	 * ��������������
	 */
	public  ArrayList<Map<String, Object>> clear(List<Term> parse1) {
		ArrayList<Map<String, Object>> clearWord = new ArrayList<>();
		// �ֳ��˳ƣ����֣���hashMap ��¼���ǵ�index�±�
		for (int i = 0; i < parse1.size(); i++) {
			if (relative.contains(splite(parse1.get(i).toString())) || wordAttr(parse1.get(i).toString())) {
				Map<String, Object> map = new HashMap<>();
				map.put("word",splite(parse1.get(i).toString()));
				map.put("index",i);
				//System.out.print(i);
				clearWord.add(map);
				//System.out.print(splite(parse1.get(i).toString()) + "  ");
			}
		}
		
		//System.out.println("\n");
		return clearWord;
	}

	/*
	 * ȡ��/������ַ�
	 */
	public static String splite(String word) {
		if (word.contains("/")) {
			word = new String(word.substring(0, word.indexOf('/')));
		}
		return word;
	}

	/*
	 * �ж�/���������
	 */
	public static boolean wordAttr(String word) {
		if (word.contains("/nr")) {
			return true;
		} else
			return false;
	}
	/*
	 * �жϳ��������������
	 */
	public String select(ArrayList<String> allPeo){
		int n=0;
		String keys = new String();
		Map<String ,Integer> map = new HashMap<>();
		for(int s=0;s<allPeo.size();s++){
		if(map.get(allPeo.get(s))==null){
			map.put(allPeo.get(s), 1);
		}else{
			int i=map.get(allPeo.get(s));
			map.put(allPeo.get(s),i++);
		}
		}
		for(String key:map.keySet()){
			if(map.get(key)>n){
				n=map.get(key);
				keys=new String(key);
			}
		}
		return keys;
	}
	
	
	public void display(){
		ArrayList<String> word = word();
		System.out.print("\n"+word);
		//System.out.print(word);
		family.display();
	}
	public  ArrayList<ArrayList<Map<String, Object>>> clear1(String str){
		ArrayList<String> list = new ArrayList<>();
		ArrayList<ArrayList<Map<String, Object>>> clearword = new ArrayList<>();
		String[] word = str.split("[����]");
		for(int i=0;i<word.length;i++){
				list.add(word[i]);
		}
		for(int i=0;i<list.size();i++){
			//System.out.println(list.size()+"  "+i+"  "+list.get(i)+"asd");
			List<Term> parse = ToAnalysis.parse(list.get(i));
			//System.out.print(parse+"/n");
			ArrayList<Map<String, Object>> clearWord1 = clear(parse);
            if(clearWord1.size()>1)
		    clearword.add(clearWord1);
		}
		return clearword;
	}
	
}
