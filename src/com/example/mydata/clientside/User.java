package com.example.mydata.clientside;

import java.sql.Timestamp;


public class User {

	private Integer uid;
	private String login;
	private String ln;
	private String fn;
	private String mn;
	private String cln;
	private String cfn;
	private String cmn;
	private Timestamp TS;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getCln() {
		return cln;
	}

	public void setCln(String cln) {
		this.cln = cln;
	}

	public String getCfn() {
		return cfn;
	}

	public void setCfn(String cfn) {
		this.cfn = cfn;
	}

	public String getCmn() {
		return cmn;
	}

	public void setCmn(String cmn) {
		this.cmn = cmn;
	}

	public Timestamp getTS() {
		return TS;
	}

	public void setTS(Timestamp tS) {
		TS = tS;
	}
        
        public String getName(){
            String name = getFn();
            if(getMn() != null){
                name+= " " + getMn();
            }
            if(getLn() != null){
                name+= " " + getLn();
            }

            return name;
        }

}
