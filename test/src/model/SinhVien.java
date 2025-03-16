package model;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private String diaChi;
	private String sDT;

	public SinhVien() {

	}

	public SinhVien(String maSV, String tenSV, String diaChi, String sDT) {
		setMaSV(maSV);
		setTenSV(tenSV);
		setDiaChi(diaChi);
		setsDT(sDT);
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String toString() {
		return String.format("%-10s | %-10s | %-10s | %-10s", this.getMaSV(), this.getTenSV(), this.getDiaChi(),
				this.getsDT());

	}
}