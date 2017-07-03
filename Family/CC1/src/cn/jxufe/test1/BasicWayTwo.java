package cn.jxufe.test1;

import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import cn.jxufe.data.CatchTxt;
import cn.jxufe.data.Data_xml;

public class BasicWay1 {
	private ArrayList<ArrayList<String>> list = new ArrayList<>();
	private CatchTxt txt = new CatchTxt();
	private Data_xml xml = new Data_xml("xml/name1.xml");
	
	public String findRelative(){
		String context = txt.readTxtFile();
		ArrayList<String> xml_data = xml.getList();
		List<Term> parse = ToAnalysis.parse(context);
		ArrayList<String> allRelative = new ArrayList<>();
		for(int i=0;i<parse.size();i++){
			if(xml_data.contains(parse.get(i).toString())){
				System.out.println(parse.get(i).toString());
				allRelative.add(parse.get(i).toString());
			}
		}
		
		Way way = new Way();
		String mostRelative=way.select(allRelative);
		return mostRelative;
		
	}

	
	
	
	
	
	/*
	 * 所有人都两两配对
	 */
	public void pipei(){
		Way way = new Way();
		for (int i = 0; i < way.word().size(); i++) {
		System.out.println(way.word().get(i));
	}
		for(int i=0;i<way.word().size();i++){
			for(int n=i+1;n<way.word().size();n++){
				ArrayList<String> list1 =new ArrayList<>();
				list1.add(way.word().get(i).get(1));
				list1.add(way.word().get(n).get(1));
				list.add(list1);
			}
		}
		System.out.print(list);
	}
}
