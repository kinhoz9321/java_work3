package test.member.dto;

public class MemberDto {
	//필드(private 설정 객체 내부에서만 참조 가능)
	private int num;
	private String name;
	private String addr;
	
	//디폴트 생성자
	public MemberDto() {}

	//생성자 (Generate Constructor using fields)
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	//getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
