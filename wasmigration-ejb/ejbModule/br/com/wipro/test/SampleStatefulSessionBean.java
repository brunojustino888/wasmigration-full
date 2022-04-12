package br.com.wipro.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class SampleStatefulSessionBean implements SampleSessionBeanRemote{

	private List<String> stringList;
	
	@PostConstruct
	public void init() {
		this.stringList = new ArrayList<String>();
	}
	
	@Override
	public void addString(String string) {
		this.stringList.add(string);
	}

	@Override
	public List<String> getList() {
		return this.stringList;
	}

}