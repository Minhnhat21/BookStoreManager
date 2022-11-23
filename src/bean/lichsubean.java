package bean;

public class lichsubean {
	private long makh;
	private String tensach;
	private long SoLuongMua;
	private long gia;
	private long thanhtien;
	private String NgayMua;
	private boolean damua;
	
	
	public lichsubean(long makh, String tensach, long soLuongMua, long gia, long thanhtien, String ngayMua,
			boolean damua) {
		super();
		this.makh = makh;
		this.tensach = tensach;
		SoLuongMua = soLuongMua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		NgayMua = ngayMua;
		this.damua = damua;
	}
	
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(String ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	
}
