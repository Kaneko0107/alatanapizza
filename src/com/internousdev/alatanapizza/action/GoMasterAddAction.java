package com.internousdev.alatanapizza.action;

import java.io.File;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GoMasterAddAction extends ActionSupport {
	private ArrayList<String> imageFileNames = new ArrayList<String>();

	public String execute() {
		String context = ServletActionContext.getServletContext().getRealPath("/images/newSide");
		File[] files = new File(context).listFiles();
		for (File file : files) {
		    if (file.isFile()) {
		        imageFileNames.add(file.getName());
		    }
		}
		return SUCCESS;
	}

	public ArrayList<String> getImageFileNames() {
		return imageFileNames;
	}

	public void setImageFileNames(ArrayList<String> imageFileNames) {
		this.imageFileNames = imageFileNames;
	}
}
