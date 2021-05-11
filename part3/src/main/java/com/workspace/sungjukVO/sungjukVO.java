package com.workspace.sungjukVO;

public class sungjukVO {
	private String jungong;  // 전공
	private String name;     // 이름
	private String junge;    // 전산학개론
	private String java;     // 자바
	private String program;  // 프로그래밍
	private String tongge;   // 통계학
	private String juneng;   // 전산영어
	private String junCal;   // 전산수학
	private String junSec;   // 전공 과목 
	private String total;    //합계
	private double avg;     //평균
	
	public void calData() {
		this.total = this.junge + this.java +this.program
					+this.tongge+this.juneng+this.junCal+this.junSec;
		//this.avg = Math.round(this.total/7.0);
	}
	
	public String getJungong() {
		return jungong;
	}
	public void setJungong(String jungong) {
		this.jungong = jungong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJunge() {
		return junge;
	}
	public void setJunge(String junge) {
		this.junge = junge;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getTongge() {
		return tongge;
	}
	public void setTongge(String tongge) {
		this.tongge = tongge;
	}
	public String getJuneng() {
		return juneng;
	}
	public void setJuneng(String juneng) {
		this.juneng = juneng;
	}
	public String getJunCal() {
		return junCal;
	}
	public void setJunCal(String junCal) {
		this.junCal = junCal;
	}
	public String getJunSec() {
		return junSec;
	}
	public void setJunSec(String junSec) {
		this.junSec = junSec;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		
		return "sungjukVO[name ="+name+",junge="+junge+",java="+java
		                 +",program= "+program+",tongge="+tongge+",juneng="+juneng
		                 +",junCal="+junCal+",junSec="+junSec+",total="+total+",avg="+avg+"]";
	}
}
