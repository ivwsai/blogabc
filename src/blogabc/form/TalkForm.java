package blogabc.form;

public class TalkForm {
	// 作业
	private String exercise;
	// 介绍
	private String howto;
	// 引入
	private String introduction;
	private String persons;
	private byte[] attachment1;
	private byte[] attachment2;
	private byte[] attachment3;

	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public String getHowto() {
		return howto;
	}
	public void setHowto(String howto) {
		this.howto = howto;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPersons() {
		return persons;
	}
	public void setPersons(String persons) {
		this.persons = persons;
	}
	public byte[] getAttachment1() {
		return attachment1;
	}
	public void setAttachment1(byte[] attachment1) {
		this.attachment1 = attachment1;
	}
	public byte[] getAttachment2() {
		return attachment2;
	}
	public void setAttachment2(byte[] attachment2) {
		this.attachment2 = attachment2;
	}
	public byte[] getAttachment3() {
		return attachment3;
	}
	public void setAttachment3(byte[] attachment3) {
		this.attachment3 = attachment3;
	}
	
	public String getAttachmentName1(){
		if(attachment1.length>0){
			return new String(attachment1);
		}
		return null;
	}
	
	public String getAttachmentName2(){
		if(attachment2.length>0){
			return new String(attachment2);
		}
		return null;
	}
	
	public String getAttachmentName3(){
		if(attachment3.length>0){
			return new String(attachment3);
		}
		return null;
	}
}
