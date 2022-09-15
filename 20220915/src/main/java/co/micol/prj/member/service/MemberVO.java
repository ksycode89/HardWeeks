package co.micol.prj.member.service;

public class MemberVO {
private String  memberId;
private String  memberPassWord;
private String  memberName; 
private String  memberTel;
private String  memberAuthor;

public MemberVO() {
	super();
}

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
}

public String getMemberPassword() {
	return memberPassWord;
}

public void setMemberPassword(String memberPassword) {
	this.memberPassWord = memberPassword;
}

public String getMemberName() {
	return memberName;
}

public void setMemberName(String memberName) {
	this.memberName = memberName;
}

public String getMemberTel() {
	return memberTel;
}

public void setMemberTel(String memberTel) {
	this.memberTel = memberTel;
}

public String getMemberAuthor() {
	return memberAuthor;
}

public void setMemberAuthor(String memberAuthor) {
	this.memberAuthor = memberAuthor;
}

@Override
public String toString() {
	return "MemberVO [memberId=" + memberId + ", memberPassWord=" + memberPassWord + ", memberName=" + memberName
			+ ", memberTel=" + memberTel + ", memberAuthor=" + memberAuthor + "]";
}



}
