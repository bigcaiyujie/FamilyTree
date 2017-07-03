package cn.jxufe.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import cn.jxufe.data.CatchTxt;
import cn.jxufe.data.Data_xml;
import cn.jxufe.test.Family;

public class Way {
	public static final int BOUND = 3;
	private CatchTxt txt = new CatchTxt();
	private Family family = new Family();
	private Data_xml data = new Data_xml("xml/name1.xml");
	private BasicWay sd = new BasicWay();
	private ArrayList<String> relative = this.data.getList();

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	/*
	 * 把相应的人称，名字 放入到类中
	 */
	public ArrayList<ArrayList<String>>  word() {
		HashMap<String, Integer> map = this.data.getMap();
		String context = txt.readTxtFile();
		ArrayList<List<Term>> clearword = clear(context);
		for (int i = 0; i < clearword.size(); i++) {
			int num = 1;
			if (exit(clearword.get(i),"毛泽东/nr")) {
				while (num <= 10) { //范围在后10句之内
					sd.way(clearword.get(i));
					num++;
					if((i+1)<clearword.size())
					i++;
				}
			}
		}
		for (int i = 0; i < sd.getTerm().size(); i++) {
			System.out.println(sd.getTerm().get(i));
		}
		return sd.getTerm();
	}

	/*
	 * 判断出现最多的人物次数
	 */
	public String select(ArrayList<String> allPeo) {
		int n = 0;
		String keys = new String();
		Map<String, Integer> map = new HashMap<>();
		for (int s = 0; s < allPeo.size(); s++) {
			if (map.get(allPeo.get(s)) == null) {
				map.put(allPeo.get(s), 1);
			} else {
				int i = map.get(allPeo.get(s));
				map.put(allPeo.get(s), ++i);
			}
		}
		System.out.println(map);
		for (String key : map.keySet()) {
			if (map.get(key) > n) {
				n = map.get(key);
				keys = new String(key);
			}
		}
		return keys;
	}

	/*
	 * 分句 分词最终结果
	 */
	public ArrayList<List<Term>> clear(String str) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<List<Term>> list_term = new ArrayList<>();
		String[] word = str.split("[，。]");
		for (int i = 0; i < word.length; i++) {
			list.add(word[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			List<Term> parse = ToAnalysis.parse(list.get(i));
			list_term.add(parse);
		}
		return list_term;
	}
	
	public boolean exit(List<Term> parse,String str){
		boolean e=false;
		for(int i=0;i<parse.size();i++){
			if(parse.get(i).toString().equals(str))
				e=true;
		}
		return e;
	}
}
