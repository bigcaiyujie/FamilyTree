package cn.jxufe.test;

import java.util.ArrayList;

public class Family {

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	private ArrayList<People> olderBrother = new ArrayList<People>();
	private ArrayList<People> youngerBrother = new ArrayList<People>();
	private ArrayList<People> olderSister = new ArrayList<People>();
	private ArrayList<People> youngerSister = new ArrayList<People>();
	private ArrayList<People> son = new ArrayList<People>();
	private ArrayList<People> daughter = new ArrayList<People>();
	private ArrayList<People> grandson = new ArrayList<People>();
	private ArrayList<People> granddaughter = new ArrayList<People>();
	private ArrayList<People> allPeople = new ArrayList<People>();
	private People father;
    private People mather;
	private People grandFather;
	private People grandMather;
	private People wife;
	private People people;
	public People getWife() {
		return wife;
	}

	public void setWife(People wife) {
		if (check(wife)) {
			this.wife = wife;
			setAllPeople(wife);
		}
	}

	public ArrayList<People> getOlderBrother() {
		return olderBrother;
	}

	public void setOlderBrother(People people) {
		if (check(people)) {
			this.olderBrother.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getYoungerBrother() {
		return youngerBrother;
	}

	public void setYoungerBrother(People people) {
		if (check(people)) {
			this.youngerBrother.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getOlderSister() {
		return olderSister;
	}

	public void setOlderSister(People people) {
		if (check(people)) {
			this.olderSister.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getYoungerSister() {
		return youngerSister;
	}

	public void setYoungerSister(People people) {
		if (check(people)) {
			this.youngerSister.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getSon() {
		return son;
	}

	public void setSon(People people) {
		if (check(people)) {
			this.son.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getDaughter() {
		return daughter;
	}

	public void setDaughter(People people) {
		if (check(people)) {
			this.daughter.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getGrandson() {
		return grandson;
	}

	public void setGrandson(People people) {
		if (check(people)) {
			this.grandson.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getGranddaughter() {
		return granddaughter;
	}

	public void setGranddaughter(People people) {
		if (check(people)) {
			this.granddaughter.add(people);
			setAllPeople(people);
		}
	}

	public ArrayList<People> getAllPeople() {
		return allPeople;
	}

	public void setAllPeople(People people) {
		if (check(people)) {
			this.allPeople.add(people);
			setAllPeople(people);
		}
	}

	public People getFather() {
		return father;
	}

	public void setFather(People father) {
		this.father=father;
		System.out.print(father.getName());
	}

	public People getMather() {
		return mather;
	}

	public void setMather(People mather) {
		if (check(mather)) {
			this.mather = mather;
			setAllPeople(mather);
		}
	}

	public People getGrandFather() {
		return grandFather;
	}

	public void setGrandFather(People grandFather) {
		if (check(grandFather)) {
			this.grandFather = grandFather;
			setAllPeople(grandFather);
		}
	}

	public People getGrandMather() {
		return grandMather;
	}

	public void setGrandMather(People grandMather) {
		if (check(grandMather)) {
			this.grandMather = grandMather;
			setAllPeople(grandMather);
		}
	}

	public boolean check(People people) {
		boolean check = true;
		for (int i = 0; i < allPeople.size(); i++) {
			if (people.getName().equals(allPeople.get(i).getName())) {
				check = false;
			}
		}
		return check;
	}

	public void display() {
		try {
			for (int i = 0; i < son.size(); i++) {
				System.out.println("¶ù×Ó£º " + son.get(i).getName());
			}
		} catch (Exception ex) {
			System.out.print(ex);
		}
		try{
		for(int i=0;i<daughter.size();i++){
		System.out.println("Å®¶ù£º "+daughter.get(i).getName());
		}
		}catch(Exception ex){
			System.out.print(ex);
		}
		try{
		System.out.println("¸¸Ç×£º "+father.getName());
		}catch(Exception ex){
			System.out.print(ex);
		}
		try{
		System.out.println("·òÆÞ£º "+wife.getName());
		}catch(Exception ex){
			System.out.print(ex);
		}
		try{
		for(int i=0;i<olderBrother.size();i++){
		System.out.println("¸ç¸ç£º "+olderBrother.get(i).getName());
		}
		}catch(Exception ex){
			System.out.print(ex);
		}
		try{
		System.out.println("Ä¸Ç×£º "+mather.getName());
		}catch(Exception ex){
			System.out.print(ex);
		}

	}
}
