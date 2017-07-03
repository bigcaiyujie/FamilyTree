package cn.jxufe.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class Data_xml {
	
	private ArrayList<String> list = new ArrayList<>();
	private HashMap<String,Integer> map = new HashMap<String,Integer>();
	private ArrayList<String> relative = new ArrayList<String>();
	public Data_xml(String file) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		this.add();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			for(int n=0;n<this.relative.size();n++){
			NodeList dogList = doc.getElementsByTagName(relative.get(n));	
			for (int i = 0; i < dogList.getLength(); i++) {
				Node dog = dogList.item(i);
//				System.out.print(dog.getFirstChild().getNextSibling()
//						.getNextSibling().getNextSibling().getNodeType());
				for (Node node = dog.getFirstChild(); node != null; node = node
						.getNextSibling()) {
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						String value = new String(node.getFirstChild().getNodeValue());
						this.list.add(value);
						this.map.put(value,(Integer)n);
						System.out.print(value+" "+map.get(value));
					}
				}
				System.out.println();
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(){
		this.relative.add("son");
		this.relative.add("daughter");
		this.relative.add("granddaughter");
		this.relative.add("grandson");
		this.relative.add("father");
		this.relative.add("mother");
		this.relative.add("grandmother");
		this.relative.add("grandfather");
		this.relative.add("wife");
		this.relative.add("oldbrother");
		this.relative.add("oldsister");
		this.relative.add("youngsister");
		this.relative.add("youngbrother");
	}
	public ArrayList<String> getList() {
		return list;
	}
	
	public HashMap<String, Integer> getMap() {
		return map;
	}
}