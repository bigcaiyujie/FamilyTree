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
		String string="简介：李小龙，原名李振藩，1940年出生于美国加州旧金山，祖籍中国广东顺德均安镇。他是世界武道变革先驱者、武术技击家、武术哲学家、UFC开创者、MMA之父、武术宗师、功夫电影的开创者和截拳道创始人、华人武打电影演员，中国功夫首位全球推广者、好莱坞首位华人演员。他在香港的四部半电影3次打破多项…简介：李小龙，原名李振藩，1940年出生于美国加州旧金山，祖籍中国广东顺德均安镇。他是世界武道变革先驱者、武术技击家、武术哲学家、UFC开创者、MMA之父、武术宗师、功夫电影的开创者和截拳道创始人、华人武打电影演员，中国功夫首位全球推广者、好莱坞首位华人演员。他在香港的四部半电影3次打破多项记录，其中《猛龙过江》打破了亚洲电影票房记录，他与好莱坞合作的《龙争虎斗》全球总票房达2.3亿美元。1962年李小龙开办“振藩国术馆”，1967年自创截拳道，1973年7月20日李小龙在香港逝世，享年32周岁。1979年，美国洛杉矶市政府将《死亡游戏》的开映日，7月8日定为“李小龙日”。1993年，美国发行李小龙逝世20周年纪念钞票，好莱坞名人大道铺上李小龙纪念星徽。同年，获香港电影金像奖大会颁发“终身成就奖”。1998年11月，获中国武术协会颁发“武术电影巨星奖”。1999年《时代周刊》列出20世纪英雄与偶像人物名单，李小龙与英国已故王妃黛安娜、美国总统肯尼迪等一同上榜。妻    子琳达·埃莫瑞 子    女 儿子李国豪、女儿李香凝 女儿:李香凝儿子李国豪、女儿李香凝  女儿:李香凝  父亲是李国豪李海泉(李满船)";
		List<Term> parse = ToAnalysis.parse(string);
	}
	/*
	 * 父亲：李国豪 or 父亲是李国豪 or 父亲李国豪
	 */
	public  void way(List<Term> parse){
		for(int i=0;i<parse.size();i++){
		if(relative.contains(parse.get(i).toString())){
			int a=i,b=i+1,c=i+2;
			//父亲李国豪
			if(c<parse.size())
			if(Attri_peo(parse.get(c).toString())&&Attri(parse.get(b).toString())){
				//System.out.print(parse.get(a).toString()+parse.get(b).toString()+parse.get(c).toString());
				ArrayList<String> list=new ArrayList<>();
				list.add(parse.get(a).toString());
				list.add(parse.get(c).toString());
				check(list);
			}
			//父亲：/是/为李国豪
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
	 * 取出/后面的字符
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
	 * attribute_人
	 */
	public  boolean Attri_peo(String word) {
		if (word.contains("/nr")&&word.length()>4) {
			return true;
		} else
			return false;
	}
	/*
	 * attribute_属性
	 */
	public  boolean Attri_rela(String word) {
		if (word.contains("/n")) {
			return true;
		} else
			return false;
	}
	/*
	 * 中间词
	 */
	public  boolean Attri(String word) {
		if (word.contains("：/w")||word.contains(":")||word.contains("是")||word.contains("为")) {
			return true;
		} else
			return false;
	}
	/*
	 * 去掉重复的
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
